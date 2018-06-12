## **Student Registration Program**
### _Java Programming I : Team A_
##### UC Irvine Extension Spring 2018 


We have built a console-based application that serves as a self-service course registration system like those used by colleges and universities. The program has several key features to ensure it meets functionality expectations for programs of this kind as well as security of student information.

_This program was built to fulfill course requirements for the Spring 2018 session of Java Programming I through UC Irvine Extension.
Contributers include:_

- @hycliff
- @hghMH
- @JasonDanielLyle
- @lmfreeee
- @Ken-Watson

### **Program Functionalities**

The program has four main functionalities:

1. A login window that authenticates existing users and creates files for new users 
2. A student profile page that displays courses in which the student is currently enrolled
3. The ability to view all available courses and register for the desired course from that screen
4. A registration status screen that indicates success or failure in registering for the desired course

### **Program Features**

The program has a basic UI that provides several features intended to keep the registration process simple and straightforward for the user:

1. A welcome screen from which the student/user may choose whether they would like to view and enroll in available courses or view and un-enroll from currently enrolled courses 
2. An alphabetical list of courses that inclues the course name, course number, course description, meeting time, start and end date, number of students currently enrolled, and enrollment capacity
3. The ability for the student/user to enroll and un-enroll from a course
4. A page where the student/user may view courses for which they are already registered

### **Program Safeguards**

The program will not permit enrollment if any of the following criteria are violated:

1. The course does not exist
2. The course is already at maximum capacity

The program will not permit a student to un-enroll from a course if any of the following criteria are violated:

1. The student is not currently enrolled in the course from which they are attempting to un-enroll
2. The current number of students already enrolled in the course is zero

For privacy reasons, the program also does not allow a student to see the registration information of another student. 
