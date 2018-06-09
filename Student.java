
public class Student {
    
    //datafields
    private String name;     // student name
    private String email;    // email 
    private String ID;       // studentID
    
    
    
    //constructors
    public Student(){} 
    
    public Student(String name, String email, String ID) {
        this.name   = name;
        this.email   = email;
	this.ID = ID;
        }
    
    
    //getter and setter methods
    public String getName(){
	return this.name;
	}
    public void setName(String a){
	this.name = a;
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


    
    
    
   
