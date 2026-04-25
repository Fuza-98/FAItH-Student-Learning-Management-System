/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms; // Declare package name

import java.util.*; // Import utilities (Scanner used)

/**
 *
 * @author Fauzan
 * This class has the same function as StudentManager to actually manage and manipulate the info from the Student class
 */
public class StudentManager { // Define StudentManager class
    
    private Student[] students = new Student[100]; // Array to store Student objects (size 100)
    private int studentCount = 0; // Counter to track number of students
    
    //These 3 methods before the add function are helper methods for the RelationshiManager
    public int getStudentCount(){
        return studentCount;
    }

    public Student getStudentByIndex(int index){
        if(index >= 0 && index < studentCount){
            return students[index];
        }
        return null;
    }
    
    public int findStudentIndexById(String id){
        for(int i = 0; i < studentCount; i++){
            if(students[i].getID().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }
    public void addStudent() { 
        
        // Function to create and add new student
        Scanner input = new Scanner(System.in); // Create Scanner object
        
        if (studentCount >= students.length) { // Check if array is full
            System.out.println("Cannot add more students. Array is full.");
            return; // Exit function
        }
        
        System.out.print("Enter student first name: "); // Prompt
        String first_name = input.next(); // Read first name
        
        input.nextLine(); // Clear buffer
        
        System.out.print("Enter student last name: "); // Prompt
        String last_name = input.next(); // Read last name
        
        input.nextLine(); // Clear buffer
        
        System.out.print("Enter id: "); // Prompt
        String id = input.nextLine(); // Read ID
        
        System.out.print("Enter email: "); // Prompt
        String email = input.nextLine(); // Read email
        
        System.out.print("Enter phone number: "); // Prompt
        String phone_number = input.nextLine(); // Read phone number
        
        Student newStudent = new Student(first_name, last_name, id, email, phone_number); // Create Student object
        students[studentCount] = newStudent; // Store in array
        studentCount++; // Increase count

        System.out.println("Student added successfully."); // Confirmation
    }

    // Function to edit student
    public void editStudent() {
        Scanner input = new Scanner(System.in); // Create Scanner object

        if (studentCount == 0) { // Check if empty
            System.out.println("No students available to edit.");
            return; // Exit
        }

        System.out.print("Enter student id to edit: "); // Prompt
        String searchID = input.nextLine(); // Read input
    
        boolean found = false; // Flag
    
        for (int i = 0; i < studentCount; i++) { // Loop
    
            if (students[i].getID().equalsIgnoreCase(searchID)) { // Compare ID
                found = true;
    
                System.out.println("\nStudent found!");
                System.out.println("Current Student Details:");
                System.out.println("Name: " + students[i].getFirstName() + " " + students[i].getLastName());
                System.out.println("ID: " + students[i].getID());
                System.out.println("Email: " + students[i].getEmail());
                System.out.println("Phone Number: " + students[i].getPhone());
  
                // Update attributes (except ID)
                System.out.print("\nEnter new student first name: ");
                String newFirstName = input.next(); // Read new first name
                students[i].setFirstName(newFirstName); // Update
                
                input.nextLine(); // Clear buffer
                
                System.out.print("\nEnter new student last name: ");
                String newLastName = input.next(); // Read new last name
                students[i].setLastName(newLastName); // Update
                
                input.nextLine(); // Clear buffer
    
                System.out.print("Enter new email: ");
                String newEmail = input.nextLine(); // Read new email
                students[i].setEmail(newEmail); // Update
    
                System.out.print("Enter new phone number: ");
                String newPhone = input.nextLine(); // Read new phone
                students[i].setPhone(newPhone); // Update
   
                // Display updated student
                System.out.println("\nStudent updated successfully!");
                System.out.println("Updated Student Details:");
                System.out.println("Name: " + students[i].getFirstName() + students[i].getLastName());
                System.out.println("ID: " + students[i].getID());
                System.out.println("Email: " + students[i].getEmail());
                System.out.println("Phone: " + students[i].getPhone());

                break; // Exit loop
            }
        }
    
        if (!found) { // If not found
            System.out.println("Student not found.");
        }
    }
    
    public void searchStudent() { // Function to search student
        Scanner input = new Scanner(System.in); // Create Scanner

        if (studentCount == 0) { // Check if empty
            System.out.println("No students available.");
            return;
        }

        System.out.print("Enter student id to search: "); // Prompt
        String searchID = input.nextLine(); // Read input

        boolean found = false; // Flag

        for (int i = 0; i < studentCount; i++) { // Loop

            if (students[i].getID().equalsIgnoreCase(searchID)) { // Compare

                System.out.println("\nStudent Found!");
                System.out.println("Name: " + students[i].getFirstName());
                System.out.println("ID: " + students[i].getID());
                System.out.println("Email: " + students[i].getEmail());
                System.out.println("Phone: " + students[i].getPhone());

                found = true;
                break;
            }
        }

        if (!found) { // If not found
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent() { // Function to delete student
        Scanner input = new Scanner(System.in); // Create Scanner

        if (studentCount == 0) { // Check if empty
            System.out.println("No students available to delete.");
            return;
        }

        System.out.print("Enter student id to delete: "); // Prompt
        String searchID = input.nextLine(); // Read input

        boolean found = false; // Flag

        for (int i = 0; i < studentCount; i++) { // Loop
            if (students[i].getID().equalsIgnoreCase(searchID)) { // Compare
                found = true;

                // Shift elements left
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1]; // Move element
                }

                students[studentCount - 1] = null; // Clear last slot
                studentCount--; // Reduce count

                System.out.println("Student removed successfully.");
                break;
            }
        }

        if (!found) { // If not found
            System.out.println("Student not found.");
        }
    }
    
    public void displayStudents() { // Function to display all students
        
        if(studentCount == 0){ // Check if empty
            System.out.println("No students created! Exiting function...");
            return;
        }
        
        for (int i = 0; i < studentCount; i++) { // Loop
            
            System.out.println("Student " + (i + 1)); // Display index
            System.out.println("Name: " + students[i].getFirstName() + " " + students[i].getLastName());
            System.out.println("ID: " + students[i].getID());
            System.out.println("Email: " + students[i].getEmail());
            System.out.println("Phone: " + students[i].getPhone());
            System.out.println(); // Spacing
        }
    }
}
