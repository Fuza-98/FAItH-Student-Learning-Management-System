/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faith_slms; // Declare package name

import java.util.*; // Import utilities (Scanner used)

/**
 *
 * @author Fauzan
 * Update 1/4/2026: Added Student Management for the system. Not an April Fools joke
 */
public class FAiTH_SLMS { // Main class
    
    // Main method - program starts here
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); // Create Scanner for user input
        int choice = 0; // Variable to store user menu choice
        
        CourseManager courseManager = new CourseManager(); // Object to manage courses
        StudentManager studManager = new StudentManager(); // Object to manage students
        RelationshipManager relManager = new RelationshipManager(studManager, courseManager); //Object to manage Course - Student relationship
        SuggestionService suggestionService = new SuggestionService();
        
        System.out.println("\n===== FAITH SLMS ====="); // Display system title
        
        do { // Loop menu until user exits
            
            System.out.println("\n===== COURSE MANAGEMENT ====="); // Course section
            System.out.println("1. Create Course"); // Option 1
            System.out.println("2. Display Courses"); // Option 2
            System.out.println("3. Search Course"); // Option 3
            System.out.println("4. Edit Course"); // Option 4
            System.out.println("5. Delete Course"); // Option 5
            
            System.out.println("\n===== STUDENT MANAGEMENT ====="); // Student section
            System.out.println("6. Add Student"); // Option 6
            System.out.println("7. Display Students"); // Option 7
            System.out.println("8. Search Student"); // Option 8
            System.out.println("9. Edit Student"); // Option 9
            System.out.println("0. Remove Student"); // Option 0
            
            System.out.println("\n===== RELATIONSHIP MANAGEMENT ====="); //Relationship Management
            System.out.println("10. Assign Student to Course"); //Option 10
            System.out.println("11. List Courses of a Student"); //Option 11
            System.out.println("12. List Students in a Course"); //Option 12
            System.out.println("-1. Exit"); // Exit option 
            
            System.out.print("Enter choice: "); // Prompt user
            choice = input.nextInt(); // Read user input
            
            System.out.print("\n"); // Print spacing
            
            switch(choice){ // Switch based on user choice
                
                case 1:
                    courseManager.createCourse(); // Call create course function
                    break;
                    
                case 2:
                    courseManager.displayCourses(); // Call display courses
                    break;
                    
                case 3:
                    courseManager.searchCourse(); // Call search course
                    break;
                    
                case 4:
                    courseManager.editCourse(); // Call edit course
                    break;
                    
                case 5:
                    courseManager.deleteCourse(); // Call delete course
                    break;
                    
                case 6:
                    studManager.addStudent(); // Call add student
                    break;
                    
                case 7:
                    studManager.displayStudents(); // Call display students
                    break;
                    
                case 8:
                    studManager.searchStudent(); // Call search student
                    break;
                    
                case 9:
                    studManager.editStudent(); // Call edit student
                    break;
                    
                case 0:
                    studManager.deleteStudent(); // Call delete student
                    break;
                case 10:
                    input.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = input.nextLine();

                    System.out.print("Enter course code: ");
                    String courseCode = input.nextLine();

                    relManager.assignStudentToCourse(studentId, courseCode);
                    break;

                case 11:
                    input.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentIdForCourses = input.nextLine();

                    relManager.listCoursesOfStudent(studentIdForCourses);
                    break;

                case 12:
                    input.nextLine();
                    System.out.print("Enter course code: ");
                    String courseCodeForStudents = input.nextLine();

                    relManager.listStudentsInCourse(courseCodeForStudents);
                    break;
                case 13:
                    input.nextLine();
                    System.out.print("Enter prefix: ");
                    String prefix = input.nextLine();
                
                    String[] suggestions = suggestionService.suggestFromCache(prefix);
                
                    System.out.println("Suggestions:");
                    for (String s : suggestions) {
                        System.out.println(s);
                    }
                    break;
            } 
            
        } while(choice != -1); // Repeat loop until user enters -1
        
    }
    
}
