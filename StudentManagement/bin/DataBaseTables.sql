CREATE DATABASE StudentManagement;
USE StudentManagement;

drop table if exists Students;
drop table if exists Teacher;
drop table if exists Notice_Board;
drop table if exists Course;
drop table if exists Subjects;
drop table if exists Attendance;
drop table if exists Time_Table;
drop table if exists Exam_Performance;
drop table if exists Admin;



create table Students(Roll_No int(5) not null auto_increment,Prn int(11),FirstName varchar(15),MiddleName varchar(15),LastName varchar(15),Email varchar(50),Mobile varchar(12),Photo varchar(30),Password varchar(120),Course varchar(10),Password_Status int(1),Address varchar(20),primary key(Roll_No));
create table Teacher(TeacherId int not null auto_increment,First_Name varchar(15),Middle_Name varchar(15),Last_Name varchar(15),Email varchar(50),Password varchar(120),Subject varchar(20),primary key(TeacherId));
create table Course(CourseId int auto_increment,Name varchar(10),primary key(CourseId));
create table Subjects(SubjectId int auto_increment not null,Name varchar(20),CourseId int(2),TeacherId int(2),primary key(SubjectId));
alter table Subjects add constraint CourseId FOREIGN KEY ( CourseId ) references Course(CourseId);
alter table Subjects add constraint TeacherId FOREIGN KEY ( TeacherId ) references Teacher(TeacherId);

create table Notice_Board(NoticeId int auto_increment not null,Course_Name int(3), Title varchar(50),Description varchar(50),Notice_Date DATE,primary key(NoticeId));
alter table Notice_Board add constraint Course_Name FOREIGN KEY ( Course_Name ) references Course(CourseId);

create table Attendance(Attendance_Id int(5) not null auto_increment ,Teacher_Id int(2) ,Student_Id int(3),Course_Id int(3),Subject varchar(50),Present_Absent varchar(10),date DATE,primary key(Attendance_Id));
alter table Attendance add constraint Student_Id FOREIGN KEY ( Student_Id ) references Students(Roll_No);
alter table Attendance add constraint Course_Id  FOREIGN KEY ( Course_Id  ) references Course(CourseId);
alter table Attendance add constraint Teacher_Id   FOREIGN KEY ( Teacher_Id  ) references Teacher(TeacherId);

create table Time_Table(Day varchar(20),Date DATE,ZoomId varchar(20),zoomPassword varchar(20),Course int(2));
alter table Time_Table add constraint Course FOREIGN KEY ( Course ) references Course(CourseId);


create table Exam_Performance(Roll_No int(6),Subject_Id int(2),Internal_Marks int(2),Lab_Marks int(2),Total int(3),Status varchar(10));
alter table Exam_Performance add constraint Subject_Id FOREIGN KEY ( Subject_Id ) references Subjects(SubjectId);


create table Admin(AdminId int(2) not null auto_increment,Name varchar(50),Email varchar(50),Password varchar(120),primary key(AdminId));

