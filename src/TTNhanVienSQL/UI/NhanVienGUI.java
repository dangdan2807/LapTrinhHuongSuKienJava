package TTNhanVienSQL.UI;

import javax.swing.*;
import javax.swing.table.*;

import TTNhanVienSQL.DAO.*;
import TTNhanVienSQL.connectDB.*;
import TTNhanVienSQL.entity.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class NhanVienGUI extends JFrame implements ActionListener, MouseListener {
    private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtLuong, txtTim;
    private JCheckBox chkPhai;
    private JButton btnTim, btnThem, btnXoaTrang, btnXoa, btnSua;
    String[] cols = { "Mã NV", "Họ NV", "Tên NV", "Tuổi", "Phái", "Lương", "Phòng Ban" };
    private DefaultTableModel model;
    private JTable table;
    private JComboBox<String> cboPhongBan;

    private NhanVien_DAO nv_DAO;
    private PhongBan_DAO pb_DAO;
    private ArrayList<PhongBan> dsPhongBan;

    public NhanVienGUI() {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nv_DAO = new NhanVien_DAO();
        pb_DAO = new PhongBan_DAO();

        setTitle("Thông Tin Nhân Viên");
        setSize(630, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(null);
        pnMain.setBounds(0, 0, 630, 420);

        JLabel lbTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lbTitle.setForeground(Color.BLUE);

        JLabel lbMaNV = new JLabel("Mã nhân viên: ");
        JLabel lbHo = new JLabel("Họ: ");
        JLabel lbTen = new JLabel("Tên nhân viên: ");
        JLabel lbTuoi = new JLabel("Tuổi: ");
        JLabel lbLuong = new JLabel("Lương: ");
        JLabel lbPhai = new JLabel("Phái: ");
        JLabel lbPhongBan = new JLabel("Phòng Ban: ");
        JLabel lbTim = new JLabel("Nhập mã NV cần tìm: ");

        txtMaNV = new JTextField();
        txtHo = new JTextField();
        txtTen = new JTextField();
        txtTuoi = new JTextField();
        txtLuong = new JTextField();
        txtTim = new JTextField();

        cboPhongBan = new JComboBox<String>();
        chkPhai = new JCheckBox("Nữ");

        btnTim = new JButton("Tìm");
        btnThem = new JButton("Thêm");
        btnXoaTrang = new JButton("Xoá Trắng");
        btnXoa = new JButton("Xoá");
        btnSua = new JButton("Sửa");

        JPanel pnTable = new JPanel();
        pnTable.setLayout(null);
        model = new DefaultTableModel(cols, 0) {
            // khóa không cho người dùng nhập trên table
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        table = new JTable(model);
        JScrollPane sql = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnTable.add(sql);

        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(null);

        int widthLb = 85, widthPn = 600, widthBtn = 58, h = 20, hTxt = 22, xTxt = 105;
        lbTitle.setBounds(186, 5, 225, h);
        lbMaNV.setBounds(10, 30, widthLb, h);
        lbHo.setBounds(10, 55, widthLb, h);
        lbTen.setBounds(306, 55, 100, 20);
        lbTuoi.setBounds(10, 80, widthLb, h);
        lbPhai.setBounds(450, 80, 40, h);
        lbLuong.setBounds(10, 105, widthLb, h);
        chkPhai.setBounds(490, 80, 50, h);
        lbPhongBan.setBounds(421, 105, 75, 20);

        txtMaNV.setBounds(xTxt, 30, 500, hTxt);
        txtHo.setBounds(xTxt, 55, 200, hTxt);
        txtTen.setBounds(405, 55, 200, 22);
        txtTuoi.setBounds(xTxt, 80, 340, hTxt);
        txtLuong.setBounds(105, 105, 306, 22);
        cboPhongBan.setBounds(500, 105, 110, 22);

        pnTable.setBounds(10, 130, widthPn, 220);
        sql.setBounds(0, 0, widthPn, 220);
        pnSouth.setBounds(10, 355, widthPn, 30);

        lbTim.setBounds(0, 0, 130, h);
        txtTim.setBounds(132, 0, 120, h);
        btnTim.setBounds(252, 0, widthBtn, h);
        btnThem.setBounds(312, 0, 68, h);
        btnXoaTrang.setBounds(382, 0, 93, h);
        btnXoa.setBounds(477, 0, widthBtn, h);
        btnSua.setBounds(536, 0, widthBtn, h);

        pnSouth.add(lbTim);
        pnSouth.add(txtTim);
        pnSouth.add(btnTim);
        pnSouth.add(btnThem);
        pnSouth.add(btnXoaTrang);
        pnSouth.add(btnXoa);
        pnSouth.add(btnSua);

        pnMain.add(lbTitle);
        pnMain.add(lbMaNV);
        pnMain.add(txtMaNV);
        pnMain.add(lbHo);
        pnMain.add(txtHo);
        pnMain.add(lbTen);
        pnMain.add(txtTen);
        pnMain.add(lbTuoi);
        pnMain.add(txtTuoi);
        pnMain.add(lbPhai);
        pnMain.add(chkPhai);
        pnMain.add(lbLuong);
        pnMain.add(txtLuong);
        pnMain.add(lbPhongBan);
        pnMain.add(cboPhongBan);
        pnMain.add(pnTable);
        pnMain.add(pnSouth);

        getContentPane().add(pnMain);

        btnTim.addActionListener(this);
        btnThem.addActionListener(this);
        btnXoaTrang.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSua.addActionListener(this);

        table.addMouseListener(this);

        DocDuLieuPhongBan();
        DocDuLieuVaoModel(nv_DAO.getAllDsNhanVien());
    }

    public static void main(String[] args) {
        new NhanVienGUI().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXoaTrang)) {
            txtMaNV.setText("");
            txtTen.setText("");
            txtHo.setText("");
            txtTuoi.setText("");
            txtLuong.setText("");
            chkPhai.setSelected(false);
            txtMaNV.requestFocus();
            cboPhongBan.setSelectedItem(0);
        } else if (o.equals(btnThem)) {
            NhanVien nv = getSelectedDataTable();
            try {
                nv_DAO.create(nv);
                String gioiTinh = nv.getPhai() ? "Nữ" : "Nam";
                model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), gioiTinh,
                        nv.getLuong(), nv.getPhongBan().getTenPB() });
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Trùng");
            }
        } else if (o.equals(btnXoa)) {
            NhanVien nv = getSelectedDataTable();
            int row = table.getSelectedRow();
            try {
                if (row == -1) {
                    JOptionPane.showMessageDialog(this, "Bạn có chưa chọn dòng cần xoá !!!");
                } else {
                    int select;
                    select = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng đã chọn ?", "Cảnh báo",
                            JOptionPane.YES_NO_OPTION);
                    if (select == JOptionPane.YES_OPTION) {
                        nv_DAO.delete(nv);
                        model.removeRow(row);
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                    }
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } else if (o.equals(btnSua)) {
            NhanVien nv = getSelectedDataTable();
            try {
                nv_DAO.update(nv);
                int row = table.getSelectedRow();
                model.setValueAt(nv.getMaNV(), row, 0);
                model.setValueAt(nv.getHoNV(), row, 1);
                model.setValueAt(nv.getTenNV(), row, 2);
                model.setValueAt(nv.getTuoi(), row, 3);
                model.setValueAt((nv.getPhai() == true ? "Nữ" : "Nam"), row, 4);
                model.setValueAt(nv.getLuong(), row, 5);
                model.setValueAt(nv.getPhongBan().getTenPB(), row, 6);
            } catch (Exception e3) {
                JOptionPane.showMessageDialog(this, "Sửa thông tin thất bại");
            }
        } else if (o.equals(btnTim)) {
            String maNV = txtTim.getText();
            if (maNV.isEmpty()) {
                model.getDataVector().removeAllElements();
                ArrayList<NhanVien> ds = nv_DAO.getAllDsNhanVien();
                DocDuLieuVaoModel(ds);
            } else {
                try {
                    model.getDataVector().removeAllElements();
                    ArrayList<NhanVien> ds = nv_DAO.getNhanVienTheoMaNV(maNV);
                    if (ds.size() <= 0) {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
                    } else
                        DocDuLieuVaoModel(ds);
                } catch (Exception e4) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        txtMaNV.setText(model.getValueAt(row, 0).toString());
        txtHo.setText(model.getValueAt(row, 1).toString());
        txtTen.setText(model.getValueAt(row, 2).toString());
        txtTuoi.setText(model.getValueAt(row, 3).toString());
        chkPhai.setSelected(model.getValueAt(row, 4).toString().equals("Nữ") ? true : false);
        txtLuong.setText(model.getValueAt(row, 5).toString());
        cboPhongBan.setSelectedItem(model.getValueAt(row, 6).toString());
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

    private void DocDuLieuVaoModel(ArrayList<NhanVien> dsNhanVien) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            NhanVien nv = dsNhanVien.get(i);
            String maPB = nv.getPhongBan().getMaPB();
            String gioiTinh = (nv.getPhai() == false ? "Nữ" : "Nam");
            for (PhongBan item : dsPhongBan)
                if (item.getMaPB().contains(maPB))
                    nv.getPhongBan().setTenPB(item.getTenPB());
            model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), gioiTinh,
                    nv.getLuong(), nv.getPhongBan().getTenPB() });
        }
    }

    private void DocDuLieuPhongBan() {
        dsPhongBan = pb_DAO.getAllDsPhongBan();
        for (PhongBan item : dsPhongBan) {
            cboPhongBan.addItem(item.getTenPB());
        }
    }

    private NhanVien getSelectedDataTable() {
        String maNV = txtMaNV.getText().trim();
        String hoNV = txtHo.getText().trim();
        String tenNV = txtTen.getText().trim();
        int tuoi = Integer.parseInt(txtTuoi.getText().trim());
        boolean phai = chkPhai.isSelected();
        double luong = Double.parseDouble(txtLuong.getText().trim());
        String tenPB = cboPhongBan.getSelectedItem().toString().trim();
        int indexPhongBan = 0, i = 0;
        for (PhongBan item : dsPhongBan) {
            if (item.getTenPB().contains(tenPB)) {
                indexPhongBan = i;
                break;
            }
            i++;
        }

        NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, dsPhongBan.get(indexPhongBan));
        return nv;
    }
}
