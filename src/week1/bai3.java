package week1;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class bai3 extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton btnGiai;
    private JButton btnDelete;
    private JButton btnExit;
    private JButton btnBlue;
    private JButton btnRed;
    private JButton btnYellow;
    private JRadioButton radCong;
    private JRadioButton radTru;
    private JRadioButton radNhan;
    private JRadioButton radChia;
    private JTextField input1;
    private JTextField input2;
    private JTextField input3;
    private JLabel ltlTitle;

    public bai3() {
        setTitle("Primes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        // south panel
        JPanel pnNorth = new JPanel();
        pnNorth.add(Box.createRigidArea(new Dimension(0, 50)));
        ltlTitle = new JLabel("Cộng Trừ Nhân Chia");
        ltlTitle.setFont(new Font("Arial", Font.BOLD, 24));
        ltlTitle.setForeground(Color.BLUE);
        pnNorth.add(ltlTitle);
        pnMain.add(pnNorth, BorderLayout.NORTH);

        // east panel
        JPanel pnWest = new JPanel();
        pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
        pnWest.setBackground(Color.decode("#C0C0C0"));
        pnWest.setPreferredSize(new Dimension(120, 0));
        pnWest.add(Box.createRigidArea(new Dimension(15, 0)));
        pnMain.add(pnWest, BorderLayout.WEST);
        // border
        Border lineBorder = BorderFactory.createLineBorder(Color.decode("#00ffff"), 2);
        Border borderPnEast = BorderFactory.createTitledBorder(lineBorder, "Chọn tác vụ",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14));
        pnWest.setBorder(borderPnEast);

        // btn
        btnGiai = new JButton("Giải");
        btnGiai.add(Box.createRigidArea(new Dimension(60, 25)));
        btnGiai.setFont(new Font("Arial", Font.BOLD, 14));
        btnDelete = new JButton("Xoá");
        btnDelete.add(Box.createRigidArea(new Dimension(60, 25)));
        btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit = new JButton("Thoát");
        btnExit.add(Box.createRigidArea(new Dimension(60, 25)));
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));

        pnWest.add(btnGiai);
        pnWest.add(Box.createRigidArea(new Dimension(0, 10)));
        pnWest.add(btnDelete);
        pnWest.add(Box.createRigidArea(new Dimension(0, 10)));
        pnWest.add(btnExit);

        // center panel
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnMain.add(pnCenter, BorderLayout.CENTER);
        // border
        Border borderPnCenter = BorderFactory.createTitledBorder(lineBorder, "Tính Toán",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14));
        pnCenter.setBorder(borderPnCenter);

        JLabel text1 = new JLabel("Nhập a: ");
        text1.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel text2 = new JLabel("Nhập b: ");
        text2.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel text3 = new JLabel("Kết quả: ");
        text3.setFont(new Font("Arial", Font.BOLD, 14));

        input1 = new JTextField();
        input1.setPreferredSize(new Dimension(300, 30));
        input1.setFont(new Font("Arial", Font.BOLD, 14));

        input2 = new JTextField();
        input2.setPreferredSize(new Dimension(300, 30));
        input2.setFont(new Font("Arial", Font.BOLD, 14));

        input3 = new JTextField();
        input3.setPreferredSize(new Dimension(300, 30));
        input3.setFont(new Font("Arial", Font.BOLD, 14));
        // disable text field
        input3.setEditable(false);

        // Dòng 1
        JPanel pnRow1 = new JPanel();
        pnRow1.add(Box.createRigidArea(new Dimension(480, 10)));
        pnRow1.add(text1);
        pnRow1.add(input1);

        // Dòng 2
        JPanel pnRow2 = new JPanel();
        pnRow2.add(Box.createRigidArea(new Dimension(480, 10)));
        pnRow2.add(text2);
        pnRow2.add(input2);

        // Dòng 3
        JPanel pnRow3 = new JPanel();
        pnRow3.setLayout(new BoxLayout(pnRow3, BoxLayout.X_AXIS));
        pnRow3.add(Box.createHorizontalStrut(60));
        Border borderPnRow3 = BorderFactory.createTitledBorder(lineBorder, "Phép Toán",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14));

        // panel con để tạo khoảng cách đẩy phần radio vào
        JPanel pnChild = new JPanel();
        pnChild.setLayout(new BoxLayout(pnChild, BoxLayout.Y_AXIS));
        pnChild.setBorder(borderPnRow3);

        pnRow3.add(pnChild);

        // Tạo radio
        radCong = new JRadioButton("Cộng", true);
        radCong.setFont(new Font("Arial", Font.BOLD, 14));
        radTru = new JRadioButton("Trừ");
        radTru.setFont(new Font("Arial", Font.BOLD, 14));
        radNhan = new JRadioButton("Nhân");
        radNhan.setFont(new Font("Arial", Font.BOLD, 14));
        radChia = new JRadioButton("Chia");
        radChia.setFont(new Font("Arial", Font.BOLD, 14));
        // thêm radio vào nhóm để tránh bị chọn nhiều cái 1 lúc
        ButtonGroup btnGr = new ButtonGroup();
        btnGr.add(radCong);
        btnGr.add(radTru);
        btnGr.add(radNhan);
        btnGr.add(radChia);

        // dòng chứa 2 radio cộng, trừ
        JPanel pnChild1 = new JPanel();
        pnChild1.setLayout(new BoxLayout(pnChild1, BoxLayout.X_AXIS));
        pnChild1.add(radCong);
        pnChild1.add(Box.createHorizontalStrut(88));
        pnChild1.add(radTru);
        pnChild1.add(Box.createHorizontalStrut(88));
        
        // dòng chứa 2 radio nhân, chia
        JPanel pnChild2 = new JPanel();
        pnChild2.setLayout(new BoxLayout(pnChild2, BoxLayout.X_AXIS));
        pnChild2.add(radNhan);
        pnChild2.add(Box.createHorizontalStrut(88));
        pnChild2.add(radChia);
        pnChild2.add(Box.createHorizontalStrut(88));

        pnChild.add(pnChild1);
        pnChild.add(pnChild2);

        // Dòng 4
        JPanel pnRow4 = new JPanel();
        pnRow4.add(Box.createRigidArea(new Dimension(480, 10)));
        pnRow4.add(text3);
        pnRow4.add(input3);

        pnCenter.add(pnRow1);
        pnCenter.add(pnRow2);
        pnCenter.add(pnRow3);
        pnCenter.add(pnRow4);

        // South panel
        JPanel pnSouth = new JPanel();
        pnSouth.setBackground(Color.decode("#ffafaf"));
        pnSouth.setPreferredSize(new Dimension(600, 70));
        pnMain.add(pnSouth, BorderLayout.SOUTH);
        // btn
        btnBlue = new JButton("");
        btnBlue.setBackground(Color.decode("#3f48cc"));
        btnBlue.add(Box.createRigidArea(new Dimension(5, 25)));

        btnRed = new JButton("");
        btnRed.setBackground(Color.RED);
        btnRed.add(Box.createRigidArea(new Dimension(5, 25)));

        btnYellow = new JButton("");
        btnYellow.setBackground(Color.YELLOW);
        btnYellow.add(Box.createRigidArea(new Dimension(5, 25)));

        pnSouth.add(btnBlue);
        pnSouth.add(Box.createRigidArea(new Dimension(10, 0)));
        pnSouth.add(btnRed);
        pnSouth.add(Box.createRigidArea(new Dimension(10, 0)));
        pnSouth.add(btnYellow);

        // Thêm vào giao diện
        this.add(pnMain);

        // lắng nghe sự kiện
        btnExit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnGiai.addActionListener(this);
        btnRed.addActionListener(this);
        btnBlue.addActionListener(this);
        btnYellow.addActionListener(this);
    }

    public static void main(String[] args) {
        new bai3().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        double a = 0, b = 0, result = 0;
        if (obj.equals(btnExit))
            System.exit(0);
        else if (obj.equals(btnBlue))
            ltlTitle.setForeground(Color.BLUE);
        else if (obj.equals(btnRed))
            ltlTitle.setForeground(Color.RED);
        else if (obj.equals(btnYellow))
            ltlTitle.setForeground(Color.YELLOW);
        else if (obj.equals(btnDelete)) {
            input1.setText("");
            input2.setText("");
            input3.setText("");
        } else if (obj.equals(btnGiai)) {
            // Kiểm tra đầu vào có rỗng
            if (input1.getText().equalsIgnoreCase("") || input2.getText().equalsIgnoreCase(""))
                JOptionPane.showConfirmDialog(null, "Thiếu tham số đầu vào", "Thông báo", JOptionPane.ERROR_MESSAGE);
            else {
                a = Double.parseDouble(input1.getText());
                b = Double.parseDouble(input2.getText());
                if (radCong.isSelected())
                    result = a + b;
                else if (radTru.isSelected())
                    result = a - b;
                else if (radNhan.isSelected())
                    result = a * b;
                else if (radChia.isSelected())
                    result = a / b;
                input3.setText(String.valueOf(result));
            }
        }

    }
}
