package a0430c;
/*
We are going to do some drawing in our GUI interface
 */
import java.awt.*;
import javax.swing.*;

class MyGraphics extends JPanel{
    public void paint(Graphics g){
        Font font = new Font("Chiller", Font.BOLD, 48);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawLine(10,10,500,10); //horizontal line because same y
        g.drawRect(10,20,50,70); //x,y,w,h
        g.drawOval(10,100,60,20); //x, y, w, h
        g.drawString("Hello", 20, 160); //string,x,y
        g.fillRect(30,175,50,50); ///square
        g.fillOval(30, 300, 50, 50); //circle
    }
}

public class A0430c {
    public static void main(String[] args) {
        JFrame draw = new JFrame("My Drawing");
        MyGraphics graph = new MyGraphics();
        
        draw.add(graph);
        draw.setSize(800,600);
        draw.setLocation(100,100);
        draw.setVisible(true);
        draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
