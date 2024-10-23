import javax.swing.*;
import java.awt.*;
public class Button{

    public static JButton createButton(String text, Font font, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setPreferredSize(new Dimension(width, height));
        return button;
    }

    public static JButton createButton(String text, Font font, int width, int height, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(bgColor);
        return button;
    }

    public static JButton createButton(String text, Font font, int width, int height, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        return button;
    }
}