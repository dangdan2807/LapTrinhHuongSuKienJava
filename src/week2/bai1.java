package week2;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

public class bai1 extends JFrame implements ActionListener, ListSelectionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel lbTitle;
    private JTextField tfIdNV, tfFirstName, tfLastName, tfAge, tfLuong, tfTimID;
    private JButton btnTimID, btnThem, btnXoaTrang, btnXoa, btnLuu;
    private JRadioButton radNu;
    private DefaultTableModel model;
    private JTable table;

    private int fontSize = 14;
    private Font font = new Font("Arial", Font.BOLD, fontSize);
    String[] cols = { "Mã Sách", "Tên Sách", "Tác Giả", "Số Lượng", "NXB" };

    public bai1() {
        setTitle("Thông Tin Nhân Viên");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        // north panel
        JPanel pNorth = new JPanel();
        lbTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lbTitle.setForeground(Color.BLUE);
        pNorth.add(lbTitle);

        // row 1: mã nhân viên
        JPanel pRow1 = new JPanel();
        JLabel txtIdNV = new JLabel("Mã nhân viên: ");
        tfIdNV = new JTextField(45);

        txtIdNV.setFont(font);
        tfIdNV.setFont(font);

        pRow1.add(txtIdNV);
        pRow1.add(tfIdNV);

        // row 2: thông tin nhân viên
        JPanel pRow2 = new JPanel();
        JLabel txtFirstName = new JLabel("Họ: ");
        JLabel txtLastName = new JLabel("Tên nhân viên: ");
        tfFirstName = new JTextField(19);
        tfLastName = new JTextField(15);

        txtFirstName.setFont(font);
        txtLastName.setFont(font);
        tfFirstName.setFont(font);
        tfLastName.setFont(font);

        pRow2.add(txtFirstName);
        pRow2.add(Box.createHorizontalStrut(68));
        pRow2.add(tfFirstName);
        pRow2.add(Box.createHorizontalStrut(3));
        pRow2.add(txtLastName);
        pRow2.add(tfLastName);

        // row 3: tuồi, giới tính
        JPanel pRow3 = new JPanel();
        JLabel txtAge = new JLabel("Tuổi: ");
        JLabel txtGender = new JLabel("Phái: ");
        tfAge = new JTextField(35);
        radNu = new JRadioButton("Nữ");

        txtAge.setFont(font);
        txtGender.setFont(font);
        tfAge.setFont(font);
        radNu.setFont(font);

        pRow3.add(txtAge);
        pRow3.add(Box.createHorizontalStrut(61));
        pRow3.add(tfAge);
        pRow3.add(txtGender);
        pRow3.add(Box.createHorizontalStrut(24));
        pRow3.add(radNu);

        // row 4: lương
        JPanel pRow4 = new JPanel();
        JLabel txtLuong = new JLabel("Lương: ");
        tfLuong = new JTextField(45);

        txtLuong.setFont(font);
        tfLuong.setFont(font);

        pRow4.add(txtLuong);
        pRow4.add(Box.createHorizontalStrut(44));
        pRow4.add(tfLuong);

        // table
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        table.setRowHeight(25);
        JScrollPane scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // south panel
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        JPanel pSouth = new JPanel();
        JPanel pSouthLeft = new JPanel();
        JPanel pSouthRight = new JPanel();

        pSouthRight.setBorder(loweredBevel);
        pSouthLeft.setBorder(loweredBevel);

        JLabel txtTimID = new JLabel("Nhập mã số cần tìm: ");
        tfTimID = new JTextField(8);
        btnTimID = new JButton("Tìm");
        tfTimID.setFont(font);
        txtTimID.setFont(font);
        btnTimID.setFont(font);
        btnThem = new JButton("Thêm");
        btnXoaTrang = new JButton("Xoá Trắng");
        btnXoa = new JButton("Xoá");
        btnLuu = new JButton("Lưu");

        btnThem.setFont(font);
        btnXoaTrang.setFont(font);
        btnXoa.setFont(font);
        btnLuu.setFont(font);

        pSouthLeft.add(Box.createHorizontalStrut(2));
        pSouthLeft.add(txtTimID);
        pSouthLeft.add(tfTimID);
        pSouthLeft.add(btnTimID);
        pSouthLeft.add(Box.createHorizontalStrut(2));

        pSouthRight.add(Box.createHorizontalStrut(2));
        pSouthRight.add(btnThem);
        pSouthRight.add(btnXoaTrang);
        pSouthRight.add(btnXoa);
        pSouthRight.add(btnLuu);
        pSouthRight.add(Box.createHorizontalStrut(2));

        JSplitPane spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pSouthLeft, pSouthRight);

        pSouth.add(spl);
        //
        Box main = Box.createVerticalBox();
        main.add(pNorth);
        main.add(pRow1);
        main.add(pRow2);
        main.add(pRow3);
        main.add(pRow4);
        main.add(scr);
        // main.add(spl);
        main.add(pSouth);

        add(main);
    }

    public static void main(String[] args) {
        new bai1().setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
