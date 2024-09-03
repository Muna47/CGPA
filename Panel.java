
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Panel extends JFrame {
    Panel(){

        Border border = BorderFactory.createMatteBorder(5,5,5,5,new Color(58,90,132));

        this.setSize(480, 400);
        this.setVisible(true);
        this.setTitle("Weather project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close this when click close icon
        //this.getContentPane().setBackground(Color.pink);
        this.getContentPane().setBackground(new Color(222, 152, 198)); //rgb color
        ImageIcon image = new ImageIcon("C:\\Users\\HP\\Downloads\\weather.png");
        this.setIconImage(image.getImage());

    }
}