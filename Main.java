package com.company;
<<<<<<< HEAD

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

=======

import javax.swing.*;
import java.awt.*;

>>>>>>> fc9cf8f44f469b5f6c981794741622204e087eb1
class Main {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Welcome().setVisible(true));
    }

    public JButton button_func(String name, int x, int y, int w, int h, int r, int g, int b) {
        JButton button = new JButton(name);
        button.setFocusable(false);
        button.setBounds(x, y, w, h);
        button.setFont(new Font("MV Boli", Font.BOLD, 20));
        button.setForeground(new Color(r, g, b));
        button.setBackground(Color.WHITE);
        return button;
    }
}
