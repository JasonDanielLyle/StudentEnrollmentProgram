import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class StudentEnrollments extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //unsure what this does; Eclipse added it.
	JButton bt1; 			//Login
	JButton bt2; 			//Back
	JLabel title; 			//Window Title
	JTextArea list;		 	//course list
	JButton bt3;			//delete
	JLabel deleteTitle;
	JTextField deleteText;
	
	public StudentEnrollments(String ID, String uname, String fname, String lname){
		//Student currSt = new Student();
		
		FileReadWrite stList = new FileReadWrite();
		ArrayList<String> text = stList.ReadStudentFile(ID,uname); //call method to get course data
		String newText = "";
		
		//loop through arraylist and store in a string
		//the for loop conditions is different. Had to use inital index of 1 and increase size by 1.
		//this gave the desired formatting
		String ntext = "";
		for (int i=1;i<text.size()+1;i++){
			
			if(text.get(i-1).length() <= 25){
				newText += String.format("%-35s",text.get(i-1));
			}
			else{
				ntext = text.get(i-1).substring(0, 25);
				newText += String.format("%-35s",ntext);
			}
			if(i%6 == 0)
				newText += "\n";
		}
		
		//assign labels and buttons
		title = new JLabel("Enrollment History For Student " + fname + " " + lname + "   (ID: " + ID + ")");
		bt1 = new JButton("Close");
		bt2 = new JButton("Back");
		bt3 = new JButton("Un-Enroll");
		deleteTitle = new JLabel("Enter Course ID to un-enroll ");
		deleteText = new JTextField(10);
		
		String header1 = String.format("%-35s%-35s%-35s%-35s%-35s%-35s", "Course ID", "Course Name", "Course Description", 
				"Course Time", "Start Date", "End Date");
		
		list = new JTextArea();
		list.setText(header1 + "\n" + newText);
		list.setEditable(false); //read only field
		
		//panels
		JPanel header = new JPanel(new FlowLayout());
		JPanel select = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		
		//action listener - login authentication
		bt1.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  new WelcomeScreen(ID, uname, fname, lname).setVisible(true); //return back to calling GUI window
			  setVisible(false);
		  }
		});
		//action listener - remove enrollment
		bt3.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  FileReadWrite deleteEn = new FileReadWrite();
			  ArrayList<String> enrolledCourses = deleteEn.ReadStudentFile(ID, uname);
			  
			  //ask to confirm delete
			  int result = JOptionPane.showConfirmDialog((Component) null, "Are you sure you want to un-enroll?",
				        "Alert", JOptionPane.OK_CANCEL_OPTION);
			  
			  //System.out.println(result);
			  
			  if (result == 0){ 
				  
				//check if student already enrolled in the course
				
				for (int i=0;i<enrolledCourses.size();i++) {
					if(enrolledCourses.get(i).equals(deleteText.getText())) {
						deleteEn.DeleteEnrollment(deleteText.getText().charAt(0), ID, uname);
						dispose(); //close current window - free up resources
						new StudentEnrollments(ID,uname,fname,lname); //reload enrollment page with updated student course list
						break;
					}
					if(i==enrolledCourses.size()-1){
						JOptionPane noCourse = new JOptionPane("Course does not exist. Please input a valid course.",JOptionPane.WARNING_MESSAGE);
						JDialog dialog = noCourse.createDialog("Error!");
						dialog.setAlwaysOnTop(true); //always on top
						dialog.setVisible(true); //make visible
						break;
					}
				}
					
				  
				  
			  }
		  }
		});
				
		
		//add labels and buttons to panels
		//not sure the ordering so just moved things around until layout looks good
		header.add(title);
		select.add(list);
		select.add(deleteTitle);
		select.add(deleteText);
		select.add(bt3);
		select.add(bt1);
		
		//add to frame
		add(header,BorderLayout.NORTH);
		add(select);
		
		//set size
		setSize(1200,300);
		//default close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		setLocationRelativeTo(null);
		
	}

}
