package test;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Map extends JPanel {
    public Map() {
        setLayout(null);
       
        // Add labels for circles (nodes)
        addLabel("1", 7, 60);
        addLabel("2", 78, 5);
        addLabel("3", 200, 5);
        addLabel("4", 277, 60);
        addLabel("5", 200, 125);
        addLabel("6", 78, 125);
        addLabelKhoanCach("4", 45,36 );//1-2
        addLabelKhoanCach("3", 145,2 );//2-3
        addLabelKhoanCach("2", 245,36 );//3-4
        addLabelKhoanCach("1", 245,100 );//4-5
        addLabelKhoanCach("3", 145,125 );//5-6
        addLabelKhoanCach("2", 45,100 );//6-1
        addLabelKhoanCach("3", 145,60 );//2-5
        
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, label.getPreferredSize().width, label.getPreferredSize().height);

        Font labelFont = new Font("Arial", Font.BOLD, 11); 

        label.setFont(labelFont); 

        label.setForeground(Color.BLUE); 

        add(label);
    }
    private void addLabelKhoanCach(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, label.getPreferredSize().width, label.getPreferredSize().height);

        Font labelFont = new Font("Arial", Font.ITALIC, 11); 

        label.setFont(labelFont); 

        label.setForeground(Color.BLACK); 

        add(label);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int diameter = 10;
        Ellipse2D circle1 = new Ellipse2D.Double(10, 70, diameter, diameter);
        Ellipse2D circle2 = new Ellipse2D.Double(90, 10, diameter, diameter);
        Ellipse2D circle3 = new Ellipse2D.Double(190, 10, diameter, diameter);
        Ellipse2D circle4 = new Ellipse2D.Double(280, 70, diameter, diameter);
        Ellipse2D circle5 = new Ellipse2D.Double(190, 130, diameter, diameter);
        Ellipse2D circle6 = new Ellipse2D.Double(90, 130, diameter, diameter);

        g2d.setColor(Color.BLUE);
        g2d.fill(circle1);
        g2d.fill(circle2);
        g2d.fill(circle3);
        g2d.fill(circle4);
        g2d.fill(circle5);
        g2d.fill(circle6);

        g2d.setColor(Color.red);
        g2d.drawLine(17, 73, 97, 13); // 1-2
        g2d.drawLine(97, 13, 190, 13); // 2-3
        g2d.drawLine(190, 13, 280, 73); // 3-4
        g2d.drawLine(289, 73, 190, 133); // 4-5
        g2d.drawLine(190, 133, 90, 133); // 5-6
        g2d.drawLine(90, 133, 17, 73); // 6-1
        g2d.drawLine(97, 13, 190, 133); // 2-5
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Vẽ điểm tròn và nối chúng với JLabel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 400, 200);
            frame.add(new Map());
            frame.setVisible(true);
        });
    }
}
