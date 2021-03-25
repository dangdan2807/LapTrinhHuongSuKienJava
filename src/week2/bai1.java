package week2;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;

public class bai1 extends JFrame implements ActionListener, ListSelectionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int fontSize = 16;
    private JLabel lblTitle;
    private JTextField tfIdNV;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JRadioButton radNu;
    private JTextField tfAge;
    private JTextField tfLuong;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField tfTimID;
    private JButton btnTimID;
    private JButton btnThem;
    private JButton btnXoaTrang;
    private JButton btnXoa;
    private JButton btnLuu;

    public bai1() {
        setTitle("Thông Tin Nhân Viên");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));

        // north panel
        JPanel pNorth = new JPanel();
        lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLUE);
        pNorth.add(lblTitle);

        // center panel
        JPanel pCenter = new JPanel();
        // row 1
        JPanel pRow1 = new JPanel();
        JLabel txtIdNV = new JLabel("Mã nhân viên: ");
        txtIdNV.setFont(new Font("Arial", Font.BOLD, fontSize));
        tfIdNV = new JTextField(45);
        tfIdNV.setFont(new Font("Arial", Font.BOLD, fontSize));

        pRow1.add(txtIdNV);
        pRow1.add(tfIdNV);

        // row 2
        JPanel pRow2 = new JPanel();
        JLabel txtFirstName = new JLabel("Họ: ");
        JLabel txtLastName = new JLabel("Tên nhân viên: ");
        tfFirstName = new JTextField(19);
        tfLastName = new JTextField(16);

        txtFirstName.setFont(new Font("Arial", Font.BOLD, fontSize));
        txtLastName.setFont(new Font("Arial", Font.BOLD, fontSize));
        tfFirstName.setFont(new Font("Arial", Font.BOLD, fontSize));
        tfLastName.setFont(new Font("Arial", Font.BOLD, fontSize));

        pRow2.add(txtFirstName);
        pRow2.add(Box.createHorizontalStrut(75));
        pRow2.add(tfFirstName);
        pRow2.add(Box.createHorizontalStrut(3));
        pRow2.add(txtLastName);
        pRow2.add(tfLastName);

        // row 3
        JPanel pRow3 = new JPanel();
        JLabel txtAge = new JLabel("Tuổi: ");
        JLabel txtGender = new JLabel("Phái: ");
        tfAge = new JTextField(35);
        radNu = new JRadioButton("Nữ");

        txtAge.setFont(new Font("Arial", Font.BOLD, fontSize));
        txtGender.setFont(new Font("Arial", Font.BOLD, fontSize));
        tfAge.setFont(new Font("Arial", Font.BOLD, fontSize));
        radNu.setFont(new Font("Arial", Font.BOLD, fontSize));

        pRow3.add(txtAge);
        pRow3.add(Box.createHorizontalStrut(65));
        pRow3.add(tfAge);
        pRow3.add(Box.createHorizontalStrut(15));
        pRow3.add(txtGender);
        pRow3.add(Box.createHorizontalStrut(10));
        pRow3.add(radNu);
        pRow3.add(Box.createHorizontalStrut(1));

        // row 4
        JPanel pRow4 = new JPanel();
        JLabel txtLuong = new JLabel("Lương: ");
        tfLuong = new JTextField(45);

        txtLuong.setFont(new Font("Arial", Font.BOLD, fontSize));
        tfLuong.setFont(new Font("Arial", Font.BOLD, fontSize));

        pRow4.add(txtLuong);
        pRow4.add(Box.createHorizontalStrut(44));
        pRow4.add(tfLuong);

        // row table
        JPanel pTable = new JPanel(new BorderLayout());
        String[] columnNames = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền Lương" };
        String[][] data = {
            {"1", "", "", "", "", ""},
            {"2", "", "", "", "", ""},
            {"3", "", "", "", "", ""},
            {"4", "", "", "", "", ""},
            {"5", "", "", "", "", ""},
            {"6", "", "", "", "", ""},
            {"7", "", "", "", "", ""},
            {"8", "", "", "", "", ""},
            {"9", "", "", "", "", ""},
            {"10", "", "", "", "", ""},
            {"11", "", "", "", "", ""},
            {"12", "", "", "", "", ""},
            {"13", "", "", "", "", ""},
            {"14", "", "", "", "", ""},
            {"15", "", "", "", "", ""}
        };
        // tableModel = new DefaultTableModel(data, columnNames);
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, fontSize));
        table.setRowHeight(25);

        for (int i = 0; i < columnNames.length; i++)
            table.getColumnModel().getColumn(i).setMinWidth(125);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, fontSize));

        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(15, 250));

        // thêm vào table panel
        pTable.add(table.getTableHeader(), BorderLayout.NORTH);
        pTable.add(table, BorderLayout.CENTER);
        pTable.add(scrollPane, BorderLayout.EAST);

        // thêm vào center panel
        pCenter.add(pRow1);
        pCenter.add(pRow2);
        pCenter.add(pRow3);
        pCenter.add(pRow4);
        pCenter.add(pTable);

        // south panel
        JPanel pSouth = new JPanel();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        // south left panel
        JPanel pSouthLeft = new JPanel();
        pSouthLeft.setBorder(loweredBevel);

        JLabel txtTimID = new JLabel("Nhập mã số cần tìm: ");
        txtTimID.setFont(new Font("Arial", Font.BOLD, fontSize));
        tfTimID = new JTextField(8);
        tfTimID.setFont(new Font("Arial", Font.BOLD, fontSize));
        // btn
        btnTimID = new JButton("Tìm");
        btnTimID.setFont(new Font("Arial", Font.BOLD, fontSize));
        // thêm vào South Left panel
        pSouthLeft.add(txtTimID);
        pSouthLeft.add(tfTimID);
        pSouthLeft.add(btnTimID);

        // south right panel
        JPanel pSouthRight = new JPanel();
        pSouthRight.setBorder(loweredBevel);
        // btn
        btnThem = new JButton("Thêm");
        btnXoaTrang = new JButton("Xoá Trắng");
        btnXoa = new JButton("Xoá");
        btnLuu = new JButton("Lưu");

        btnThem.setFont(new Font("Arial", Font.BOLD, fontSize));
        btnXoaTrang.setFont(new Font("Arial", Font.BOLD, fontSize));
        btnXoa.setFont(new Font("Arial", Font.BOLD, fontSize));
        btnLuu.setFont(new Font("Arial", Font.BOLD, fontSize));

        // thêm vào South Right panel
        pSouthRight.add(Box.createHorizontalStrut(20));
        pSouthRight.add(btnThem);
        pSouthRight.add(btnXoaTrang);
        pSouthRight.add(btnXoa);
        pSouthRight.add(btnLuu);
        pSouthRight.add(Box.createHorizontalStrut(20));

        // thêm vào South panel
        pSouth.add(pSouthLeft);
        pSouth.add(pSouthRight);

        // thêm vào giao diện
        add(pNorth, BorderLayout.NORTH);
        add(pCenter, BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);

        // Lắng nghe sự kiện
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
