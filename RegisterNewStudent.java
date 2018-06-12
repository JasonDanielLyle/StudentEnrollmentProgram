import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterNewStudent extends JFrame {

	private static final long serialVersionUID = 1L; //not sure what this is but Eclipse was gave WARNING it was needed
	JButton bt1; 			//Login
	JButton bt2; 			//Cancel
	JLabel title; 			//Window Title
	JLabel username; 		//User field label
	JTextField usertext; 	//username text
	JLabel password; 		//Password label
	JTextField pwtext; 		//password text
	JLabel email; 			//Password label
	JTextField emailText; 	//password text
	JLabel fname; 			//first name label
	JTextField fnameText; 	//first name text
	JLabel lname; 			//last name label
	JTextField lnameText; 	//last name text
	
	
	public RegisterNewStudent(){
		//set size
		//setLayout(new BorderLayout());
		
		//assign labels and buttons
		//no time to play around with formating so use spaces to align evenly
		title = new JLabel("New Student Registration");
		username = new JLabel(" Please Enter Username: ");
		usertext = new JTextField(30);
		password = new JLabel("  Please Enter Password: ");
		pwtext = new JTextField(30);
		email = new JLabel("         Please Enter Email: ");
		emailText = new JTextField(30);
		fname = new JLabel("Please Enter First Name: ");
		fnameText = new JTextField(30);
		lname = new JLabel(" Please Enter Last Name: ");
		lnameText = new JTextField(30);
		bt1 = new JButton("OK");
		bt2 = new JButton("Cancel");
		
		//panels
		JPanel header = new JPanel(new FlowLayout());
		JPanel select = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		
		//action listener - create new student file
		bt1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // Do something
			  FileReadWrite st = new FileReadWrite();
			  
			  st.WriteStudentFile(usertext.getText(),"");
			  
			  st.RegisterNew1(usertext.getText(),pwtext.getText(),fnameText.getText(),lnameText.getText(),emailText.getText());
			  
			  setVisible(false);
		  }
		});
		
		//action listener - exit program
		bt2.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  new Login().setVisible(true); //return back to calling GUI window
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
		select.add(fname);
		select.add(fnameText);
		select.add(lname);
		select.add(lnameText);
		select.add(email);
		select.add(emailText);
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
