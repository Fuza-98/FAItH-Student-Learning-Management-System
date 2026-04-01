/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faith_slms;

import java.util.*;

/**
 *
 * @author Fauzan
 * Update 1/4/2026: Added Student Management for the system. Not an April Fools joke
 */
public class FAiTH_SLMS {
    //Main class. Initialize objects here
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int choice = 0;
      CourseManager manager = new CourseManager(); //CourseManager object will contain Course array ~Fauzan
      StudentManager studManager = new StudentManager(); //StudentManager object to manage student details ~Fauzan
      System.out.println("\n===== FAITH SLMS =====");
      do{ // (9/3/2026) Extended Haris version of menu ~Fauzan
          System.out.println("\n===== COURSE MANAGEMENT =====");
          System.out.println("1. Create Course");
          System.out.println("2. Display Courses");
          System.out.println("3. Search Course");
          System.out.println("4. Edit Course");
          System.out.println("5. Delete Course");
          System.out.println("\n===== STUDENT MANAGEMENT =====");
          System.out.println("6. Add Student");
          System.out.println("7. Display Students");
          System.out.println("8. Search Student");
          System.out.println("9. Edit Student");
          System.out.println("0. Remove Student");
          System.out.println("-1. Exit");
          System.out.print("Enter choice: ");
          choice = input.nextInt();
          System.out.print("\n");
          switch(choice){
              case 1:
                  manager.createCourse();
                  break;
              case 2:
                  manager.displayCourses();
                  break;
              case 3:
                  manager.searchCourse();
                  break;
              case 4:
                  manager.editCourse();
                  break;
              case 5:
                  manager.deleteCourse();
                  break;
              case 6:
                  studManager.addStudent();
                  break;
              case 7:
                  studManager.displayStudents();
                  break;
              case 8:
                  studManager.searchStudent();
                  break;
              case 9:
                  studManager.editStudent();
                  break;
              case 0:
                  studManager.deleteStudent();
                  break;
          } 
    }while(choice != -1);
      
    }
    
}
