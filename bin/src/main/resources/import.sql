-- Insert student data

INSERT INTO students(student_id_number, name, email_id, number,role, password) VALUES (123456789, 'ABC', 'ABC@example.com', '2246387532', 'USER', 'ABC@123');
INSERT INTO students(student_id_number, name, email_id, number,role, password) VALUES (987654321, 'CDE', 'CDE@example.com', '2257865437', 'USER', 'CDE@123');
INSERT INTO students(student_id_number, name, email_id, number,role, password) VALUES (114365567, 'FGH', 'FGH@example.com', '2235679043', 'USER', 'FGH@123');
INSERT INTO students(student_id_number, name, email_id, number,role, password) VALUES (978563412, 'IJK', 'IJK@example.com', '2247864538', 'USER', 'IJK@123');

--
---- Insert user data
--INSERT INTO users(emailId, password) VALUES ('ABC@example.com', 'ABC@123');
--INSERT INTO Users(emailId, password) VALUES ('CDE@example.com', 'CDE@123');
--INSERT INTO Users(emailId, password) VALUES ('FGH@example.com', 'FGH@123');
--INSERT INTO Users(emailId, password) VALUES ('IJK@example.com', 'IJK@123');

-- Insert advisor data
INSERT INTO advisors(advisor_id, name, email) VALUES (10101, 'alice', 'alice@test.com')
INSERT INTO advisors(advisor_id, name, email) VALUES (11235, 'bob', 'bob@test.com')
INSERT INTO advisors(advisor_id, name, email) VALUES (12312, 'charlie', 'charlie@test.com')


---- Insert into Enrollment table
--INSERT INTO Enrollment(Enrollment_Id, student_id, courseId) VALUES (1, 123456789, 101);
--INSERT INTO Enrollment(Enrollment_Id, student_id, courseId) VALUES (2, 123456789, 101);
--INSERT INTO Enrollment(Enrollment_Id, student_id, courseId) VALUES (3, 987654321, 102);

-- Insert into instructor table
INSERT INTO instructor(instructor_id, instructor_name, instructor_description, meeting_hours, instructor_cabin_location) VALUES (201, 'John Doe', 'Experienced software engineer', '08:00:00', 'Building A, Room 101');
INSERT INTO instructor(instructor_id, instructor_name, instructor_description, meeting_hours, instructor_cabin_location) VALUES (202, 'Alice Smith', 'Data science expert', '10:00:00', 'Building B, Room 201');
INSERT INTO instructor(instructor_id, instructor_name, instructor_description, meeting_hours, instructor_cabin_location) VALUES (203, 'David Brown', 'Network security specialist', '13:00:00', 'Building C, Room 301');
-- Insert into Catalog table
INSERT INTO course_catalog(course_id, course_name, course_description, instructor_id, course_credits) VALUES (101, 'Database Systems', 'Introduction to Database Design', 201, 3);
INSERT INTO course_catalog(course_id, course_name, course_description, instructor_id, course_credits) VALUES (102, 'Machine Learning', 'Advanced machine learning concepts', 202, 4);

-- Insert into Course Description table
INSERT INTO course_description(course_description_id, course_id, instructor_id, room, date, time, meeting_info, materials) VALUES (1, 101, 201, 'Room A', '2024-05-10', '09:00:00', 'https://meet.google.com/ket-hpvy-zmh', 'http://knking.com/books/c2/');
INSERT INTO course_description(course_description_id, course_id, instructor_id, room, date, time, meeting_info, materials) VALUES (2, 102, 202, 'Room B', '2024-05-12', '14:00:00', 'https://meet.google.com/ket-hpvy-zmh', 'https://xuanhien.wordpress.com/wp-content/uploads/2011/04/database-management-systems-raghu-ramakrishnan.pdf');
--INSERT INTO course_description(courseDescriptionId, courseId, instructorId, room, date, time, meeting_info, materials) VALUES (3, 103, 203, 'Room C', '2024-05-15', '11:00:00', 'Machine Learning Fundamentals', 'Online Resources');

-- Insert into Student Account table
INSERT INTO student_accounts(student_accounts_id, student_id, balance) VALUES (1, 123456789, 100.00);
INSERT INTO student_accounts(student_accounts_id, student_id, balance) VALUES (2, 987654321, 200.00);
INSERT INTO student_accounts(student_accounts_id, student_id, balance) VALUES (3, 114365567, 150.00);


-- Insert initial data into the Inventory table
INSERT INTO inventory (resource_id, resource_name, type, status, max_quantity, available_quantity) VALUES (1, 'Laptop', 'Electronics', 'Available', 10, 10);
INSERT INTO inventory (resource_id, resource_name, type, status, max_quantity, available_quantity) VALUES (2, 'Projector', 'Electronics', 'Available', 5, 5);
INSERT INTO inventory (resource_id, resource_name, type, status, max_quantity, available_quantity) VALUES (3, 'Microphone', 'Audio', 'Available', 15, 15);

-- Insert initial data into the Rentals table
INSERT INTO rental (id, equipment_id, user_email, rental_date, return_date) VALUES (1, 2, 'user1@example.com', '2024-04-01', '2024-04-10');
INSERT INTO rental (id, equipment_id, user_email, rental_date, return_date) VALUES (2, 1, 'user2@example.com', '2024-04-05', '2024-04-15');