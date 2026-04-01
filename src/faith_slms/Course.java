/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms; // Declare package name

import java.util.*; // Import all utilities from java.util package (though not used here)

/**
 *
 * @author Fauzan
 * Course class containing attributes, setters and getters ONLY
 * JANGAN TUKAR APA-APA DALAM NI
 */
public class Course { // Define Course class
    
    // Declare private attributes (data members)
    private String name, code, summary, teamsLink; // Course name, code, description, and Teams link
    private int creditHours; // Credit hours for the course
    
    // Constructor to initialize all attributes
    public Course(String name, String code, int creditHours, String summary, String teamsLink){
        this.name = name; // Assign name
        this.code = code; // Assign code
        this.summary = summary; // Assign summary
        this.creditHours = creditHours; // Assign credit hours
        this.teamsLink = teamsLink; // Assign Teams link
    }
    
    // Setter method to update course name
    public void setName(String name){
        this.name = name; // Set new name
    }
    
    // Setter method to update course code
    public void setCode(String code){
        this.code = code; // Set new code
    }
    
    // Setter method to update course summary
    public void setSummary(String summary){
        this.summary = summary; // Set new summary
    }
    
    // Setter method to update Teams link
    public void setLink(String teamsLink){
        this.teamsLink = teamsLink; // Set new Teams link
    }
    
    // Setter method to update credit hours
    public void setCredits(int creditHours){
        this.creditHours = creditHours; // Set new credit hours
    }
    
    // Getter method to retrieve course name
    public String getName(){
        return name; // Return name
    }
    
    // Getter method to retrieve course code
    public String getCode(){
        return code; // Return code
    }
    
    // Getter method to retrieve course summary
    public String getSummary(){
        return summary; // Return summary
    }
    
    // Getter method to retrieve Teams link
    public String getLink(){
        return teamsLink; // Return Teams link
    }
    
    // Getter method to retrieve credit hours
    public int getCredits(){
        return creditHours; // Return credit hours
    }
}
