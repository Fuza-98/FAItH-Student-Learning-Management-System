/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms; // Declare package name

/**
 *
 * @author Fauzan, same as Course class DO NOT CHANGE ANYTHING
 */
public class Student { // Define Student class
    
    // Declare private attributes for student details
    private String firstName, lastName, id, email, phoneNum;
    
    // Constructor to initialize all attributes
    public Student(String fN, String lN, String id, String email, String phone){
        firstName = fN; // Assign first name
        lastName = lN; // Assign last name
        this.id = id; // Assign student ID
        this.email = email; // Assign email
        phoneNum = phone; // Assign phone number
    }
    
    // Setter method to update first name
    public void setFirstName(String fN){
        firstName = fN; // Set new first name
    }
    
    // Setter method to update last name
    public void setLastName(String lN){
       lastName = lN; // Set new last name
    }
    
    // Setter method to update ID
    public void setID(String id){
        this.id = id; // Set new ID
    }
    
    // Setter method to update email
    public void setEmail(String email){
        this.email = email; // Set new email
    }
    
    // Setter method to update phone number
    public void setPhone(String phone){
        phoneNum = phone; // Set new phone number
    }
    
    // Getter method to retrieve first name
    public String getFirstName(){
        return firstName; // Return first name
    }
    
    // Getter method to retrieve last name
    public String getLastName(){
        return lastName; // Return last name
    }
    
    // Getter method to retrieve ID
    public String getID(){
        return id; // Return ID
    }
    
    // Getter method to retrieve email
    public String getEmail(){
        return email; // Return email
    }
    
    // Getter method to retrieve phone number
    public String getPhone(){
        return phoneNum; // Return phone number
    }
}
