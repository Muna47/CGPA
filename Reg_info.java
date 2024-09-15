package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reg_info extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;

    Reg_info() {
        setTitle("User Registration");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create form fields
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        registerButton = new JButton("Register");

        // Layout setup
        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(registerButton);

        add(panel);

        // Register button action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and Password are required.");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
