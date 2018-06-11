
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Course {
	// data fields
		private String courseName;			//name of course
		private String courseID;			//course ID number as string of letters, numbers, or combination
		private String courseDescription;	//course summary
		private String meetingTime;			//course meeting time (e.g. 11:00-13:00)
		private int currentEnrollment;		//number of students currently enrolled
		private int enrollmentLimit;		//max capacity for course
		private String startDate;			//course start date
		private String endDate;				//course end date
	
		ArrayList<String> coursesOffered= new ArrayList<>();		//create new Array to list course offerings
		
		
		// constructors
		Course(){}
		
		Course (String courseID, String courseName, String courseDescription, String meetingTime, String startDate, String endDate, int enrollmentLimit, int currentEnrollment)	{
			// throw exceptions
			if(currentEnrollment > enrollmentLimit)
				throw new IllegalArgumentException("Course has already reached enrollment capacity.");
			if(currentEnrollment < 0)
				throw new IllegalArgumentException("Course enrollment must be at least 0.");
			if(enrollmentLimit < 1)
				throw new IllegalArgumentException("Course enrollment must be at least 0");
			
			this.courseID = courseID;
			this.courseName = courseName;
			this.courseDescription = courseDescription;
			this.meetingTime = meetingTime;
			this.startDate = startDate;
			this.endDate = endDate;
			
			this.enrollmentLimit = enrollmentLimit;
			this.currentEnrollment = currentEnrollment;
			
		}
		
		//read in all course data into ArrayList
		//return type ArrayList<String>
		public ArrayList<String> getCourselist(){
			String[] lineArray;
			ArrayList<String> courseInfo = new ArrayList<String>();
			
			//new file object
        	//File file = new File("StudentLists.txt");
			
			FileReadWrite courses = new FileReadWrite();
			String text = courses.ReadAllCourses();

			lineArray = text.split("[,]");
            	
        	//add data to the arraylist
        	 for (int i = 0; i < lineArray.length; i++) {
        		 courseInfo.add(lineArray[i]);
        	 }
        	 
        	 return courseInfo;
		}
		
		// accessors
		public String getCourseName()	{
			return courseName;
		}
		
		public String getCourseID()	{
			return courseID;
		}
		
		public String getCourseDescription()	{
			return courseDescription;
		}
		
		public String getMeetingTime()	{
			return meetingTime;
		}
		
		public String getStartDate()	{
			return startDate;
		}
		
		public String getEndDate()	{
			return endDate;
		}
		
		public int getEnrollmentLimit()	{
			return enrollmentLimit;
		}
		
		public int getCurrentEnrollment()	{
			return currentEnrollment;
		}
		
		// ensure enrollment limit is not exceeded or that enrollment does not drop below 0 
		
		public boolean addEnrollment()	{
			if (currentEnrollment >= enrollmentLimit)
				return false;
			
			currentEnrollment++;
			return true;
		}
		
		public boolean subtractEnrollment()	{
			if (currentEnrollment <  0)
				return false;
			
			currentEnrollment--;
			return true;
		} 
		// display all course information as a string
		@Override
		public String toString()	{
			return courseID + " " + courseName + ":" + courseDescription + " " + getStartDate() + " to " + getEndDate() + ";" + currentEnrollment + " of " + enrollmentLimit + " seats filled.";
		}

}
