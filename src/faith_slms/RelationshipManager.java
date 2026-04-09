/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faith_slms;

/**
 *
 * @author Acer
 */
public class RelationshipManager {
    private StudentManager studManager;
    private CourseManager courseManager;
    private boolean[][] enrollment;
    
    public RelationshipManager(StudentManager studManager, CourseManager courseManager){
        this.studManager = studManager;
        this.courseManager = courseManager;
        this.enrollment = new boolean[100][100];
    }
    
    public boolean assignStudentToCourse(String studentId, String courseCode) {
        int studentIndex = studManager.findStudentIndexById(studentId);
        int courseIndex = courseManager.findCourseIndexByCode(courseCode);
        
        if (courseIndex == -1 && studentIndex == -1) {
            System.out.println("Student not found.");
            System.out.println("Course not found.");
            return false;
        }
        
        if (studentIndex == -1) {
            System.out.println("Student not found.");
            return false;
        }

        if (courseIndex == -1) {
            System.out.println("Course not found.");
            return false;
        }

        if (enrollment[studentIndex][courseIndex]) {
            System.out.println("Student is already enrolled in this course.");
            return false;
        }

        enrollment[studentIndex][courseIndex] = true;
        System.out.println("Student successfully assigned to course.");
        return true;
    }
    
    public void listCoursesOfStudent(String studentId){
        int studentIndex = studManager.findStudentIndexById(studentId);
        if (studentIndex == -1) {
            System.out.println("Student not found.");
            return;
        }

        boolean found = false;
        System.out.println("Courses for student " + studentId + ":");

        for (int i = 0; i < courseManager.getCourseCount(); i++) {
            if (enrollment[studentIndex][i]) {
                Course course = courseManager.getCourseByIndex(i);
                System.out.println("Code: " + course.getCode());
                System.out.println("Name: " + course.getName());
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("This student has no assigned course.");
        }
    }
    
    public void listStudentsInCourse(String courseCode) {
        int courseIndex = courseManager.findCourseIndexByCode(courseCode);

        if (courseIndex == -1) {
            System.out.println("Course not found.");
            return;
        }

        boolean found = false;
        System.out.println("Students in course " + courseCode + ":");

        for (int i = 0; i < studManager.getStudentCount(); i++) {
            if (enrollment[i][courseIndex]) {
                Student student = studManager.getStudentByIndex(i);
                System.out.println("ID: " + student.getID());
                System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("This course has no assigned student.");
        }
    }
    
    public boolean isStudentEnrolled(String id, String courseCode) {
        int studentIndex = studManager.findStudentIndexById(id);
        int courseIndex = courseManager.findCourseIndexByCode(courseCode);

        if (studentIndex == -1 || courseIndex == -1) {
            return false;
        }

        return enrollment[studentIndex][courseIndex];
    }
    
    
   
}
