import java.awt.BorderLayout;
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
	//JButton bt2; 			//Cancel
	JLabel title; 			//Window Title
	JTextArea list;			//course list
	
	public StudentEnrollments(String ID, String uname, String fname, String lname){
		Student currSt = new Student();
		
		FileReadWrite stList = new FileReadWrite();
		ArrayList<String> text = stList.ReadStudentFile(ID,uname); //call method to get course data
		String newText = "";
		
		//loop through arraylist and store in a string
		//the for loop conditions is different. Had to use inital index of 1 and increase size by 1.
		//this gave the desired formatting
		for (int i=1;i<text.size()+1;i++){
			newText += text.get(i-1) + "\t";
			if(i%6 == 0)
				newText += "\n";
		}
		
		//assign labels and buttons
		title = new JLabel("Enrollment History For Student " + fname + " " + lname + "   (ID: " + ID + ")");
		bt1 = new JButton("Close");
		
		list = new JTextArea();
		list.setText(newText.toString());
		list.setEditable(false); //read only field
		
		//panels
		JPanel header = new JPanel(new FlowLayout());
		JPanel select = new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
		
		//action listener - login authentication
		bt1.addActionListener(new ActionListener()
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
		select.add(list);
		select.add(bt1);
		
		//add to frame
		add(header,BorderLayout.NORTH);
		add(select);
		
		//set size
		setSize(1000,300);
		//default close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
	}

}
