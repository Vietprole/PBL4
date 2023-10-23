package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomLineDrawingApp {
    private JFrame frame;
    private CustomLinePanel linePanel1;

    public CustomLineDrawingApp() {
        frame = new JFrame("Custom Line Drawing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
     
        Map mainPanel = new Map(); // Tạo một Map panel

        // Tạo linePanel cho cột 1
        linePanel1 = new CustomLinePanel();

        // Thêm CustomLinePanel vào Map
        mainPanel.add(linePanel1);

        frame.add(mainPanel); // Thêm Map panel vào frame

        JPanel controlPanel = new JPanel();
        JButton drawLineButton1 = new JButton("Vẽ đường thẳng 1");
        controlPanel.add(drawLineButton1);
        JButton drawLineButton2 = new JButton("Vẽ đường thẳng 2");
        controlPanel.add(drawLineButton2);

        JLabel colorLabel = new JLabel("Màu sắc:");
        JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"Đen", "Đỏ", "Xanh dương"});
        controlPanel.add(colorLabel);
        controlPanel.add(colorComboBox);

        JLabel widthLabel = new JLabel("Độ đậm:");
        JComboBox<String> widthComboBox = new JComboBox<>(new String[]{"1.0", "2.0", "3.0"});
        controlPanel.add(widthLabel);
        controlPanel.add(widthComboBox);

        frame.add(controlPanel, BorderLayout.SOUTH);

        drawLineButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy màu sắc và độ đậm từ ComboBox
                
                // Gọi hàm vẽ đường thẳng và thêm vào danh sách trong linePanel1
                linePanel1.drawLine(17, 73, 97, 13, Color.blue, 5.0f);
                linePanel1.drawLine(60, 50, 250, 150, Color.red, 4.0f);
            }
        });

        drawLineButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linePanel1.drawLine(60, 50, 250, 250, Color.red, 4.0f);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomLineDrawingApp();
            }
        });
    }
}

class CustomLinePanel extends JPanel {
    private List<Line> lines = new ArrayList<>();

    public void drawLine(int x1, int y1, int x2, int y2, Color color, float width) {
        lines.add(new Line(x1, y1, x2, y2, color, width));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Line line : lines) {
            g2d.setStroke(new BasicStroke(line.lineWidth));
            g2d.setColor(line.lineColor);
            g2d.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }

    private class Line {
        int x1, y1, x2, y2;
        Color lineColor;
        float lineWidth;

        public Line(int x1,int y1, int x2, int y2, Color color, float width) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.lineColor = color;
            this.lineWidth = width;
        }
    }
}
