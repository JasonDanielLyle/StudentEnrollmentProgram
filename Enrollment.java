

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Enrollment  extends JFrame {

	private static final long serialVersionUID = 1L; 
	JButton bt1; 			//Register
	JButton bt2; 			//Cancel
	JLabel title; 			//Window Title
	JLabel coursenum; 		//coursenum field label
	JTextField coursetext; 	//coursenum text
	JLabel courselist; 		//courselist label
	
	
	public Enrollment(String ID, String uname, String fname, String lname){

		
		//labels and buttons
		title = new JLabel("Course Enrollment For Student " + fname + " " + lname + "   (ID: " + ID + ")");
		coursenum = new JLabel(" Please Enter the Course Number: ");
		coursetext = new JTextField(150);
		
		Course courses = new Course();
		ArrayList<String> list = courses.getCourselist();
		String coursestring = new String();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
		 sb.append(list.get(i));
		 sb.append('\n');
		}
		coursestring = sb.toString();
		
		courselist = new JLabel(coursestring);
		
		
		
		
		bt1 = new JButton("Register");
		bt2 = new JButton("Cancel");
		bt3 = new JButton("Un-Register");
		
		//panels
		JPanel header = new JPanel(new FlowLayout());
		JPanel select = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		
		//action listener - enroll into class
		bt1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			// Hold one line at a time
		        String line = null;
		        String[] lineArray;
		        ArrayList<String> ClassInfo = new ArrayList<String>();
		        String coursenum = "";
		        String coursename = "";
		        String coursedescription = "";
		        String meetingtime = "";
				String startdate = "";
				String enddate = "";
				String enrollmentlimit = "";
				String currentenrollment = "";
		        boolean courseExists = false;
				boolean courseHasSpace = false;
				boolean studentEnrolled = false;
		        
				try{
					//new file object
		        	File file = new File("AllCourseList.txt");
		     
		        	//read in file contents
		        	Scanner input = new Scanner(file);
		            while(input.hasNext()){
		            	line = input.nextLine();
		            	lineArray = line.split("[,]");
		            	
		            	//add data to the arraylist
		            	 for (int i = 0; i < lineArray.length; i++) {
		            		 ClassInfo.add(lineArray[i]);
		            	 }
		            	 
		            	 
		            	 //check the courseid and make sure it's in the file
		            	 if(ClassInfo.get(0).equals(coursetext.getText())) {
						 //if yes, set courseExists to true and break out of loop
		            		courseExists = true;
		            		Courses course = new Course(ClassInfo.get(0),ClassInfo.get(1),ClassInfo.get(2),ClassInfo.get(3),ClassInfo.get(4),ClassInfo.get(5),ClassInfo.get(6),,ClassInfo.get(7));
		            		
							courseid = course.getCourseID();
		            		coursename = course.getCourseName();
		            		coursedescription = course.getCourseDescription();
		            		meetingtime = course.getMeetingTime();
							startdate = course.getStartDate();
							enddate = course.getEndDate();
							enrollmentlimit = course.getEnrollmentLimit();
							currentenrollment = course.getCurrentEnrollment();
		            		break;
		            	 }
		            	 
		            	 ClassInfo.clear(); //no match so clear and load next line
		            		 
		            }

		            // Close file
		            input.close();  
				}
				catch(FileNotFoundException ex) {
		            System.out.println("Unable to open file.");                
		        }
				
				//System.out.println(userExists);
				
				if(courseExists == true){
					//check if student already enrolled in the course
					FileReadWrite enro = new FileReadWrite();
					ArrayList<String> enrolledCourses = enro.ReadStudentFile(ID, uname);
					for (i=0; i<enrolledCourses.size(); i++) {
						if(enrolledCourses[i] == courseid) {
							studentEnrolled = true;
							break;
						}
					}
					if (studentEnrolled == true) {
						JOptionPane alreadyEnrolled = new JOptionPane("Failed to enroll, you are already enrolled in this course.",JOptionPane.WARNING_MESSAGE);
						JDialog dialog = alreadyEnrolled.createDialog("Error!");
						dialog.setAlwaysOnTop(true); //always on top
						dialog.setVisible(true); //make visiable
					} else {
						//check to see if there is room in the course
						if (course.addEnrollment() == true) { 
							//add the courseid to student's file
							enro.WriteStudentFile(ID, uname, courseid);
					
						} else { //no room in course
							JOptionPane noRoom = new JOptionPane("Failed to enroll, this course is full.",JOptionPane.WARNING_MESSAGE);
							JDialog dialog = noRoom.createDialog("Error!");
							dialog.setAlwaysOnTop(true); //always on top
							dialog.setVisible(true); //make visiable
						}
					}
					
				}
				else{ //course doesnt exist
					JOptionPane noCourse = new JOptionPane("Course does not exist. Please input a valid course.",JOptionPane.WARNING_MESSAGE);
					JDialog dialog = noCourse.createDialog("Error!");
					dialog.setAlwaysOnTop(true); //always on top
					dialog.setVisible(true); //make visiable
				}
			  
		  }
});
			  
			  
			  setVisible(false);
		  }
		});
		
		//action listener - exit program
		bt2.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			//exit application
		    System.exit(0);
		  }
		});
		

		//add labels and buttons to panels
		//not sure the ordering so just moved things around until layout looks good
		header.add(title);
		select.add(coursenum);
		select.add(coursetext);
		select.add(courselist);
		select.add(bt1);
		select.add(bt2);
		
		//add to frame
		add(header,BorderLayout.NORTH);
		add(select);
		
		//set size
		setSize(800,300);
		//default close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
	}
	
	
}

