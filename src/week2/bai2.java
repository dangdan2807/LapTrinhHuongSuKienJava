package week2;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

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
    private JButton btnRandom;
    private JTextField txtInput;
    private JCheckBox chkSoAm;
    private JList<Integer> list;
    private DefaultListModel<Integer> listModel;

    public bai2() {
        setTitle("Thao tác trên JList");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 460);
        setLocationRelativeTo(null);
        setResizable(true);

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
        pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.Y_AXIS));
        pCenter.setBorder(BorderFactory.createTitledBorder(bdTitle, "Nhập thông tin",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 14)));
        // btn center panel
        btnAdd = new JButton("Nhập");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));
        txtInput = new JTextField(8);
        txtInput.setFont(new Font("Arial", Font.BOLD, 14));
        chkSoAm = new JCheckBox("Cho nhập số âm");
        chkSoAm.setFont(new Font("Arial", Font.BOLD, 14));
        btnRandom = new JButton("Tạo số ngẫu nhiên");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 14));

        // panel con ở phía trên
        JPanel pChildNorth = new JPanel();
        pChildNorth.add(btnAdd);
        pChildNorth.add(txtInput);
        pChildNorth.add(chkSoAm);

        // list
        listModel = new DefaultListModel<Integer>();
        list = new JList<Integer>(listModel);
        list.setVisibleRowCount(10);
        list.setFixedCellWidth(300);

        // panel con ở phía dưới
        JPanel pChildSouth = new JPanel();
        pChildSouth.add(btnRandom);

        // thêm vào center panel
        pCenter.add(pChildNorth, BorderLayout.SOUTH);
        pCenter.add(list, BorderLayout.CENTER);
        pCenter.add(new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.EAST);
        pCenter.add(Box.createRigidArea(new Dimension(10, 0)));
        pCenter.add(pChildSouth, BorderLayout.SOUTH);

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
        btnBoTo.addActionListener(this);
        btnSoChan.addActionListener(this);
        btnSoLe.addActionListener(this);
        btnSoNguyenTo.addActionListener(this);
        btnSum.addActionListener(this);
        btnXoa.addActionListener(this);
        btnRandom.addActionListener(this);
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
        if (o.equals(btnExit))
            System.exit(0);
        else if (o.equals(btnAdd))
            nhapTuBanPhim();
        else if (o.equals(btnBoTo))
            list.clearSelection();
        else if (o.equals(btnSoChan))
            toDenSoChan();
        else if (o.equals(btnSoLe))
            toDenSoLe();
        else if (o.equals(btnSum))
            JOptionPane.showMessageDialog(this, "Tổng các phần tử: " + tinhTong());
        else if (o.equals(btnSoNguyenTo))
            toDenSoNTo();
        else if (o.equals(btnXoa))
            xoaPhanTuDaChon();
        else if (o.equals(btnRandom)) {
            listModel.clear();
            phatSinhSo();
        }
    }

    private void nhapTuBanPhim() {
        int n;
        try {
            n = Integer.parseInt(txtInput.getText());
            if (!chkSoAm.isSelected() && n > 0)
                listModel.addElement(n);
            else if (chkSoAm.isSelected())
                listModel.addElement(n);
            else {
                JOptionPane.showMessageDialog(this, "Nhập số nguyên dương");
                return;
            }
            txtInput.setText("");
            focusTextField(txtInput);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Nhập số nguyên");
            txtInput.setText("");
            focusTextField(txtInput);
            return;
        }
    }

    private void phatSinhSo() {
        for (int i = 0; i < 100; i++) {
            if (chkSoAm.isSelected())
                listModel.addElement(new Random().nextInt(200) - 100);
            else
                listModel.addElement(new Random().nextInt(200));
        }
    }

    private void xoaPhanTuDaChon() {
        int soPhanTu = list.getSelectedValuesList().size();
        for (int i = 0; i < soPhanTu; i++)
            listModel.removeElementAt(list.getSelectedIndex());
    }

    private void toDenSoNTo() {
        list.clearSelection();
        for (int i = 0; i < listModel.size(); i++) {
            if (isPrime(listModel.getElementAt(i)))
                list.addSelectionInterval(i, i);
        }
    }

    private int tinhTong() {
        int tong = 0;
        for (int i = 0; i < listModel.size(); i++) {
            tong += listModel.getElementAt(i);
        }
        return tong;
    }

    private void toDenSoLe() {
        list.clearSelection();
        for (int i = 0; i < listModel.size(); i++) {
            if (listModel.getElementAt(i) % 2 != 0) {
                list.addSelectionInterval(i, i);
            }
        }
    }

    private void toDenSoChan() {
        list.clearSelection();
        for (int i = 0; i < listModel.size(); i++) {
            if (listModel.getElementAt(i) % 2 == 0) {
                list.addSelectionInterval(i, i);
            }
        }
    }

    // sàng số nguyên tố
    public boolean isPrime(int n) {
        if (n == 2 || n == 3 || n == 5)
            return true;
        if (n % 2 == 0 || n % 5 == 0 || n % 3 == 0 || n < 2)
            return false;
        if (n < 49)
            return true;
        if (n % 7 == 0 || n % 11 == 0 || n % 13 == 0 || n % 17 == 0 || n % 19 == 0 || n % 23 == 0 || n % 29 == 0
                || n % 31 == 0 || n % 37 == 0 || n % 41 == 0 || n % 43 == 0 || n % 47 == 0)
            return false;
        if (n < 2809)
            return true;
        long maxRange = (int) (Math.sqrt(n) + 1);
        for (int i = 53; i < maxRange; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public void focusTextField(JTextField text) {
        text.selectAll();
        text.requestFocus();
        return;
    }
}
