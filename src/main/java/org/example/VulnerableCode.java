package org.example;

import java.io.*;

public class VulnerableCode {

    // SQL Injection vulnerability
    public void executeQuery(String userInput) {
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
        // Execute query
    }

    // Cross-site Scripting (XSS) vulnerability
    public String displayMessage(String message) {
        return "<script>alert('" + message + "');</script>";
    }

    // Command Injection vulnerability
    public void executeCommand(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    // Insecure Random Number Generator
    public int generateRandomNumber() {
        return (int) (Math.random() * 100);
    }

    // Null pointer dereference
    public void dereferenceNull(String str) {
        System.out.println(str.length());
    }

    // Code injection via Deserialization
    public void deserializeObject(byte[] data) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object obj = ois.readObject();
        System.out.println(obj);
    }

    // Hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean authenticate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // Use of outdated cryptographic algorithm
    public void encryptData(String data) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES"); // Weak algorithm
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, new javax.crypto.spec.SecretKeySpec("password".getBytes(), "DES"));
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        System.out.println(encryptedData);
    }

    // Hardcoded API keys
    private static final String API_KEY = "YOUR_API_KEY";

    public String getApiKey() {
        System.out.println("Random Text Change2");
        return API_KEY;
    }
}
