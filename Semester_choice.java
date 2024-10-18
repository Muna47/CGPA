package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Semester_choice extends JFrame implements ActionListener {
    private String name,pass;
    JPanel panel = new JPanel();
    JLabel label = new JLabel("How many semester's cgpa you want to enter: ");
    JComboBox combo;
    Semester_choice(String name, String pass){
        this.name = name;
        this.pass = pass;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Semester number");

        Integer[] option = {2,3,4,5,6,7};
        combo = new JComboBox(option);
        combo.setSelectedIndex(0);
        combo.addActionListener(this);

        label.setFont(new Font("Times New Roman", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label);
        panel.add(combo);
        panel.setBackground(new Color(205,221,246));

        setSize(400,200);
        setVisible(true);
        add(panel);
        setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon("C:\\Users\\HP\\Downloads\\_ੈ✧‧₊˚༄.jpeg");
        setIconImage(logo.getImage());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == combo){
            int num = (int)combo.getSelectedItem();
            new CGPAForecast(num, name, pass);
            this.dispose();
        }
    }
}
