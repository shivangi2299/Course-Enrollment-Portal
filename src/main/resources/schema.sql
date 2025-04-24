CREATE TABLE IF NOT EXISTS Students (
    studentIdNumber INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    emailId VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL
);
-- Create Users table if it doesn't exist
CREATE TABLE IF NOT EXISTS Users (
    emailId VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL
);

--CREATE TABLE IF NOT EXISTS Course_Catalog (
--	courseId INT PRIMARY KEY,
--	courseName VARCHAR(100) NOT NULL,
--	Course_Description VARCHAR(255) NOT NULL,
--	Instructor_ID INT NOT NULL,
--	Course_Credits INT
--);
--
--CREATE TABLE IF NOT EXISTS Enrollment (
--    Enrollment_Id INT PRIMARY KEY,
--    student_id INT NOT NULL,
--    courseId INT NOT NULL
--);
--
--CREATE TABLE IF NOT EXISTS Course_Description (
--    courseDescriptionId INT PRIMARY KEY,
--    courseId INT,
--    instructorId INT,
--    room VARCHAR(255),
--    date DATE,
--    time TIME,
--    meetingInfo VARCHAR(255),
--    materials VARCHAR(255)
--);
--
--CREATE TABLE IF NOT EXISTS Instructor (
--    instructorId INT PRIMARY KEY,
--    instructorName VARCHAR(255),
--    instructorDescription VARCHAR(255),
--    meetingHours TIME,
--    instructorCabinLocation VARCHAR(255)
--);
--
--CREATE TABLE IF NOT EXISTS Student_Accounts (
--    studentAccountsId INT PRIMARY KEY,
--    student_id INT,
--    balance DOUBLE
--);
