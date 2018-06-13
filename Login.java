import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
			// Hold one line at a time
		        String line = null;
		        String[] lineArray;
		        ArrayList<String> studentInfo = new ArrayList<String>();
		        String ID = "";
		        String fname = "";
		        String lname = "";
		        String uname = "";
		        boolean userExists = false;
		        
				try{
					//new file object
		        	File file = new File("StudentLists.txt");
		     
		        	//read in file contents
		        	Scanner input = new Scanner(file);
		            while(input.hasNext()){
		            	line = input.nextLine();
		            	lineArray = line.split("[,]");
		            	
		            	//add data to the arraylist
		            	 for (int i = 0; i < lineArray.length; i++) {
		            		 studentInfo.add(lineArray[i]);
		            	 }
		            	 
		            	 //System.out.println("Username: " + studentInfo.get(1) + " Password: " + studentInfo.get(2));
		            	 
		            	 //check the username (2nd element) and password (3rd element) equals user input values
		            	 //if yes, set userExists to true and break out of loop
		            	 if(studentInfo.get(1).equals(usertext.getText()) && studentInfo.get(2).equals(pwtext.getText()) ) {
		            		userExists = true;
		            		Student stud = new Student(studentInfo.get(1),studentInfo.get(3),studentInfo.get(4),studentInfo.get(5),studentInfo.get(0));
		            		ID = stud.getID();
		            		fname = stud.getFirstName();
		            		lname = stud.getLastName();
		            		uname = stud.getUsername();
		            		break;
		            	 }
		            	 
		            	 studentInfo.clear(); //no match so clear and load next line
		            		 
		            }

		            // Close file
		            input.close();  
				}
				catch(FileNotFoundException ex) {
		            System.out.println("Unable to open student file.");                
		        }
				
				//System.out.println(userExists);
				
				if(userExists == true){
					//show enrollment screen
					//new StudentEnrollments(ID,uname,fname,lname);
					
					//show welcome screen
					new WelcomeScreen(ID, uname, fname, lname);
				}
				else{ //output failed authentication using JOptionPane
					JOptionPane failAuth = new JOptionPane("Failed authentication. Please try again.",JOptionPane.WARNING_MESSAGE);
					JDialog dialog = failAuth.createDialog("Error!");
					dialog.setAlwaysOnTop(true); //always on top
					dialog.setVisible(true); //make visiable
				}
			  
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
