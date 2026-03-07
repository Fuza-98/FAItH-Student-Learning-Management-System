/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms;
import java.util.*;
/**
 *
 * @author Fauzan
 * Course class containing attributes, setters and getters ONLY
 * JANGAN TUKAR APA-APA DALAM NI
 */
public class Course {
    private String name, code, summary, teamsLink;
    private int creditHours;
    
    
    public Course(String name, String code, int creditHours, String summary, String teamsLink){
        this.name = name;
        this.code = code;
        this.summary = summary;
        this.creditHours = creditHours;
        this.teamsLink = teamsLink;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    public void setSummary(String summary){
        this.summary = summary;
    }
    
    public void setLink(String teamsLink){
        this.teamsLink = teamsLink;
    }
    
    public void setCredits(int creditHours){
        this.creditHours = creditHours;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getSummary(){
        return summary;
    }
    
    public String getLink(){
        return teamsLink;
    }
    
    public int getCredits(){
        return creditHours;
    }
    
    
}
