create table student (
   studentID integer auto_increment not null,
   firstName varchar(255) not null,
   lastName varchar(255) not null,
   primary key(studentID)
);

create table subject (
   subjectID integer auto_increment not null,
   subjectName varchar(255) not null,
   primary key(subjectID)
);

create table studSub(
   studSubID integer auto_increment not null,
   subjectID varchar(255) not null,
   studentID varchar(255) not null,
   FOREIGN KEY (studentID) REFERENCES student(studentID),
   FOREIGN KEY (subjectID) REFERENCES subject(subjectID)
);

create table grades(
   studentID integer not null unique,
   subjectID integer not null unique,
   grade integer not null,
   FOREIGN KEY (studentID) REFERENCES student(studentID),
   FOREIGN KEY (subjectID) REFERENCES subject(subjectID)
);