package test1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Index extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JPanel panel_1;
    private Map panel_2;
    private JButton btnNewButton_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Index frame = new Index();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Index() {
        setTitle("Shortest Path Routing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 655, 460);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel_2 = new Map();

        JLabel lbKhoangCach = new JLabel("Khoảng cách: ");
        lbKhoangCach.setBounds(315, 214, 183, 19);
        textField_2 = new JTextField();
        textField_2.setBounds(395, 214, 183, 19);
        contentPane.add(textField_2);
        contentPane.add(lbKhoangCach);
        textField_2.setColumns(10);

        JLabel lbDuongDi = new JLabel("Đường đi: ");
        lbDuongDi.setBounds(315, 247, 183, 19);
        textField_3 = new JTextField();
        textField_3.setBounds(395, 247, 183, 19);
        contentPane.add(textField_3);
        contentPane.add(lbDuongDi);
        textField_3.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Chọn trạm trên mạng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(16, 22, 235, 182);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(22, 58, 48, 45);
        panel.add(textField);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(143, 58, 48, 45);
        panel.add(textField_1);
        textField_1.setHorizontalAlignment(JTextField.CENTER);
        textField_1.setColumns(10);

        JLabel lblNewLabel = new JLabel("Nguồn");
        lblNewLabel.setBounds(25, 31, 45, 13);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Đích");
        lblNewLabel_1.setBounds(143, 35, 45, 13);
        panel.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Chọn");
        btnNewButton.setBounds(62, 133, 85, 21);
        panel.add(btnNewButton);

        panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "Điều khiển", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(337, 276, 119, 82);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        btnNewButton_1 = new JButton("Kết thúc");
       
        btnNewButton_1.setBounds(10, 22, 86, 38);
        panel_1.add(btnNewButton_1);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(27, 270, 206, 109);
        contentPane.add(textArea);

        JLabel lblNewLabel_2 = new JLabel("Bảng chỉ đường");
        lblNewLabel_2.setBounds(70, 238, 139, 24);
        contentPane.add(lblNewLabel_2);

        panel_2.setBounds(318, 22, 299, 173);
        contentPane.add(panel_2);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int x = Integer.parseInt(textField.getText());
                    int y = Integer.parseInt(textField_1.getText());
                    Dijkstra dt = new Dijkstra();

                    String pathResult = dt.mydijkstra(x, y);
                    String[] pathLines = pathResult.split("\n");

                    if (pathLines.length > 0) {
                        textField_2.setText(pathLines[0]); // Gán dòng 1 cho textField_2
                    }
                    if (pathLines.length > 1) {
                        textField_3.setText(pathLines[1]); // Gán dòng 2 cho textField_3

                        String[] in = pathLines[1].split(" ");
                        int[] intArray = new int[in.length];

                        for (int i = 0; i < in.length; i++) {
                            intArray[i] = Integer.parseInt(in[i]);
                        }

                        // Kiểm tra và thực hiện tác vụ nếu có cặp số gần nhau
                        for (int i = 0; i < intArray.length - 1; i++) {
                            int soHienTai = intArray[i];
                            int soKeTiep = intArray[i + 1];

                            if ((soHienTai == 1 && soKeTiep == 2) || (soHienTai == 2 && soKeTiep == 1)) {
                                panel_2.addLine(17, 73, 97, 13, Color.red, 4.0f);//1-2
                                System.out.println("Thực hiện tác vụ khi 1 gần 2 ");
                            } else if ((soHienTai == 1 && soKeTiep == 6) || (soHienTai == 6 && soKeTiep == 1)) {
                                panel_2.addLine(90, 133, 17, 73, Color.red, 4.0f);//6-1
                                System.out.println("Thực hiện tác vụ khi 1 gần 6 ");
                            } else if ((soHienTai == 2 && soKeTiep == 3) || (soHienTai == 3 && soKeTiep == 2)) {
                                panel_2.addLine(97, 13, 190, 13, Color.red, 4.0f);//2-3
                                System.out.println("Thực hiện tác vụ khi 2 gần 3 ");
                            } else if ((soHienTai == 2 && soKeTiep == 5) || (soHienTai == 5 && soKeTiep == 2)) {
                                panel_2.addLine(97, 13, 190, 133, Color.red, 4.0f);//5-2
                                System.out.println("Thực hiện tác vụ khi 2 gần 5 ");
                            } else if ((soHienTai == 3 && soKeTiep == 4) || (soHienTai == 4 && soKeTiep == 3)) {
                                panel_2.addLine(190, 13, 280, 73, Color.red, 4.0f);//3-4
                                System.out.println("Thực hiện tác vụ khi 3 gần 4 ");
                            } else if ((soHienTai == 4 && soKeTiep == 5) || (soHienTai == 5 && soKeTiep == 4)) {
                                panel_2.addLine(289, 73, 190, 133, Color.red, 4.0f);//4-5
                                System.out.println("Thực hiện tác vụ khi 4 gần 5 ");
                            } else if ((soHienTai == 5 && soKeTiep == 6) || (soHienTai == 6 && soKeTiep == 5)) {
                                panel_2.addLine(190, 133, 90, 133, Color.red, 4.0f);//5-6
                                System.out.println("Thực hiện tác vụ khi 5 gần 6 ");
                            }
                        }
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Không phải số nguyên hợp lệ.");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_2.resetMap();
            }
        });
    }
    
}
