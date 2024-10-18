package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login_info extends JFrame {
    private JTextField usernameField = new JTextField(100);
    private JPasswordField passwordField = new JPasswordField(100);
    private JButton loginButton;

    JLabel l1 = new JLabel("Student name: ");
    JLabel l2 = new JLabel("Password: ");
    Login_info() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Page");

        setLayout(new GridLayout(3,2,10,10));
        add(l1);
        add(usernameField);
        add(l2);
        add(passwordField);
        add(new JLabel());

        l1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Submit");
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loginUser();
            }
        });

        getContentPane().setBackground(new Color(191,210,250));
        ImageIcon logo = new ImageIcon("C:\\Users\\HP\\Downloads\\_ੈ✧‧₊˚༄.jpeg");
        setIconImage(logo.getImage());
        setSize(400,300);
        setLocationRelativeTo(null);
    }
    public void loginUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        try (Connection connection = DatabaseConnection.getconnection()) {
            String query = "SELECT roll, name, grade, semester FROM info WHERE name = ? AND pass = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int roll = rs.getInt("roll");
                String name = rs.getString("name");
                double grade = rs.getDouble("grade");
                int semester = rs.getInt("semester");

                new UserDashboard(roll, name, grade,semester,password);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
