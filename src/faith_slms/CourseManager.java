/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms; // Declare package name

import java.util.*; // Import all utilities (Scanner used for input)

/**
 *
 * @author Fauzan
 * This class is used to manage courses. Functions such as add, delete, search and update will go here
 * Semua function kita taruk dlm ni.. Kene update class diagram nnti last2 ~Fauzan
 * Main functions completed, just needs polishing ~Fauzan (9/3/2026)
 */
public class CourseManager { // Define CourseManager class
    
    private Course[] courses = new Course[2]; // Array to store Course objects (size 2)
    private int courseCount = 0; // Counter to track number of courses stored
    
    public int getCourseCount() {
        return courseCount;
    }

    public Course getCourseByIndex(int index) {
        if (index >= 0 && index < courseCount) {
            return courses[index];
        }
        return null;
    }

    public int findCourseIndexByCode(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode().equalsIgnoreCase(courseCode)) {
                return i;
            }
        }
        return -1;
    }

    public void createCourse() { 
        // Function to create and add a new course
        Scanner input = new Scanner(System.in); // Create Scanner object
        
        if (courseCount >= courses.length) { // Check if array is full
            System.out.println("Cannot add more courses. Array is full."); // Display message
            return; // Exit function
        }
        
        System.out.print("Enter course name: "); // Prompt user
        String name = input.nextLine(); // Read course name
        
        System.out.print("Enter course code: "); // Prompt user
        String code = input.nextLine(); // Read course code
        
        System.out.print("Enter credit hours: "); // Prompt user
        int creditHours = input.nextInt(); // Read credit hours
        
        input.nextLine(); // Clear input buffer
        
        System.out.print("Enter course summary: "); // Prompt user
        String summary = input.nextLine(); // Read summary
        
        System.out.print("Enter Microsoft Teams link: "); // Prompt user
        String teamsLink = input.nextLine(); // Read Teams link
        
        Course newCourse = new Course(name, code, creditHours, summary, teamsLink); // Create new Course object
        courses[courseCount] = newCourse; // Store in array
        courseCount++; // Increase course count

        System.out.println("Course added successfully."); // Confirmation message
    }

    // Function to edit existing course
    public void editCourse() {
        Scanner input = new Scanner(System.in); // Create Scanner object

        if (courseCount == 0) { // Check if no courses exist
            System.out.println("No courses available to edit."); // Display message
            return; // Exit function
        }

        System.out.print("Enter course code to edit: "); // Prompt user
        String searchCode = input.nextLine(); // Read course code
    
        boolean found = false; // Flag to track if course is found
    
        for (int i = 0; i < courseCount; i++) { // Loop through courses
    
            if (courses[i].getCode().equalsIgnoreCase(searchCode)) { // Compare codes (ignore case)
                found = true; // Mark as found
    
                System.out.println("\nCourse found!"); // Display message
                System.out.println("Current Course Details:");
                System.out.println("Name: " + courses[i].getName()); // Display name
                System.out.println("Code: " + courses[i].getCode()); // Display code
                System.out.println("Credit Hours: " + courses[i].getCredits()); // Display credits
                System.out.println("Summary: " + courses[i].getSummary()); // Display summary
                System.out.println("Teams Link: " + courses[i].getLink()); // Display link
    
                // Update course attributes (except code)
                System.out.print("\nEnter new course name: ");
                String newName = input.nextLine(); // Read new name
                courses[i].setName(newName); // Update name
    
                System.out.print("Enter new credit hours: ");
                int newCredits = input.nextInt(); // Read new credits
                input.nextLine(); // Clear buffer
                courses[i].setCredits(newCredits); // Update credits
    
                System.out.print("Enter new course summary: ");
                String newSummary = input.nextLine(); // Read new summary
                courses[i].setSummary(newSummary); // Update summary
    
                System.out.print("Enter new Microsoft Teams link: ");
                String newLink = input.nextLine(); // Read new link
                courses[i].setLink(newLink); // Update link
    
                // Display updated course
                System.out.println("\nCourse updated successfully!");
                System.out.println("Updated Course Details:");
                System.out.println("Name: " + courses[i].getName());
                System.out.println("Code: " + courses[i].getCode());
                System.out.println("Credit Hours: " + courses[i].getCredits());
                System.out.println("Summary: " + courses[i].getSummary());
                System.out.println("Teams Link: " + courses[i].getLink());
    
                break; // Exit loop after found
            }
        }
    
        if (!found) { // If not found
            System.out.println("Course not found."); // Display message
        }
    }
    
    public void searchCourse() { // Function to search course by code
        Scanner input = new Scanner(System.in); // Create Scanner object

        if (courseCount == 0) { // Check if empty
            System.out.println("No courses available."); // Message
            return; // Exit
        }

        System.out.print("Enter course code to search: "); // Prompt
        String searchCode = input.nextLine(); // Read input

        boolean found = false; // Flag

        for (int i = 0; i < courseCount; i++) { // Loop through array

            if (courses[i].getCode().equalsIgnoreCase(searchCode)) { // Compare code

                System.out.println("\nCourse Found!");
                System.out.println("Name: " + courses[i].getName());
                System.out.println("Code: " + courses[i].getCode());
                System.out.println("Credit Hours: " + courses[i].getCredits());
                System.out.println("Summary: " + courses[i].getSummary());
                System.out.println("Teams Link: " + courses[i].getLink());

                found = true; // Set flag
                break; // Stop loop
            }
        }

        if (!found) { // If not found
            System.out.println("Course not found.");
        }
    }

    public void deleteCourse() { // Function to delete course
        Scanner input = new Scanner(System.in); // Create Scanner object

        if (courseCount == 0) { // Check if empty
            System.out.println("No courses available to delete.");
            return; // Exit
        }

        System.out.print("Enter course code to delete: "); // Prompt
        String searchCode = input.nextLine(); // Read input

        boolean found = false; // Flag

        for (int i = 0; i < courseCount; i++) { // Loop

            if (courses[i].getCode().equalsIgnoreCase(searchCode)) { // Compare
                found = true;

                // Shift elements to the left
                for (int j = i; j < courseCount - 1; j++) {
                    courses[j] = courses[j + 1]; // Move next element forward
                }

                courses[courseCount - 1] = null; // Clear last slot
                courseCount--; // Reduce count

                System.out.println("Course deleted successfully.");
                break;
            }
        }

        if (!found) { // If not found
            System.out.println("Course not found.");
        }
    }
    
    public void displayCourses() { // Function to display all courses
        
        if(courseCount == 0){ // Check if empty
            System.out.println("No courses created! Exiting function...");
            return; // Exit
        }
        
        for (int i = 0; i < courseCount; i++) { // Loop through courses
            
            System.out.println("Course " + (i + 1)); // Display course index
            System.out.println("Name: " + courses[i].getName()); // Display name
            System.out.println("Code: " + courses[i].getCode()); // Display code
            System.out.println("Credit Hour: " + courses[i].getCredits()); // Display credits
            System.out.println("Summary: " + courses[i].getSummary()); // Display summary
            System.out.println("Teams Link: " + courses[i].getLink()); // Display link
            System.out.println(); // Empty line for spacing
        }
    }
}
