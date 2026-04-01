/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms;

/**
 *
 * @author Fauzan, same as Course class DO NOT CHANGE ANYTHING
 */
public class Student {
    private String firstName, lastName, id, email, phoneNum;
    
    public Student(String fN, String lN, String id, String email, String phone){
        firstName = fN;
        lastName = lN;
        this.id = id;
        this.email = email;
        phoneNum = phone;
    }
    
    public void setFirstName(String fN){
        firstName = fN;
    }
    
    public void setLastName(String lN){
       lastName = lN;
    }
    
    public void setID(String id){
        this.id = id;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPhone(String phone){
        phoneNum = phone;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getID(){
        return id;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPhone(){
        return phoneNum;
    }
}
