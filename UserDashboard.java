package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDashboard extends JFrame {
    public UserDashboard(int roll, String name, double grade, int sem_no, String pass) {
        setTitle("User Dashboard");
        setSize(676, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon("C:\\Users\\HP\\Downloads\\_ੈ✧‧₊˚༄.jpeg");
        setIconImage(logo.getImage());

        Font labelFont = new Font("SansSerif", Font.BOLD, 20);

        JLabel rollLabel = new JLabel("Roll: " + roll);
        rollLabel.setFont(labelFont);
        JLabel nameLabel = new JLabel("Name: " + name);
        nameLabel.setFont(labelFont);
        JLabel text = new JLabel("Previously....");
        text.setFont(labelFont);
        JLabel semLabel = new JLabel("Semester no: " + sem_no);
        semLabel.setFont(labelFont);
        JLabel gradeLabel = new JLabel("Predicted grade: " + String.format("%.2f", grade));
        gradeLabel.setFont(labelFont);

        JButton forecastButton = new JButton("New Forecast");
        forecastButton.setFocusable(false);
        forecastButton.setSize(150,100);
        forecastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Semester_choice(name, pass);
            }
        });

        JButton closeButton = new JButton("Exit");
        closeButton.setFocusable(false);
        closeButton.setSize(150,100);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        ImageIcon bgImage = new ImageIcon("C:\\Users\\HP\\Pictures\\forecast_pics\\info.png");
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(rollLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 3;
        panel.add(text, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        panel.add(semLabel, gbc);

        gbc.gridx = 1;
        panel.add(gradeLabel, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(forecastButton, gbc);

        gbc.gridx = 1;
        panel.add(closeButton, gbc);

        add(panel);
        setVisible(true);
    }
}
