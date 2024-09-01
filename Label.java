import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Label extends JFrame {
    Label(){
        ImageIcon img = new ImageIcon("C:\\Users\\HP\\Downloads\\thunder.png");
        Border border = BorderFactory.createMatteBorder(5,5,5,5,new Color(58,90,132));

        JLabel label = new JLabel();
        label.setIcon(img);
        label.setText("It will be raining");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.CYAN);
        label.setFont(new Font("MV Boli", Font.PLAIN, 23));
        label.setIconTextGap(-1);
        label.setBorder(border);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        this.setSize(480, 400);
        this.setVisible(true);
        this.setTitle("Weather project");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close this when click close icon
        //this.getContentPane().setBackground(Color.pink);
        this.getContentPane().setBackground(new Color(222, 152, 198)); //rgb color
        ImageIcon image = new ImageIcon("C:\\Users\\HP\\Downloads\\weather.png");
        this.setIconImage(image.getImage());
        this.add(label);
    }
}