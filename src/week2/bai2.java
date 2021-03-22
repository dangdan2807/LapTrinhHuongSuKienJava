package week2;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class bai2 extends JFrame implements ActionListener, ListSelectionListener {

    /**
     *
     */
    private static final long serialVersionUID = 4716763103987467161L;
    private JButton btnSoChan;
    private JButton btnSoLe;
    private JButton btnSoNguyenTo;
    private JButton btnBoTo;
    private JButton btnXoa;
    private JButton btnSum;
    private JButton btnExit;
    private JButton btnAdd;
    private JTextField txtInput;
    private JCheckBox chkSoAm;
    private JList listNumber;
    private DefaultListModel listModelNumber;

    public bai2() {
        setTitle("Thao tác trên JList");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 430);
        setLocationRelativeTo(null);
        setResizable(false);

        //
        JLabel lblTitle = new JLabel("Thao tác trên JList - CheckBox");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
        lblTitle.setForeground(Color.BLUE);
        // North panel
        JPanel pNorth = new JPanel();
        pNorth.add(Box.createRigidArea(new Dimension(0, 50)));
        pNorth.add(lblTitle);

        // West panel
        JPanel pWest = new JPanel();
        pWest.setLayout(new GridLayout(7, 1, 0, 5));
        Border bdTitle = BorderFactory.createLineBorder(Color.RED, 2);
        pWest.setBorder(BorderFactory.createTitledBorder(bdTitle, "Chọn tác vụ", TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14)));
        // btn
        btnSoChan = new JButton("Tô đen số chẳn");  
        btnSoLe = new JButton("Tô đen số lẻ");
        btnSoNguyenTo = new JButton("Tô đen số nguyên tố");
        btnBoTo = new JButton("Bỏ tô đen");
        btnXoa = new JButton("Xoá các giá trị đang tô đen");
        btnSum = new JButton("Tổng giá trị trong List");
        // set font
        btnSoChan.setFont(new Font("Arial", Font.BOLD, 14));
        btnSoLe.setFont(new Font("Arial", Font.BOLD, 14));
        btnSoNguyenTo.setFont(new Font("Arial", Font.BOLD, 14));
        btnBoTo.setFont(new Font("Arial", Font.BOLD, 14));
        btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
        btnSum.setFont(new Font("Arial", Font.BOLD, 14));
        // thêm btn vào west panel
        pWest.add(btnSoChan);
        pWest.add(btnSoLe);
        pWest.add(btnSoNguyenTo);
        pWest.add(btnBoTo);
        pWest.add(btnXoa);
        pWest.add(btnSum);

        // center panel
        JPanel pCenter = new JPanel();
        pCenter.setBorder(BorderFactory.createTitledBorder(bdTitle, "Nhập thông tin",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14)));
        // btn center panel
        btnAdd = new JButton("Nhập");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
        txtInput = new JTextField(8);
        txtInput.setFont(new Font("Arial", Font.BOLD, 14));
        chkSoAm = new JCheckBox("Cho nhập số âm");
        chkSoAm.setFont(new Font("Arial", Font.BOLD, 14));

        // panel con ở phía trên
        JPanel pChildNorth = new JPanel();
        pChildNorth.add(btnAdd);
        pChildNorth.add(txtInput);
        pChildNorth.add(chkSoAm);

        // list
        listModelNumber = new DefaultListModel();
        listNumber = new JList(listModelNumber);
        listNumber.setVisibleRowCount(10);

        // thêm vào center panel
        pCenter.add(pChildNorth, BorderLayout.SOUTH);
        pCenter.add(listNumber, BorderLayout.CENTER);
        pCenter.add(new JScrollPane(listNumber), BorderLayout.EAST);

        // South panel
        JPanel pSouth = new JPanel();
        pSouth.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        pSouth.setBackground(Color.decode("#C0C0C0"));
        pSouth.add(Box.createRigidArea(new Dimension(0, 50)));
        btnExit = new JButton("Đóng chương trình");
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));

        pSouth.add(btnExit);

        // Thêm vào giao diện
        add(pNorth, BorderLayout.NORTH);
        add(pWest, BorderLayout.WEST);
        add(pCenter, BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);

        // lắng nghe sự kiện
        btnAdd.addActionListener(this);
        btnExit.addActionListener(this);
    }

    public static void main(String[] args) {
        new bai2().setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnExit)) {
            System.exit(0);
        }
        else if (o == btnAdd) {
            String name = txtInput.getText().trim();
            if (name.equalsIgnoreCase(""))
                JOptionPane.showMessageDialog(this, "Please input name!");
            else {
                listModelNumber.addElement(name);
                txtInput.setText("");
            }
            focusTextField(txtInput);
        }

    }

    public void focusTextField(JTextField text) {
        text.selectAll();
        text.requestFocus();
        return;
    }
}
