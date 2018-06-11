package course.registration;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Welcome {

	public static void main(String[] args) throws FileNotFoundException {
		VerifyLogin verify = new VerifyLogin();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Course Registration System" + "\n");
		System.out.print("Please choose Login or Register: ");
		
		int choice = 0;
		
		while (choice == 0) {
            System.out.println();
            System.out.println("1: Login");
            System.out.println("2: Register");
            System.out.print("Please choose 1 or 2: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Please enter email address to log in: ");
                String email = input.nextLine();
                System.out.print("Please enter password: ");
                String password = input.nextLine();

                if (verify.VerifyInfo(email, password)) {
                	System.out.println("Email Address or Password Works!!");
                	break;
                }
                else {
            	System.out.println("Email Address or Password is Invalid.");
                }	
            }
            
            else if (choice == 2) {
            	System.out.println("Going to Registration Page...");
            }
        }    
            input.close();
    }
}


	

 
	


	
