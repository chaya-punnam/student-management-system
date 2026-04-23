package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db",
                "root",
                "Prasanna@123"
            );
        } catch (Exception e) {
            System.out.println(" DB Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}