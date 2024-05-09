package org.example;

import java.io.*;

public class VulnerableCode2 {
    public static void main(String[] args) {
        // SQL Injection Vulnerability
        String userInput = args[0];
        String sqlQuery = "SELECT * FROM users WHERE username = '" + userInput + "'";

        // Command Injection Vulnerability
        try {
            String command = "ls " + userInput;
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cross-Site Scripting (XSS) Vulnerability
        String userMessage = "<script>alert('You have been hacked!');</script>";
        System.out.println("User message: " + userMessage);

        // Insecure Random Number Generator Vulnerability
        double randomValue = Math.random();
        System.out.println("Random value2: " + randomValue);
    }
}