import javax.swing.*;
import java.awt.*;

class Main{
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() ->{
            //Welcome frame = new Welcome();
        });
    }
    public JButton button_func(String name, int x, int y, int w, int h, int r, int g, int b){
        JButton button = new JButton(name);
        button.setFocusable(false);
        button.setBounds(x, y,w,h);
        button.setFont(new Font("mv boli", Font.BOLD, 20));
        button.setForeground(new Color(r,g,b));
        button.setBackground(Color.WHITE);
        return button;
    }
}
