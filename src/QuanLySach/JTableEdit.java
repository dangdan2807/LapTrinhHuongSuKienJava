package QuanLySach;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class JTableEdit extends JFrame implements ActionListener, MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField txtMaSach, txtTuaSach, txtTacGia, txtNamSx, txtNxb, txtSoTrang, txtDonGia, txtIsbn;
    private JButton btnThem, btnXoaRong, btnXoa, btnSua, btnLuu;
    String[] cols = { "Mã sách", "Tựa sách", "Tác giả", "Năm sản xuất", "Nhà xuất bản", "Số trang", "Đơn giá", "ISBN" };
    private DefaultTableModel modelTable;
    private JTable table;
    private JComboBox<String> cboSach;

    private QuanLySach ds;

    public JTableEdit() {
        setTitle("Quản Lý Sách");
        setSize(900, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createGUI();
    }

    public void createGUI() {
        JPanel pMain = new JPanel();
        pMain.setLayout(new BoxLayout(pMain, BoxLayout.Y_AXIS));
        JPanel pTren = new JPanel();
        JPanel pGiua = new JPanel();
        JPanel pDuoi = new JPanel();

        // panel trên
        pTren.setLayout(new GridLayout(5, 4, 10, 20));
        pTren.setPreferredSize(new Dimension(900, 200));
        pTren.setBorder(BorderFactory.createTitledBorder(null, "Records Editor"));

        JLabel lbMaSach = new JLabel("Mã sách:");
        JLabel lbTuaSach = new JLabel("Tựa sách:");
        JLabel lbTacGia = new JLabel("Tác giả");
        JLabel lbNsx = new JLabel("Năm sản xuẩt: ");
        JLabel lbNxb = new JLabel("Nhà xuất bản: ");
        JLabel lbSoTrang = new JLabel("Số trang: ");
        JLabel lbDonGia = new JLabel("Đơn Giá");
        JLabel lbIsbn = new JLabel("International Standard Book Number (ISBN):");
        JLabel lbTimKiem = new JLabel("Tìm theo mã Sách");

        txtMaSach = new JTextField(15);
        txtTuaSach = new JTextField(15);
        txtTacGia = new JTextField(15);
        txtNamSx = new JTextField(15);
        txtNxb = new JTextField(15);
        txtSoTrang = new JTextField(15);
        txtDonGia = new JTextField(15);
        txtIsbn = new JTextField(15);

        pTren.add(lbMaSach);
        pTren.add(txtMaSach);
        pTren.add(new JLabel(""));
        pTren.add(new JLabel(""));
        pTren.add(lbTuaSach);
        pTren.add(txtTuaSach);
        pTren.add(lbTacGia);
        pTren.add(txtTacGia);
        pTren.add(lbNsx);
        pTren.add(txtNamSx);
        pTren.add(lbNxb);
        pTren.add(txtNxb);
        pTren.add(lbSoTrang);
        pTren.add(txtSoTrang);
        pTren.add(lbDonGia);
        pTren.add(txtDonGia);
        pTren.add(lbIsbn);
        pTren.add(txtIsbn);

        // panel giữa
        btnThem = new JButton("Thêm");
        btnXoaRong = new JButton("Xóa Rỗng");
        btnXoa = new JButton("Xóa");
        btnSua = new JButton("Sửa");
        btnLuu = new JButton("Lưu");
        cboSach = new JComboBox<String>();
        cboSach.addItem("None");

        pGiua.add(btnThem);
        pGiua.add(btnXoaRong);
        pGiua.add(btnSua);
        pGiua.add(btnXoa);
        pGiua.add(btnLuu);
        pGiua.add(Box.createHorizontalStrut(50));
        pGiua.add(lbTimKiem);
        pGiua.add(cboSach);

        // panel dưới
        pDuoi.setBorder(BorderFactory.createTitledBorder(null, "Danh sách các cuốn sách"));
        pDuoi.setLayout(new BoxLayout(pDuoi, BoxLayout.X_AXIS));
        modelTable = new DefaultTableModel(cols, 0) {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; // To change body of generated methods, choose Tools | Templates.
            }
        };
        table = new JTable(modelTable);
        JScrollPane scp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pDuoi.add(scp);

        // đọc dữ liệu
        ds = new QuanLySach();
        try {
            ds.docDuLieuTuFile();
            for (int i = 0; i < ds.getSize(); i++) {
                Sach s = ds.getElement(i);
                modelTable.addRow(new Object[] { s.getMaSach(), s.getTuaSach(), s.getTacGia(), s.getNamSx(), s.getNxb(),
                        s.getSoTrang(), s.getDonGia(), s.getISBN() });
                cboSach.addItem(s.getMaSach());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // thêm vào box chính
        pMain.add(pTren);
        pMain.add(pGiua);
        pMain.add(pDuoi);

        add(pMain);

        btnThem.addActionListener(this);
        btnLuu.addActionListener(this);
        btnSua.addActionListener(this);
        btnXoa.addActionListener(this);
        btnXoaRong.addActionListener(this);
        cboSach.addActionListener(this);
        table.addMouseListener(this);
    }

    public static void main(String[] args) {
        new JTableEdit().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThem)) {
            if (txtMaSach.getText().equals("") || txtTuaSach.getText().equals("") || txtTacGia.getText().equals("")
                    || txtNxb.getText().equals("") || txtNamSx.getText().equals("") || txtSoTrang.getText().equals("")
                    || txtDonGia.getText().equals("") || txtIsbn.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Thiếu dữ liệu đầu vào");
            } else {
                themSachMoi();
            }
        } else if (o.equals(btnXoaRong)) {
            txtMaSach.setText("");
            txtTuaSach.setText("");
            txtTacGia.setText("");
            txtNxb.setText("");
            txtNamSx.setText("");
            txtSoTrang.setText("");
            txtDonGia.setText("");
            txtIsbn.setText("");
        } else if (o.equals(btnXoa)) {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Bạn có chưa chọn dòng cần xoá !!!");
            } else {
                int select;
                select = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng đã chọn ?", "Cảnh báo",
                        JOptionPane.YES_NO_OPTION);
                if (select == JOptionPane.YES_OPTION) {
                    modelTable.removeRow(row);
                    ds.xoaSach(row);
                }
            }
        } else if (o.equals(btnSua)) {
            if (txtMaSach.getText().equals("") || txtTuaSach.getText().equals("") || txtTacGia.getText().equals("")
                    || txtNxb.getText().equals("") || txtNamSx.getText().equals("") || txtSoTrang.getText().equals("")
                    || txtDonGia.getText().equals("") || txtIsbn.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Thiếu dữ liệu đầu vào");
            } else {
                int namSX = Integer.parseInt(txtNamSx.getText());
                int soTrang = Integer.parseInt(txtSoTrang.getText());
                double donGia = Double.parseDouble(txtDonGia.getText());
                int row = table.getSelectedRow();
                Sach s = ds.getElement(row);

                String maSach = txtMaSach.getText();
                if (s.getMaSach().equals(maSach)) {
                    s.setTuaSach(txtTuaSach.getText());
                    s.setTacGia(txtTacGia.getText());
                    s.setNxb(txtNxb.getText());
                    s.setNamSx(namSX);
                    s.setSoTrang(soTrang);
                    s.setDonGia(donGia);
                    s.setISBN(txtIsbn.getText());
                    modelTable.setValueAt(txtTuaSach.getText(), row, 1);
                    modelTable.setValueAt(txtTacGia.getText(), row, 2);
                    modelTable.setValueAt(txtNxb.getText(), row, 3);
                    modelTable.setValueAt(namSX, row, 4);
                    modelTable.setValueAt(soTrang, row, 5);
                    modelTable.setValueAt(donGia, row, 6);
                    modelTable.setValueAt(txtIsbn.getText(), row, 7);
                    System.out.println("cập nhật sách thành công");
                } else {
                    boolean result = themSachMoi();
                    if (result) {
                        JOptionPane.showMessageDialog(this, "Mã sách mới, tiến hành thêm sách mới", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else if (o.equals(btnLuu)) {
            LuuTru_Character lt = new LuuTru_Character();
            lt.LuuFile(ds.getDS());
            System.out.println("done........");
        } else if (o.equals(cboSach)) {
            String ma = cboSach.getSelectedItem().toString();
            String temp = "";
            timSach(ma);
            int row = 0;
            for (int i = 0; i < table.getRowCount(); i++) {
                temp = (String) table.getValueAt(i, 0);
                if (temp.equals(ma)) {
                    row = i;
                }
            }
            chonDong(row);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        chonDong(row);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override

    public void mouseExited(MouseEvent e) {

    }

    public boolean themSachMoi() {
        boolean result;
        int namSX = Integer.parseInt(txtNamSx.getText());
        int soTrang = Integer.parseInt(txtSoTrang.getText());
        double donGia = Double.parseDouble(txtDonGia.getText());
        Sach s = new Sach(txtMaSach.getText(), txtTuaSach.getText(), txtTacGia.getText(), txtNxb.getText(), namSX,
                soTrang, donGia, txtIsbn.getText());

        result = ds.themSach(s);
        if (result) {
            modelTable.addRow(new Object[] { txtMaSach.getText(), txtTuaSach.getText(), txtTacGia.getText(),
                    txtNxb.getText(), namSX, soTrang, donGia, txtIsbn.getText() });
            cboSach.addItem(txtMaSach.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Sách đã tồn tại !!!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }

    public void timSach(String maSach) {
        String temp = "";
        if (maSach.equals("None")) {
            for (int i = 0; i < table.getRowCount(); i++) {
                table.removeRowSelectionInterval(i, i);
            }
            // scroll về đầu danh sách
            Rectangle cellRect = table.getCellRect(0, 0, true);
            table.scrollRectToVisible(cellRect);
        } else {
            for (int i = 0; i < table.getRowCount(); i++) {
                temp = (String) table.getValueAt(i, 0);
                if (temp.equals(maSach)) {
                    table.setRowSelectionInterval(i, i);
                    // scroll đến dòng được chọn
                    Rectangle cellRect = table.getCellRect(i, 0, true);
                    table.scrollRectToVisible(cellRect);
                    return;
                }
            }
        }
    }

    public void chonDong(int row) {
        txtMaSach.setText(table.getValueAt(row, 0).toString());
        txtTuaSach.setText(table.getValueAt(row, 1).toString());
        txtTacGia.setText(table.getValueAt(row, 2).toString());
        txtNxb.setText(table.getValueAt(row, 3).toString());
        txtNamSx.setText(table.getValueAt(row, 4).toString());
        txtSoTrang.setText(table.getValueAt(row, 5).toString());
        txtDonGia.setText(table.getValueAt(row, 6).toString());
        txtIsbn.setText(table.getValueAt(row, 7).toString());
    }
}
