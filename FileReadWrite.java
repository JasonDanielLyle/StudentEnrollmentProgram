import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class FileReadWrite {
	
	private  String ID = "CliffHy99283"; //replace with Student class variable
    final private String courseFile = "Courses.txt";
    final private String studentCourseList = ID + "_" + "Courses.txt";
   

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
	
	public String ReadStudentFile(String StudentID){
		// Hold one line at a time
        String line = null;
        String allLines = "";
        
		try{
			//new file object
        	File file = new File(StudentID + "_Courses.txt");
        	
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
            System.out.println("Unable to open student file.");                
        }
		return allLines;
	}
	
	public void WriteStudenFile(String text){
		//Each student will have a unique file that has all courses for that particular
		//student. File format is "<ID>_Courses.txt"

        try {
            // Use FileWriter instead of File so we can append to existing file
            FileWriter file = new FileWriter(studentCourseList,true);
            
            // write to file. Include \n since write doesn't
            //automatically add a newline
            file.write(text+"\n");

            // Close file
            file.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + studentCourseList + "'");
        }
	}
	
	public void DeleteEnrollment(char cID){
		// Hold one line at a time
        //String line = null;
        //String currentLine;
        
		try{
			File file = new File(studentCourseList);
			File temp = new File("Temp-" + studentCourseList);
			
			PrintWriter output = new PrintWriter(new FileWriter(temp));
			
			Files.lines(file.toPath()).filter(line->!(line.charAt(0) == cID))
									.forEach(output::println);
			output.flush();
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
