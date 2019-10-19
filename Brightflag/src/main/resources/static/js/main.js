var app = angular.module('bfCodeTest', ['ngRoute']);

app.config(function($routeProvider) {
	  $routeProvider
	  .when("/", {
	    templateUrl : "subjects.htm",
	    controller: "subjectCtrl"
	  })
	  .when("/students", {
	    templateUrl : "students.htm",
	    controller : "studentCtrl"
	  })
	  .when("/exam", {
	    templateUrl : "exam.htm",
	    controller : "examCtrl"
	  })
	  .when("/grade", {
	    templateUrl : "/grades.htm",
	    controller : "gradeCtrl"
	  });
	  
	  
	});

app.controller('studentCtrl', function($scope, $location, $http) {

	$http.get('http://localhost:8080/api/getStudents')
	.then(function(resStu) {
		$http.get('http://localhost:8080/api/getSubjects')
		.then(function(resSub) {
			$scope.students = resStu.data;
			$scope.subjects = resSub.data;
		});
	});
	
	$scope.saveDetails = function(id, subject) {
		$http.get('http://localhost:8080/api/setStudentWithStudent?sub='+ subject +"&stu=" + id)
		.then(function(response) {
			console.log(response);
		});
    };
});

app.controller('examCtrl', function($scope, $location, $http){

	$http.get('http://localhost:8080/api/getStudents')
	.then(function(response) {
		var studentArray = response.data;
		studentArray.forEach((ele,index)=>{
			$http.get('http://localhost:8080/api/getSubjectsForStudent?id='+ele.studentID)
			.then(function(resStudSub) {
				studentArray[index].subjects = resStudSub.data;
				if(index == studentArray.length - 1){
					$scope.studentInfo = studentArray;
				}
			});
		});
	});

	$scope.saveDetails = function(id, subject, grade) {
		$http.get('http://localhost:8080/api/setGrade?sub='+ subject +"&stu=" + id + "&grade="+ grade)
		.then(function(response) {
			console.log(response);
		});
    };
});

app.controller('gradeCtrl', function($scope, $location, $http){

	$http.get('http://localhost:8080/api/getGrades')
	.then(function(response) {
		console.log(response.data);
		$scope.grades = response.data;
	});
});

app.controller('subjectCtrl', function($scope, $location, $http){
	$scope.saveSubject = function (subject){
		$http.get('http://localhost:8080/api/addSubject?sub='+subject)
		.then(function(response) {
			console.log(response.data);
		});
	};
});