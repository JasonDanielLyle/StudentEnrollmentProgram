import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L; //not sure what this is but Eclipse was gave WARNING it was needed
	JButton bt1; 			//Login
	JButton bt2; 			//Cancel
	JButton bt3; 			//Register
	JLabel title; 			//Window Title
	JLabel username; 		//User field label
	JTextField usertext; 	//username text
	JLabel password; 		//Password label
	JTextField pwtext; 		//password text
	
	
	public Login(){
		//set size
		//setLayout(new BorderLayout());
		
		//assign labels and buttons
		title = new JLabel("Welcome to Team A Course Enrollment Program. \nPlease log in or register to enroll.");
		username = new JLabel("Please Enter Username: ");
		usertext = new JTextField(15);
		password = new JLabel("Please Enter Password: ");
		pwtext = new JTextField(15);
		bt1 = new JButton("Login");
		bt2 = new JButton("Cancel");
		bt3 = new JButton("Register");
		
		//panels
		JPanel header = new JPanel(new FlowLayout());
		JPanel select = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		
		//action listener - login authentication
		bt1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // Do something
			  
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
		
		//action listener - register
		bt3.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // Do something
			  new RegisterNewStudent();
			  setVisible(false);
		  }
		});
		
		
		//add labels and buttons to panels
		//not sure the ordering so just moved things around until layout looks good
		header.add(title);
		select.add(username);
		select.add(usertext);
		select.add(password);
		select.add(pwtext);
		select.add(bt1);
		select.add(bt2);
		select.add(bt3);
		
		//add to frame
		add(header,BorderLayout.NORTH);
		add(select);
		
		//set size
		setSize(600,300);
		//default close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
	}
	
	
}
