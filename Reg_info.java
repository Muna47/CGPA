package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reg_info extends JFrame implements ActionListener{
    private final JTextField username = new JTextField(100);
    private final JTextField user_roll = new JTextField(100);
    private final JPasswordField password = new JPasswordField(100);

    JButton button = new JButton("register");
    JPanel panel = new JPanel();
    JLabel l1 = new JLabel("Name");
    JLabel l2 = new JLabel("Roll");
    JLabel l3 = new JLabel("Password");
    JLabel l4 = new JLabel("Confirm");

    Reg_info() {
        setTitle("Registration Form");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(4,2,10,10);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l2.setHorizontalAlignment(SwingConstants.CENTER);
        l3.setHorizontalAlignment(SwingConstants.CENTER);
        l4.setHorizontalAlignment(SwingConstants.CENTER);

        panel.setLayout(layout);
        panel.add(l1);
        panel.add(username);
        panel.add(l2);
        panel.add(user_roll);
        panel.add(l3);
        panel.add(password);
        panel.add(l4);
        panel.add(button);
        panel.setBackground(new Color(191,210,250));
        button.setFocusable(false);

        l1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l3.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l4.setFont(new Font("Times New Roman", Font.BOLD, 22));

        setSize(450,300);
        setLocationRelativeTo(null);
        add(panel);
        ImageIcon logo = new ImageIcon("C:\\Users\\HP\\Downloads\\_ੈ✧‧₊˚༄.jpeg");
        setIconImage(logo.getImage());
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            String Name = username.getText();
            String Roll = user_roll.getText();
            String Pass = new String(password.getPassword());
            reg_user(Name, Roll, Pass);
        }
    }
    public void reg_user(String Name, String Roll, String Pass) {
        if (Name.isEmpty() || Pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and Password are required.");
            return;
        }
        try (Connection connection = DatabaseConnection.getconnection()) {
            String query = "INSERT INTO info (name, roll, pass, grade, semester) VALUES (?,?,?,null,null)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Name);
            statement.setInt(2, Integer.parseInt(Roll));
            statement.setString(3, Pass);

            int rowAffected = statement.executeUpdate();

            if (rowAffected > 0) {
                this.dispose();
                JOptionPane.showMessageDialog(this, "Registration completed successfully!!");
                new Semester_choice(Name,Pass);
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
