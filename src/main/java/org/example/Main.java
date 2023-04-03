package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("CRUD Operations on Students");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradb", "user", "pass");
            Statement statement = connection.createStatement();

            // Insert a new record
            String email = "MrD@gmail.com";
            String name = "MrD";
            statement.executeUpdate("INSERT INTO student (name, email) VALUES ('" + name + "', '" + email + "');");

            // Display all records
            System.out.println("Display All Students:");
            ResultSet rs = statement.executeQuery("SELECT * FROM student;");
            while (rs.next()){
                int id = rs.getInt("id");
                String studentName = rs.getNString("name");
                String studentEmail = rs.getNString("email");
                System.out.println("ID: " + id + ", Name: " + studentName + ", Email: " + studentEmail);
            }

            // Update a record
            int idToUpdate = 1;
            String newName = "Mra";
            statement.executeUpdate("UPDATE student SET name = '" + newName + "' WHERE id = " + idToUpdate + ";");
            System.out.println("Updated record with ID: " + idToUpdate + ", to Have the NAME: " + newName);

            // Display the updated record
            rs = statement.executeQuery("SELECT * FROM student WHERE id = " + idToUpdate + ";");
            while (rs.next()){
                int id = rs.getInt("id");
                String studentName = rs.getNString("name");
                String studentEmail = rs.getNString("email");
                System.out.println("ID: " + id + ", Name: " + studentName + ", Email: " + studentEmail);
            }

            // Delete a record
            int idToDelete = 2;
            statement.executeUpdate("DELETE FROM student WHERE id =" + idToDelete + ";");
            System.out.println("Deleted record with the ID: " + idToDelete);

            // Display all records again
            rs = statement.executeQuery("SELECT * FROM student;");
            while (rs.next()){
                int id = rs.getInt("id");
                String studentName = rs.getNString("name");
                String studentEmail = rs.getNString("email");
                System.out.println("ID: " + id + ", Name: " + studentName + ", Email: " + studentEmail);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




