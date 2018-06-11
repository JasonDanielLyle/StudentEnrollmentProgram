package course.registration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerifyLogin {
	private String tempUsername;
	private String tempPassword;
	
	public boolean VerifyInfo(String email, String password) throws FileNotFoundException {
		File file = new File("student_logins.txt");
		Scanner info = new Scanner(file);
		info.useDelimiter("[,\n]");
		boolean noBreak = false;
		
		while (info.hasNextLine()) {
			tempUsername = info.next();
			tempPassword = info.next();
			if (tempUsername.trim().equals(email.trim()) && tempPassword.trim().equals(password.trim()))
				noBreak = true;
		}
		info.close();
		return noBreak;
	}	
}