
public class Student {
    
    //datafields
    //Split name into firstName and lastName - hghmh Mehrdad Haghi 10/06/18
    private String firstName; // student first name
    private String lastName;   // student last name
    private String email;    // email 
    private String ID;       // studentID
    
    
    
    //constructors
    public Student(){} 
    
   //Split name into firstName and lastName - hghmh Mehrdad Haghi
    public Student(String firstName, String lastName, String email, String ID) {
    this.firstName   = firstName;
    this.lastName    = lastName;
    this.email	     = email;
    this.ID	     = ID;
    }
    
    
    //getter and setter methods
    //Split getName/setName into getFirstName/setFirstName and getLastName/setLastName - hghmh Mehrdad Haghi
    public String getFirstName(){
	return this.firstName;
	}
    public void setFirstName(String a){
	this.firstName = a;
	}
	
    public String getLastName(){
	return this.lastName;
	}
    public void setLastName(String a){
	this.lastName = a;
	}
    
    public String getEmail(){
	return this.email;
    } 
    public void setEmail(String b){
	this.email = b;
    }
    
     public String getID(){
         return this.ID;
    } 
    public void setID(String c){
	this.ID = c;
    }
    
   
   
 

}


    
    
    
   
