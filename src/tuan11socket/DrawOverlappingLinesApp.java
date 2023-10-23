package tuan11socket;import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DrawOverlappingLinesApp {
    private JFrame frame;
    private JPanel drawingPanel;
    private JButton drawButton1;
    private JButton drawButton2;
    private List<Line> lines = new ArrayList<>();

    public DrawOverlappingLinesApp() {
        frame = new JFrame("Vẽ đường thẳng chồng lên nhau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Line line : lines) {
                    g.drawLine(line.x1, line.y1, line.x2, line.y2);
                }
            }
        };

        drawButton1 = new JButton("Vẽ đường thứ 1");
        drawButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cài đặt tọa độ điểm đầu và điểm cuối của đường thẳng thứ nhất
                Line line = new Line(50, 50, 300, 300);
                lines.add(line);
                drawingPanel.repaint(); // Vẽ lại tất cả đường thẳng trên panel
            }
        });

        drawButton2 = new JButton("Vẽ đường thứ 2");
        drawButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cài đặt tọa độ điểm đầu và điểm cuối của đường thẳng thứ hai
                Line line = new Line(50, 80, 300, 300);
                lines.add(line);
                drawingPanel.repaint();
                
                Line line1 = new Line(60, 80, 300, 300);
                lines.add(line1);
                drawingPanel.repaint();// Vẽ lại tất cả đường thẳng trên panel
            }
        });

        frame.add(drawingPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawButton1);
        buttonPanel.add(drawButton2);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrawOverlappingLinesApp();
            }
        });
    }

    private class Line {
        int x1, y1, x2, y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
