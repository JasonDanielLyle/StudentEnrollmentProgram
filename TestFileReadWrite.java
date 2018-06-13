//import java.awt.Dimension;
//import java.awt.GridLayout;
import java.util.*;
//import javax.swing.*;


public class TestFileReadWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Login();
		
		//System.out.println("Username: " + lg.usertext.getText() + " Password: " + lg.pwtext.getText());
		
		//hard coded the courses in a multidimensional array for testing
		Object[][] courses = 
			{ {"1","1/1/2018","4/1/2018","Java Programming 1","Intro to Java",35,1},
			  {"2","3/1/2018","6/1/2018","Java Programming 4","Advance Java",35,1},
			  {"3","6/1/2018","9/1/2018","Perl 1","Intro to Perl",35,1},
			  {"4","9/1/2018","12/1/2018","Perl 3","Perl Advance",35,1},
			};
		
		//test student
		Student st = new Student("Cliff","email@gmail.com","1");
		System.out.println("Welcome " + st.getName());
		
		
		//Outputs all courses
		//System.out.print(a.ReadAllCourses().replaceAll(",", "\t"));
		printHeader();
		
		for (int i=0; i<4; i++){
			for (int j=0; j<7; j++){
				System.out.format("%-20s",courses[i][j]);
			}
			System.out.println();
		}
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Which course would you like to enroll in (0 to exit): ");
		int id = input.nextInt();
		
		if(id == 0){
			System.out.println("Exited Application");
			System.exit(0);
		}
		
		FileReadWrite a = new FileReadWrite();
		
		//Register course
		//Write to student unique file
		switch (id){
		case 1:
			String cn1 = courses[0][0] + "," + courses[0][1] + "," + courses[0][2] + "," +
						courses[0][3] + "," + courses[0][4];
			a.WriteStudenFile(cn1,st.getName());
			System.out.println("Registration complete!");
			break;
		case 2:
			String cn2 = courses[1][0] + "," + courses[1][1] + "," + courses[1][2] + "," +
						courses[1][3] + "," + courses[1][4];
			a.WriteStudenFile(cn2,st.getName());
			System.out.println("Registration complete!");
			break;
		case 3:
			String cn3 = courses[2][0] + "," + courses[2][1] + "," + courses[2][2] + "," +
						courses[2][3] + "," + courses[2][4];
			a.WriteStudenFile(cn3,st.getName());
			System.out.println("Registration complete!");
			break;
		case 4:
			String cn4 = courses[3][0] + "," + courses[3][1] + "," + courses[3][2] + "," +
						courses[3][3] + "," + courses[3][4];
			a.WriteStudenFile(cn4,st.getName());
			System.out.println("Registration complete!");
			break;
		}

		//Allow student to see their courses
		System.out.print("Do you want to view your course history? (y/n) ");

		String yn = input.next();
		
		//output student course list
		if(yn.equals("y"))
			System.out.print(a.ReadStudentFile(st.getName()).replaceAll(",", "\t"));
		
		//Un-register from a course
		System.out.print("Do you want to un-register from a course? (y/n) ");
		String delyn = input.next();
		
		if(delyn.equals("y")){
			System.out.print("Course ID to un-register? ");
			String delID = input.next();
			char sID = delID.charAt(0);
			a.DeleteEnrollment(sID,st.getName());
			
			
		}


		input.close();
	}


static void printHeader(){
	System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s","Course ID","Start Date","End Date" 
			,"Course Name","Course Description"
			,"Max Enrollment","Current Enrollment");
	System.out.println();
	
}

}
