

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
	
	
	public Enrollment(){

		
		//labels and buttons
		title = new JLabel("Course Enrollment");
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
		    // write course to the students file
			  //WRITE COURSE 
			
			//ADD ticker to course (+1 enroll)
			  
			  
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

