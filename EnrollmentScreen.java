//This is still in the works, I'm going to be at work for a long time tonight so I will be working on it as I get breaks between migrations (going through a merger is not fun)

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EnrollCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton bt1; 			//Enroll
	JButton bt2; 			//Cancel
	JLabel title; 			//Window Title
	JLabel coursenumber; 	//course field label
	JTextField coursetext; 	//course text
	JTextField courses      //list of courses
	
	
	public RegisterNewStudent(){

		
		//labels + buttons
		title = new JLabel("Enrollment");
		Coursetext = new JLabel(" Please Select a Course Number to Enroll Into: ");
		Course courses = new Course();
		ArrayList<String> list = courses.getCourselist();
		for(int i=0;i<list.size();i++){
		 System.out.print(list.get(i));
		}

		CourseString = new JTextField(30);
		bt1 = new JButton("Register");
		bt2 = new JButton("Cancel");
		
		//panels
		JPanel header = new JPanel(new FlowLayout());
		JPanel select = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		
		//action listener - append student file
		bt1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // Do something
			  FileReadWrite st = new FileReadWrite();
			  
			  st.WriteStudentFile("",coursetext.getText());
			 
			  
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
		header.add(title);
		select.add(coursetext);
		select.add(course);
		select.add(coursestring);
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
