package com.company;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CGPAForecast extends JFrame {
    private List<JTextField> cgpaFields;
    private int n;
    private String name, pass;
    public CGPAForecast(int n,String name, String pass) {
        this.name = name;
        this.pass = pass;
        this.n = n;
        this.cgpaFields = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Enter CGPA for Semesters");
        ImageIcon logo = new ImageIcon("C:\\Users\\HP\\Downloads\\_ੈ✧‧₊˚༄.jpeg");
        setIconImage(logo.getImage());
        setLayout(new GridLayout(n + 1, 2, 10, 10));  //

        for (int i = 1; i <= n; i++) {
            add(new JLabel("Enter CGPA for semester " + i + ":"));
            JTextField cgpaField = new JTextField(10);
            cgpaFields.add(cgpaField);
            add(cgpaField);
        }


        JButton confirmButton = new JButton("Submit");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                forecast();
            }
        });

        add(new JLabel());
        add(confirmButton);

        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void forecast() {
        try {
            SimpleRegression regression = new SimpleRegression();
            double[] cgpaValues = new double[n];

            for (int i = 1; i <= n; i++) {
                double cgpa = Double.parseDouble(cgpaFields.get(i - 1).getText());
                regression.addData(i, cgpa);  // Semester number as X, CGPA as Y
                cgpaValues[i - 1] = cgpa;
            }

            double CGPA = regression.predict(n + 1);
            double predictedCGPA = Math.round(CGPA * 100.0) / 100.0;

            try(Connection connection = DatabaseConnection.getconnection()){
                if (connection == null) {
                    System.out.println("Connection is null. Check the DatabaseConnection class.");
                    return;
                }

                String sql = "UPDATE info SET grade = ?, semester = ? WHERE name = ? AND pass = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setDouble(1,predictedCGPA);
                statement.setInt(2,n+1);
                statement.setString(3,name);
                statement.setString(4,pass);
                int rows_affected = statement.executeUpdate();

                if (rows_affected > 0) {
                    System.out.println("Update successful. Rows affected: " + rows_affected);
                } else {
                    System.out.println("No rows updated. Check if the user exists.");
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
            }

            JOptionPane.showMessageDialog(null, "Predicted CGPA for semester " + (n + 1) + " is: " + predictedCGPA);
            ForecastGraph graph = new ForecastGraph(cgpaValues);
            graph.setVisible(true);
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for CGPA.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
        }

    }

}
