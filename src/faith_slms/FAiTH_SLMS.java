/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faith_slms;

import java.util.*;

/**
 *
 * @author Fauzan
 */
public class FAiTH_SLMS {
    //Main class. Initialize objects here
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int choice = 0;
      CourseManager manager = new CourseManager(); //CourseManager object will contain Course array ~Fauzan
      
      do{ // (9/3/2026) Extended Haris version of menu ~Fauzan
          System.out.println("\n===== COURSE MANAGEMENT =====");
          System.out.println("1. Create Course");
          System.out.println("2. Display Courses");
          System.out.println("3. Search Course");
          System.out.println("4. Edit Course");
          System.out.println("5. Delete Course");
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
          } 
    }while(choice != -1);
      
    }
    
}
