package main;

import java.util.Scanner;
import model.Student;
import service.StudentService;

public class Main {

    // VALID INTEGER INPUT
    public static int getValidInt(Scanner sc) {
        while (true) {
            try {
                int value = sc.nextInt();
                sc.nextLine(); // clear buffer
                return value;
            } catch (Exception e) {
                System.out.println("Enter valid number!");
                sc.nextLine(); // clear wrong input
            }
        }
    }

    //  VALID MARKS INPUT
    public static double getValidMarks(Scanner sc) {
        while (true) {
            try {
                double m = sc.nextDouble();
                sc.nextLine(); // clear buffer

                if (m >= 0 && m <= 100) return m;
                else System.out.println(" Marks must be between 0 and 100");

            } catch (Exception e) {
                System.out.println("Enter valid marks!");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = getValidInt(sc);

            switch (choice) {

                case 1:

    int id;

    //  Duplicate check loop
    while (true) {
        System.out.print("Enter ID: ");
        id = getValidInt(sc);

        if (service.searchStudent(id) != null) {
            System.out.println("ID already exists! Try another.");
        } else {
            break;
        }
    }

    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Marks: ");
    double marks = getValidMarks(sc);

    service.addStudent(new Student(id, name, marks));
    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    Student s = service.searchStudent(getValidInt(sc));
                    System.out.println(s != null ? s : " Student not found!");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = getValidInt(sc);

                    System.out.print("Enter new name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter new marks: ");
                    double umarks = getValidMarks(sc);

                    service.updateStudent(uid, uname, umarks);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    service.deleteStudent(getValidInt(sc));
                    break;

                case 6:
                    System.out.println(" Thank you! Exiting...");
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}