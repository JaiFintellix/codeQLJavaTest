package org.example;
import java.sql.*;

public class Main {

    public static String PASSWORD = "PASSWORD123";


    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main app = new Main();
        app.getUserInfo("admin'; DROP TABLE users; --"); // SQL injection attempt
        System.out.println(app.displayMessage("<script>alert('XSS attack')</script>")); // XSS attack
        System.out.println(app.encryptPassword("password")); // Insecure encryption
        System.out.println(PASSWORD); // Insecure encryption

    }


    // Method vulnerable to SQL injection
    public void getUserInfo(String username) {
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method vulnerable to cross-site scripting (XSS)
    public String displayMessage(String message) {
        return "<div>" + message + "</div>";
    }

    // Method with insecure cryptographic usage
    public int encryptPassword(String password) {
        // Insecure encryption method using weak algorithm
        // DO NOT USE THIS IN PRODUCTION
        return password.hashCode(); // Hashing algorithm not suitable for password storage
    }


}