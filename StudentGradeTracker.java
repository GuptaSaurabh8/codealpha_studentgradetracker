import java.util.ArrayList;
import java.util.Scanner;

// Class to store each student's name, marks, and grade
class Student {
    String name;
    int marks;
    String grade;

    // Constructor to initialize student data and calculate grade
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    // Method to assign grade based on marks
    private String calculateGrade(int marks) {
        if (marks >= 80) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "D";
    }
}

// Main class to run the Grade Tracker
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("📚 Welcome to the Student Grade Tracker");

        // Ask how many students' data to enter
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input each student's data
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks for " + name + ": ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume newline

            students.add(new Student(name, marks));
        }

        // Calculate total, highest, and lowest marks
        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                topStudent = s.name;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowStudent = s.name;
            }
        }

        double average = (double) total / students.size();

        // Display the report
        System.out.println("\n📄 --- Grade Report ---");
        System.out.println("Name\tMarks\tGrade");
        for (Student s : students) {
            System.out.println(s.name + "\t" + s.marks + "\t" + s.grade);
        }

        System.out.printf("\nAverage Marks: %.2f\n", average);
        System.out.println("Highest Marks: " + highest + " by " + topStudent);
        System.out.println("Lowest Marks: " + lowest + " by " + lowStudent);
    }
}
