package QuanLySach;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.table.*;

public class QuanLySachGUI extends JFrame implements ActionListener, MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField txtMaSach, txtTuaSach, txtTacGia, txtNamSX, txtNxb, txtSoTrang, txtDonGia, txtIsbn;
    private JLabel lbShowMessage;
    private JButton btnThem, btnXoaRong, btnXoa, btnSua, btnLuu;
    String[] cols = { "Mã sách", "Tựa sách", "Tác giả", "Năm sản xuất", "Nhà xuất bản", "Số trang", "Đơn giá", "ISBN" };
    private DefaultTableModel modelTable;
    private JTable table;
    private JComboBox<String> cboSach;

    private QuanLySach ds;

    public QuanLySachGUI() {
        setTitle("Quản Lý Sách");
        setSize(1100, 500);
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
        pTren.setLayout(new GridLayout(6, 2, 10, 10));
        pTren.setBorder(BorderFactory.createTitledBorder(null, "Records Editor"));

        JLabel lbMaSach = new JLabel("Mã sách:");
        JLabel lbTuaSach = new JLabel("Tựa sách:");
        JLabel lbTacGia = new JLabel("Tác giả");
        JLabel lbNamSX = new JLabel("Năm sản xuẩt: ");
        JLabel lbNxb = new JLabel("Nhà xuất bản: ");
        JLabel lbSoTrang = new JLabel("Số trang: ");
        JLabel lbDonGia = new JLabel("Đơn Giá");
        JLabel lbIsbn = new JLabel("International Standard Book Number (ISBN):");
        JLabel lbTimKiem = new JLabel("Tìm theo mã Sách");
        lbShowMessage = new JLabel("");
        lbShowMessage.setForeground(Color.RED);
        lbShowMessage.setFont(new Font("Arial", Font.ITALIC, 12));

        txtMaSach = new JTextField(15);
        txtTuaSach = new JTextField(15);
        txtTacGia = new JTextField(15);
        txtNamSX = new JTextField(15);
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
        pTren.add(lbNamSX);
        pTren.add(txtNamSX);
        pTren.add(lbNxb);
        pTren.add(txtNxb);
        pTren.add(lbSoTrang);
        pTren.add(txtSoTrang);
        pTren.add(lbDonGia);
        pTren.add(txtDonGia);
        pTren.add(lbIsbn);
        pTren.add(txtIsbn);
        pTren.add(new JLabel(""));
        pTren.add(new JLabel(""));
        pTren.add(lbShowMessage);

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
        new QuanLySachGUI().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThem)) {
            if (kiemTraData()) {
                boolean result = themSachMoi();
                if (result) {
                    lbShowMessage.setText("Thêm thành công 1 cuốn sách.");
                    int index = ds.getSize() - 1;
                    table.setRowSelectionInterval(index, index);
                } else {
                    showMessage("Error: Trùng mã sách !!!", txtMaSach);
                }
            }
        } else if (o.equals(btnXoaRong)) {
            txtMaSach.setText("");
            txtTuaSach.setText("");
            txtTacGia.setText("");
            txtNxb.setText("");
            txtNamSX.setText("");
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
                    String maSach = txtMaSach.getText().trim();
                    cboSach.removeItemAt(row + 1);
                    modelTable.removeRow(row);
                    ds.xoaSach(row);
                    showMessage("Xóa thành công sách có mã: " + maSach, txtMaSach);
                }
            }
        } else if (o.equals(btnSua)) {
            int namSX = Integer.parseInt(txtNamSX.getText());
            int soTrang = Integer.parseInt(txtSoTrang.getText());
            double donGia = Double.parseDouble(txtDonGia.getText());
            int row = table.getSelectedRow();
            String maSach = txtMaSach.getText();
            Sach s = ds.getElement(row);
            if (s.getMaSach().equals(maSach)) {
                if (kiemTraData()) {
                    // cập nhật trong danh sách
                    s.setTuaSach(txtTuaSach.getText());
                    s.setTacGia(txtTacGia.getText());
                    s.setNamSx(namSX);
                    s.setNxb(txtNxb.getText());
                    s.setSoTrang(soTrang);
                    s.setDonGia(donGia);
                    s.setISBN(txtIsbn.getText());
                    // cập nhật trong table
                    modelTable.setValueAt(txtTuaSach.getText(), row, 1);
                    modelTable.setValueAt(txtTacGia.getText(), row, 2);
                    modelTable.setValueAt(namSX, row, 3);
                    modelTable.setValueAt(txtNxb.getText(), row, 4);
                    modelTable.setValueAt(soTrang, row, 5);
                    modelTable.setValueAt(donGia, row, 6);
                    modelTable.setValueAt(txtIsbn.getText(), row, 7);
                    showMessage("Cập nhật sách thành công", txtMaSach);
                }
            } else {
                showMessage("Error: Không tìm thấy mã sách !!!", txtMaSach);
            }
        } else if (o.equals(btnLuu)) {
            LuuTru_Character lt = new LuuTru_Character();
            lt.LuuFile(ds.getDS());
            // System.out.println("Luu danh sach thanh cong");
            showMessage("Lưu danh sách thành công", txtMaSach);
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

    private boolean themSachMoi() {
        boolean result = false;
        String maSach = txtMaSach.getText().trim();
        String tuaSach = txtTuaSach.getText().trim();
        String tacGia = txtTacGia.getText().trim();
        String nxb = txtNxb.getText().trim();
        String ISBN = txtIsbn.getText().trim();
        String nam = txtNamSX.getText().trim();
        String trang = txtSoTrang.getText().trim();
        String gia = txtDonGia.getText().trim();

        int namSX = nam.length() == 0 ? 0 : Integer.parseInt(nam);
        int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);
        double donGia = gia.length() == 0 ? 0 : Double.parseDouble(gia);

        Sach s = new Sach(maSach, tuaSach, tacGia, namSX, nxb, soTrang, donGia, ISBN);

        result = ds.themSach(s);
        if (result) {
            // thêm vào table
            modelTable.addRow(new Object[] { maSach, tuaSach, tacGia, namSX, nxb, soTrang, donGia, ISBN });
            // thêm vào danh sách id
            cboSach.addItem(maSach);
            return true;
        }
        return false;
    }

    private void timSach(String maSach) {
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

    private void chonDong(int row) {
        txtMaSach.setText(table.getValueAt(row, 0).toString());
        txtTuaSach.setText(table.getValueAt(row, 1).toString());
        txtTacGia.setText(table.getValueAt(row, 2).toString());
        txtNamSX.setText(table.getValueAt(row, 3).toString());
        txtNxb.setText(table.getValueAt(row, 4).toString());
        txtSoTrang.setText(table.getValueAt(row, 5).toString());
        txtDonGia.setText(table.getValueAt(row, 6).toString());
        txtIsbn.setText(table.getValueAt(row, 7).toString());
    }

    private void showMessage(String message, JTextField txt) {
        lbShowMessage.setText(message);
        txt.requestFocus();
    }

    // kiểm tra dữ liệu đầu vào
    private boolean kiemTraData() {
        String maSach = txtMaSach.getText().trim();
        String tuaSach = txtTuaSach.getText().trim();
        String tacGia = txtTacGia.getText().trim();
        String namSX = txtNamSX.getText().trim();
        String nxb = txtNxb.getText().trim();
        String soTrang = txtSoTrang.getText().trim();
        String donGia = txtDonGia.getText().trim();
        String isbn = txtIsbn.getText().trim();

        if (!(maSach.length() > 0 && maSach.matches("[A-Z]\\d{3}"))) {
            showMessage("Error: Mã sách phải theo mẫu: [A-Z]\\d{3}", txtMaSach);
            return false;
        }

        if (!(tuaSach.length() > 0 && tuaSach.matches("[a-zA-Z' ]+"))) {
            showMessage("Error: Tựa sách theo mẫu: [a-zA-Z' ]+", txtTuaSach);
            return false;
        }

        if (!(tacGia.length() > 0 && tacGia.matches("[a-zA-Z' ]+"))) {
            showMessage("Error: Tác giả theo mẫu: [a-zA-Z' ]+", txtTacGia);
            return false;
        }

        if (namSX.length() > 0) {
            try {
                int nam = Integer.parseInt(namSX);
                int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
                if (nam < 1900 || nam > namHienTai) {
                    showMessage("Error: Năm > 1900 và năm < " + namHienTai, txtNamSX);
                    return false;
                }
            } catch (Exception e) {
                showMessage("Error: Năm xuất bản phải nhập số.", txtNamSX);
                return false;
            }
        }

        if (!(nxb.length() > 0 && nxb.matches("[a-zA-Z' ]+"))) {
            showMessage("Error: Nhà xuất bản theo mẫu: [a-zA-Z' ]+", txtTacGia);
            return false;
        }

        if (soTrang.length() > 0) {
            try {
                int num = Integer.parseInt(soTrang);
                if (num <= 0) {
                    showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
                    return false;
                }
            } catch (Exception e) {
                showMessage("Error: Số trang phải nhập số nguyên dương.", txtSoTrang);
                return false;
            }
        }

        if (donGia.length() > 0) {
            try {
                double num = Double.parseDouble(donGia);
                if (num < 0) {
                    showMessage("Error: Đơn giá phải > 0.", txtDonGia);
                    return false;
                }
            } catch (NumberFormatException ex) {
                showMessage("Error: Đơn giá phải nhập số.", txtDonGia);
                return false;
            }
        }

        if (isbn.length() > 0)
            if (!isbn.matches("\\d+(-\\d+){3,4}")) {
                showMessage("Error: ISBN có mẫu dạng  X-X-X-X  (hoặc X-X-X-X-X).", txtIsbn);
                return false;
            }

        return true;
    }
}
