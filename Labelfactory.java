package com.cse.ju.oop.ui;

import javax.swing.*;
import java.awt.*;

public class LabelFactory {
    // Existing method with a customizable font
    public static JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    // New overloaded method to include text color
    public static JLabel createLabel(String text, Font font, Color textColor) {
        JLabel label = createLabel(text, font);
        label.setForeground(textColor);  // Set the text color
        return label;
    }

    // New overloaded method to include background color
    public static JLabel createLabel(String text, Font font, Color textColor, Color backgroundColor) {
        JLabel label = createLabel(text, font, textColor);
        label.setOpaque(true); // Necessary to show the background color
        label.setBackground(backgroundColor); // Set the background color
        return label;
    }

    // Additional method to set alignment
    public static JLabel createLabel(String text, Font font, Color textColor, int alignment) {
        JLabel label = createLabel(text, font, textColor);
        label.setHorizontalAlignment(alignment); // Set horizontal alignment
        return label;
    }
    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        return label;
    }
    public static JLabel createLabel(String text, int fontSize, boolean isBold) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Times New Roman", isBold ? Font.BOLD : Font.PLAIN, fontSize));
        return label;
    }

}