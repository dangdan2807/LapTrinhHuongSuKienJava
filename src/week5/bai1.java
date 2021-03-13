package week5;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class bai1 extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel ltlText1;
    private JLabel ltlText2;
    private JLabel ltlText3;
    private JLabel ltlText4;
    private JTextField tfInput1;
    private JTextField tfInput2;
    private JTextField tfInput3;
    private JTextField tfInput4;
    private JButton btnGiai;
    private JButton btnDelete;
    private JButton btnExit;

    public bai1() {
        setTitle("Giải phương trình bậc 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 470);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel pnMain = new JLabel("");
        pnMain.setLayout(new BorderLayout());

        // North panel
        JPanel pnNorth = new JPanel();
        pnNorth.add(Box.createRigidArea(new Dimension(0, 50)));
        pnNorth.setBackground(Color.decode("#00FFFF"));
        JLabel ltlTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
        ltlTitle.setFont(new Font("Arial", Font.BOLD, 20));
        pnNorth.add(ltlTitle);
        pnMain.add(pnNorth, BorderLayout.NORTH);
        pnMain.setBackground(Color.decode("#00FFFF"));

        // center panel
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.add(Box.createRigidArea(new Dimension(0, 20)));
        pnMain.add(pnCenter, BorderLayout.CENTER);

        // Dòng 1
        JPanel pnRow1 = new JPanel();
        pnRow1.add(Box.createRigidArea(new Dimension(0, 50)));
        ltlText1 = new JLabel("Nhập a: ");
        ltlText1.setFont(new Font("Arial", Font.BOLD, 14));
        // tạo khoản các giứ label và textField
        JPanel pnSpace1 = new JPanel();
        pnSpace1.add(ltlText1);
        pnSpace1.add(Box.createHorizontalStrut(60));

        tfInput1 = new JTextField();
        tfInput1.setPreferredSize(new Dimension(300, 30));
        tfInput1.setFont(new Font("Arial", Font.BOLD, 14));
        pnRow1.add(pnSpace1);
        pnRow1.add(tfInput1);
        pnCenter.add(pnRow1);

        // dòng 2
        JPanel pnRow2 = new JPanel();
        pnRow2.add(Box.createRigidArea(new Dimension(0, 50)));
        ltlText2 = new JLabel("Nhập b: ");
        ltlText2.setFont(new Font("Arial", Font.BOLD, 14));
        // tạo khoản các giứ label và textField
        JPanel pnSpace2 = new JPanel();
        pnSpace2.add(ltlText2);
        pnSpace2.add(Box.createHorizontalStrut(60));

        tfInput2 = new JTextField();
        tfInput2.setPreferredSize(new Dimension(300, 30));
        tfInput2.setFont(new Font("Arial", Font.BOLD, 14));
        pnRow2.add(pnSpace2);
        pnRow2.add(tfInput2);
        pnCenter.add(pnRow2);

        // dòng 3
        JPanel pnRow3 = new JPanel();
        pnRow3.add(Box.createRigidArea(new Dimension(0, 50)));
        ltlText3 = new JLabel("Nhập c: ");
        ltlText3.setFont(new Font("Arial", Font.BOLD, 14));
        // tạo khoản các giứ label và textField
        JPanel pnSpace3 = new JPanel();
        pnSpace3.add(ltlText3);
        pnSpace3.add(Box.createHorizontalStrut(60));

        tfInput3 = new JTextField();
        tfInput3.setPreferredSize(new Dimension(300, 30));
        tfInput3.setFont(new Font("Arial", Font.BOLD, 14));
        pnRow3.add(pnSpace3);
        pnRow3.add(tfInput3);
        pnCenter.add(pnRow3);

        // dòng 4
        JPanel pnRow4 = new JPanel();
        pnRow4.add(Box.createRigidArea(new Dimension(0, 50)));
        ltlText4 = new JLabel("Kết quả: ");
        ltlText4.setFont(new Font("Arial", Font.BOLD, 14));
        // tạo khoản các giứ label và textField
        JPanel pnSpace4 = new JPanel();
        pnSpace4.add(ltlText4);
        pnSpace4.add(Box.createHorizontalStrut(60));

        tfInput4 = new JTextField();
        tfInput4.setPreferredSize(new Dimension(300, 30));
        tfInput4.setFont(new Font("Arial", Font.BOLD, 14));
        tfInput4.setEditable(false);
        pnRow4.add(pnSpace4);
        pnRow4.add(tfInput4);
        pnCenter.add(pnRow4);

        // south panel
        JPanel pnSouth = new JPanel();
        Border titleBorder = BorderFactory.createTitledBorder(null, "Chọn tác vụ", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14));
        pnSouth.setBorder(titleBorder);
        pnSouth.add(Box.createRigidArea(new Dimension(0, 50)));
        pnMain.add(pnSouth, BorderLayout.SOUTH);

        // btn
        btnGiai = new JButton("Giải");
        btnGiai.setFont(new Font("Arial", Font.BOLD, 14));
        btnDelete = new JButton("Xoá rỗng");
        btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit = new JButton("Thoát");
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        // thêm nút vào south panel
        pnSouth.add(btnGiai);
        pnSouth.add(btnDelete);
        pnSouth.add(btnExit);

        this.add(pnMain);
        // lăng nghe sự kiện
        btnExit.addActionListener(this);
        btnDelete.addActionListener(this);
        btnGiai.addActionListener(this);
    }

    public static void main(String[] args) {
        new bai1().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        double a = 0, b = 0, c = 0, delta = 0, x1, x2;
        if (obj.equals(btnExit))
            System.exit(0);
        else if (obj.equals(btnGiai)) {
                a = Double.parseDouble(tfInput1.getText());
                b = Double.parseDouble(tfInput2.getText());
                c = Double.parseDouble(tfInput3.getText());
                if (a == 0) {
                    // a== 0 phuong trinh tro thanh phuong trinh bac mot bx + c = 0
                    if (b == 0) {
                        if (c == 0)
                            tfInput4.setText("Phương trình vô số nghiệm");
                        else
                            tfInput4.setText("Phương trình vô nghiệm");
                    } else {
                        tfInput4.setText("Phương trình có nghiệm duy nhất: x = " + -1 * c / b);
                    }
                } else {
                    delta = b * b - 4 * a * c;
                    if (delta > 0) {
                        x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        tfInput4.setText("Phương trình 2 có nghiệm: x1 = " + x1 + ", x2 = " + x2);
                    } else if (delta == 0) {
                        tfInput4.setText("Phương trình 2 có nghiệm: x1 = x2 = " + -1 * b / 2 * a);
                    } else {
                        tfInput4.setText("Phương trình vô nghiệm");
                    }
                }
        } else if (obj.equals(btnDelete)) {
            tfInput1.setText("");
            tfInput2.setText("");
            tfInput3.setText("");
            tfInput4.setText("");
        }
    }

}
