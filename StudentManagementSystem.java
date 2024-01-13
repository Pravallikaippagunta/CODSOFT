import java.util.ArrayList;
import java.util.Scanner;
public class StudentManagementSystem {
    class Student {
        String name;
        int rollNumber;
        char grade;
        public Student(String name, int rollNumber, char grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }
    }
    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = getPositiveIntInput();
        System.out.print("Enter grade: ");
        char grade = sc.next().charAt(0);
        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully");
    }
    public void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to remove");
            return;
        }
        System.out.print("Enter roll number of the student to remove: ");
        int rollToRemove = getPositiveIntInput();
        boolean removed = false;
        for (Student student : students) {
            if (student.rollNumber == rollToRemove) {
                students.remove(student);
                removed = true;
                System.out.println("Student removed successfully");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found with the given roll number");
        }
    }
    public void searchStudent() {
        if (students.isEmpty()) {
            System.out.println("No students to search");
            return;
        }
        System.out.print("Enter roll number of the student to search: ");
        int rollToSearch = getPositiveIntInput();
        boolean found = false;
        for (Student student : students) {
            if (student.rollNumber == rollToSearch) {
                System.out.println("Student found - Name: " + student.name + ", Roll Number: " + student.rollNumber + ", Grade: " + student.grade);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found with the given roll number");
        }
    }
    private int getPositiveIntInput() {
        int input;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input");
                sc.next();
            }
            input = sc.nextInt();
            if (input <= 0) {
                System.out.println("Please enter a positive integer");
            }
        } while (input <= 0);
        sc.nextLine();
        return input;
    }
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println("Name: " + student.name + ", Roll Number: " + student.rollNumber + ", Grade: " + student.grade);
            }
        }
    }
    public void run() {
        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = getPositiveIntInput();
            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                removeStudent();
            } else if (choice == 3) {
                searchStudent();
            } else if (choice == 4) {
                displayAllStudents();
            } else if (choice == 5) {
                System.out.println("Exiting Student Management System");
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.run();
    }
}