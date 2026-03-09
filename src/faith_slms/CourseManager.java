/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms;

import java.util.*; //Importing scanner to accept input

/**
 *
 * @author Fauzan
 * This class is used to manage courses. Functions such as add, delete, search and update will go here
 * Semua function kita taruk dlm ni.. Kene update class diagram nnti last2 ~Fauzan
 * Main functions completed, just needs polishing ~Fauzan (9/3/2026)
 */
public class CourseManager {
    private Course[] courses = new Course[2];
    private int courseCount = 0;

    public void createCourse() { 
        //Create function ~Fauzan
        Scanner input = new Scanner(System.in);
        if (courseCount >= courses.length) { // Prevent out-of-bound error
            System.out.println("Cannot add more courses. Array is full.");
            return;
        }
        
        System.out.print("Enter course name: ");
        String name = input.nextLine();
        
        System.out.print("Enter course code: ");
        String code = input.nextLine();
        
        System.out.print("Enter credit hours: ");
        int creditHours = input.nextInt();
        
        input.nextLine(); //Clear input buffer
        
        System.out.print("Enter course summary: ");
        String summary = input.nextLine();
        
        System.out.print("Enter Microsoft Teams link: ");
        String teamsLink = input.nextLine();
        
        Course newCourse = new Course(name, code, creditHours, summary, teamsLink);
        courses[courseCount] = newCourse;
        courseCount++;

        System.out.println("Course added successfully.");
    }

    //Edit function development ~Aisar
    public void editCourse() {
        Scanner input = new Scanner(System.in);

        if (courseCount == 0) {
            System.out.println("No courses available to edit.");
            return;
        }

        System.out.print("Enter course code to edit: ");
        String searchCode = input.nextLine();
    
        boolean found = false;
    
        for (int i = 0; i < courseCount; i++) {
    
            if (courses[i].getCode().equalsIgnoreCase(searchCode)) {
                found = true;
    
                System.out.println("\nCourse found!");
                System.out.println("Current Course Details:");
                System.out.println("Name: " + courses[i].getName());
                System.out.println("Code: " + courses[i].getCode());
                System.out.println("Credit Hours: " + courses[i].getCredits());
                System.out.println("Summary: " + courses[i].getSummary());
                System.out.println("Teams Link: " + courses[i].getLink());
    
                // Editing attributes (except course code)
                System.out.print("\nEnter new course name: ");
                String newName = input.nextLine();
                courses[i].setName(newName);
    
                System.out.print("Enter new credit hours: ");
                int newCredits = input.nextInt();
                input.nextLine(); // clear buffer
                courses[i].setCredits(newCredits);
    
                System.out.print("Enter new course summary: ");
                String newSummary = input.nextLine();
                courses[i].setSummary(newSummary);
    
                System.out.print("Enter new Microsoft Teams link: ");
                String newLink = input.nextLine();
                courses[i].setLink(newLink);
    
                // Display updated course
                System.out.println("\nCourse updated successfully!");
                System.out.println("Updated Course Details:");
                System.out.println("Name: " + courses[i].getName());
                System.out.println("Code: " + courses[i].getCode());
                System.out.println("Credit Hours: " + courses[i].getCredits());
                System.out.println("Summary: " + courses[i].getSummary());
                System.out.println("Teams Link: " + courses[i].getLink());
    
                break;
            }
        }
    
        if (!found) {
            System.out.println("Course not found.");
        }
    }
    
     public void deleteCourse() { //Delete function by Icap
    Scanner input = new Scanner(System.in);

    if (courseCount == 0) {
        System.out.println("No courses available to delete.");
        return;
    }

    System.out.print("Enter course code to delete: ");
    String searchCode = input.nextLine();

    boolean found = false;

    for (int i = 0; i < courseCount; i++) {
        if (courses[i].getCode().equalsIgnoreCase(searchCode)) {
            found = true;

            // Shift courses left to overwrite the deleted course
            for (int j = i; j < courseCount - 1; j++) {
                courses[j] = courses[j + 1];
            }
            courses[courseCount - 1] = null; // Clear last element
            courseCount--;

            System.out.println("Course deleted successfully.");
            break;
        }
    }

    if (!found) {
        System.out.println("Course not found.");
    }
}

    public void deleteCourse() {
    Scanner input = new Scanner(System.in);

    if (courseCount == 0) {
        System.out.println("No courses available to delete.");
        return;
    }

    System.out.print("Enter course code to delete: ");
    String searchCode = input.nextLine();

    boolean found = false;

    for (int i = 0; i < courseCount; i++) {
        if (courses[i].getCode().equalsIgnoreCase(searchCode)) {
            found = true;

            // Shift courses left to overwrite the deleted course
            for (int j = i; j < courseCount - 1; j++) {
                courses[j] = courses[j + 1];
            }
            courses[courseCount - 1] = null; // Clear last element
            courseCount--;

            System.out.println("Course deleted successfully.");
            break;
        }
    }

    if (!found) {
        System.out.println("Course not found.");
    }
}
    
    public void displayCourses() { //Basic displaying function. Akan tukar ke format table nnti ~Fauzan
        if(courseCount == 0){
            System.out.println("No courses created! Exiting function...");
            return;
        }
        for (int i = 0; i < courseCount; i++) {
            System.out.println("Course " + (i + 1));
            System.out.println("Name: " + courses[i].getName());
            System.out.println("Code: " + courses[i].getCode());
            System.out.println("Credit Hour: " + courses[i].getCredits());
            System.out.println("Summary: " + courses[i].getSummary());
            System.out.println("Teams Link: " + courses[i].getLink());
            System.out.println();
        }
    }
}
