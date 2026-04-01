/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms;

import java.util.*;

/**
 *
 * @author Fauzan
 * This class has the same function as StudentManager to actually manage and manipulate the info from the Student class
 */
public class StudentManager {
    private Student[] students = new Student[2];
    private int studentCount = 0;

    public void addStudent() { 
        
        //Create function ~Fauzan
        Scanner input = new Scanner(System.in);
        if (studentCount >= students.length) { // Prevent out-of-bound error
            System.out.println("Cannot add more students. Array is full.");
            return;
        }
        
        System.out.print("Enter student first name: ");
        String first_name = input.next();
        
        input.nextLine();
        
        System.out.print("Enter student last name: ");
        String last_name = input.next();
        
        input.nextLine();
        
        System.out.print("Enter id: ");
        String id = input.nextLine();
        
        System.out.print("Enter email: ");
        String email = input.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone_number = input.nextLine();
        
        Student newStudent = new Student(first_name, last_name, id, email, phone_number);
        students[studentCount] = newStudent;
        studentCount++;

        System.out.println("Student added successfully.");
    }

    //Edit function development ~Aisar
    public void editStudent() {
        Scanner input = new Scanner(System.in);

        if (studentCount == 0) {
            System.out.println("No students available to edit.");
            return;
        }

        System.out.print("Enter student id to edit: ");
        String searchID = input.nextLine();
    
        boolean found = false;
    
        for (int i = 0; i < studentCount; i++) {
    
            if (students[i].getID().equalsIgnoreCase(searchID)) {
                found = true;
    
                System.out.println("\nStudent found!");
                System.out.println("Current Student Details:");
                System.out.println("Name: " + students[i].getFirstName() + " " + students[i].getLastName());
                System.out.println("ID: " + students[i].getID());
                System.out.println("Email: " + students[i].getEmail());
                System.out.println("Phone Number: " + students[i].getPhone());
  
    
                // Editing attributes (except student id)
                System.out.print("\nEnter new student first name: ");
                String newFirstName = input.next();
                students[i].setFirstName(newFirstName);
                
                input.nextLine();
                
                System.out.print("\nEnter new student last name: ");
                String newLastName = input.next();
                students[i].setLastName(newLastName);
                
                input.nextLine();
    
                System.out.print("Enter new email: ");
                String newEmail = input.nextLine(); //No need to clear buffer since it's already a string
                students[i].setEmail(newEmail);
    
                System.out.print("Enter new phone number: ");
                String newPhone = input.nextLine();
                students[i].setPhone(newPhone);
   
    
                // Display updated student
                System.out.println("\nStudent updated successfully!");
                System.out.println("Updated Student Details:");
                System.out.println("Name: " + students[i].getFirstName() + students[i].getLastName());
                System.out.println("ID: " + students[i].getID());
                System.out.println("Email: " + students[i].getEmail());
                System.out.println("Phone: " + students[i].getPhone());

    
                break;
            }
        }
    
        if (!found) {
            System.out.println("Student not found.");
        }
    }
    
    public void searchStudent() { //Search function by Haris
    Scanner input = new Scanner(System.in);

    if (studentCount == 0) {
        System.out.println("No students available.");
        return;
    }

    System.out.print("Enter student id to search: ");
    String searchID = input.nextLine();

    boolean found = false;

    for (int i = 0; i < studentCount; i++) {

        if (students[i].getID().equalsIgnoreCase(searchID)) {

            System.out.println("\nStudent Found!");
            System.out.println("Name: " + students[i].getFirstName());
            System.out.println("ID: " + students[i].getID());
            System.out.println("Email: " + students[i].getEmail());
            System.out.println("Phone: " + students[i].getPhone());

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student not found.");
    }
}

    public void deleteStudent() { //By Icap
    Scanner input = new Scanner(System.in);

    if (studentCount == 0) {
        System.out.println("No students available to delete.");
        return;
    }

    System.out.print("Enter student id to delete: ");
    String searchID = input.nextLine();

    boolean found = false;

    for (int i = 0; i < studentCount; i++) {
        if (students[i].getID().equalsIgnoreCase(searchID)) {
            found = true;

            // Shift students left to overwrite the deleted student
            for (int j = i; j < studentCount - 1; j++) {
                students[j] = students[j + 1];
            }
            students[studentCount - 1] = null; // Clear last element
            studentCount--;

            System.out.println("Student removed successfully.");
            break;
        }
    }

    if (!found) {
        System.out.println("Student not found.");
    }
}
    
    public void displayStudents() { //Basic displaying function. Akan tukar ke format table nnti ~Fauzan
        if(studentCount == 0){
            System.out.println("No students created! Exiting function...");
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Name: " + students[i].getFirstName() + " " + students[i].getLastName());
            System.out.println("ID: " + students[i].getID());
            System.out.println("Email: " + students[i].getEmail());
            System.out.println("Phone: " + students[i].getPhone());
            System.out.println();
        }
    }
}
