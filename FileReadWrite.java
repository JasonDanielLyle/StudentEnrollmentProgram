import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class FileReadWrite {

    final private String courseFile = "AllCoursesList.txt";
    final private String studentCourseList = "_Courses.txt";

    //Not needed if course list IS NOT stored in a file
	public String ReadAllCourses(){

		// Hold one line at a time
        String line = null;
        String allLines = "";

        try {
            //new file object
        	File file = new File(courseFile);
        	
        	//read in file contents
        	Scanner input = new Scanner(file);
            while(input.hasNext()){
            	line = input.nextLine();
            	//System.out.println(line.replaceAll(",", "\t"));
            	allLines += line + "\n";
            }

            // Close file
            input.close(); 

        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + courseFile + "'");                
        }
		return allLines;

	}
	
	public ArrayList<String> ReadStudentFile(String ID, String name){
		// Hold one line at a time
        String line = null;
        String allLines = "";
        String[] lineArray;
		ArrayList<String> studentInfo = new ArrayList<String>();
        
		try{
			//new file object
        	File file = new File(ID + "_" + name + studentCourseList);
        	
        	//read in file contents
        	Scanner input = new Scanner(file);
            while(input.hasNext()){
            	line = input.nextLine();
            	//System.out.println(line.replaceAll(",", "\t"));
            	//allLines += line + "\n";
            	
            	lineArray = line.split("[,]");
            	
            	//add data to the arraylist
            	 for (int i = 0; i < lineArray.length; i++) {
            		 studentInfo.add(lineArray[i]);
            	 }
            }

            // Close file 
            input.close();  
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open student file.");                
        }
		return studentInfo;
	}
	
	public void WriteStudentFile(String name, String text){
		//Each student will have a unique file that has all courses for that particular
		//student. File format is "<ID>_Courses.txt"

        try {
            // Use FileWriter instead of File so we can append to existing file
            FileWriter file = new FileWriter(Integer.parseInt(getLastID()) + 1 + "_" + name + studentCourseList,true);
            
            // write to file. Include \n since write doesn't
            //automatically add a newline
            file.write(text+"\n");

            // Close file
            file.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + Integer.parseInt(getLastID()) + 1 + "_" + name + studentCourseList + "'");
        }
	}
	
	//write new student to StudentLists.txt file -- unique by ID
	public void RegisterNew(String name, String passwd/*, String fname, String lname*/, String email){
		//deleting this method causes RegisterNew1 method to error.
		//don't know why so leaving it here for now to investigate later
	}
	
	//write new student to StudentLists.txt file -- unique by ID
		public void RegisterNew1(String name, String passwd, String fname, String lname, String email){
			//String line;

	        try {
	            // Use FileWriter instead of File so we can append to existing file
	            FileWriter file = new FileWriter("StudentLists.txt",true);
	            
	            int ID = Integer.parseInt(getLastID()) + 1;
	            
	            // write to file. Include \n since write doesn't
	            //automatically add a newline
	            file.write(ID + "," + name + "," + passwd + "," + fname + "," + lname + "," + email +"\n");
	            
	            //set student information in Student class
	            new Student(name,fname,lname,email,ID+"");

	            // Close file
	            file.close();
	        }
	        catch(IOException ex) {
	            System.out.println("Error writing to file '" + name + studentCourseList + "'");
	        }
		}
		
	//find max ID
	//ASSUMPTION - file has records in descending order
	String getLastID(){
		String line = null;
		String[] lineArray;
		ArrayList<String> studentInfo = new ArrayList<String>();
		String lastStudentID = "";
        
		try{
			//new file object
        	File file = new File("StudentLists.txt");
        	
        	//read in file contents one row at a time
        	Scanner input = new Scanner(file);
            while(input.hasNext()){
            	line = input.nextLine();
            	lineArray = line.split("[,]");
            	
            	//add data to the arraylist
            	 for (int i = 0; i < lineArray.length; i++) {
            		 studentInfo.add(lineArray[i]);
            	 }
            }
            
            //get last row ID field value
            if(studentInfo.size() == 0)
            	lastStudentID = "0";
            else
            	lastStudentID = studentInfo.get(studentInfo.size() - 6); //subtract 6 total columns

            // Close file
            input.close();  
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open student file.");                
        }
		return lastStudentID;

	}
	
	public void DeleteEnrollment(char cID, String ID, String name){
        
		try{
			File file = new File(ID + "_" + name + studentCourseList);
			File temp = new File("Temp-" + ID + "_" + name + studentCourseList); //temp file
			
			PrintWriter output = new PrintWriter(new FileWriter(temp));
			
			Files.lines(file.toPath()).filter(line->!(line.charAt(0) == cID))
									.forEach(output::println);
			
			output.flush(); //write contents of buffer to disk
			output.close();
			temp.renameTo(file);
		}
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open student file.");                
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
