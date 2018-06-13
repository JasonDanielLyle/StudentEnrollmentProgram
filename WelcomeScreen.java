

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class WelcomeScreen  extends JFrame {

	private static final long serialVersionUID = 1L; 
	JButton bt1; 			//View Courses/Enroll
	JButton bt2; 			//View Registered Courses/Un-Enroll
	JButton bt3;			//Exit
	JLabel title; 			//Window Title
	
	
	public WelcomeScreen(String ID, String uname, String fname, String lname){

		
		//labels and buttons
		title = new JLabel("Welcome" + getFirstName() +" " + getLastName());

		
		
		
		
		bt1 = new JButton("View Courses/Enroll");
		bt2 = new JButton("View Registered Courses/Un-Enroll");
		bt3 = new JButton("Exit");
		
		//panels
		JPanel header = new JPanel(new FlowLayout());
		JPanel select = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		
		//action listener - enroll screen
		bt1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    new Enroll(ID, uname, fname, lname);
			setVisible(false);
		  }
		});
		
		
		//action listener - view current classes/un-enroll screen
		bt2.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    new StudentEnrollments(ID,uname,fname,lname);;
			setVisible(false);
		  }
		});
		
		//action listener - exit program
		bt3.addActionListener(new ActionListener()
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
		select.add(bt1);
		select.add(bt2);
		select.add(bt3);
		
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

