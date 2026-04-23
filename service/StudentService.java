package service;

import java.sql.*;
import model.Student;
import util.DBConnection;

public class StudentService {

    //  ADD STUDENT
    public void addStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();

            // Duplicate check
            String checkQuery = "SELECT * FROM students WHERE id = ?";
            PreparedStatement checkPs = con.prepareStatement(checkQuery);
            checkPs.setInt(1, s.getId());

            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                System.out.println(" ID already exists!");
                return;
            }

            String query = "INSERT INTO students VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setDouble(3, s.getMarks());

            ps.executeUpdate();
            System.out.println(" Student Added!");

        } catch (Exception e) {
            System.out.println("Error adding student!");
        }
    }

    //  VIEW STUDENTS
    public void viewStudents() {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students ORDER BY id";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Marks: " + rs.getDouble("marks")
                );
            }

        } catch (Exception e) {
            System.out.println("Error fetching data!");
        }
    }

    //  SEARCH STUDENT
    public Student searchStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("marks")
                );
            }

        } catch (Exception e) {
            System.out.println("Error searching student!");
        }
        return null;
    }

    //  UPDATE STUDENT
    public void updateStudent(int id, String name, double marks) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "UPDATE students SET name=?, marks=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setDouble(2, marks);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(" Student Updated!");
            } else {
                System.out.println(" Student not found!");
            }

        } catch (Exception e) {
            System.out.println("Error updating student!");
        }
    }

    //  DELETE STUDENT
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(" Student Deleted!");
            } else {
                System.out.println(" Student not found!");
            }

        } catch (Exception e) {
            System.out.println("Error deleting student!");
        }
    }
}