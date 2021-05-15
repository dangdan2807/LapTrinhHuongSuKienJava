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

public class PhongBanGUI extends JFrame implements ActionListener, MouseListener, KeyListener {
    private JTextField txtMaPB, txtTen, txtTim;
    private JButton btnTim, btnThem, btnXoaTrang, btnXoa, btnSua;
    String[] cols = { "Mã Phòng Ban", "Tên Phòng Ban" };
    private DefaultTableModel model;
    private JTable table;

    private PhongBan_DAO pb_DAO;

    public PhongBanGUI() {
        try {
            ConnectDB.getInstance().connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pb_DAO = new PhongBan_DAO();

        setTitle("Thông Tin Phòng Ban");
        setSize(630, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(null);
        pnMain.setBounds(0, 0, 630, 420);

        JLabel lbTitle = new JLabel("THÔNG TIN PHÒNG BAN");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lbTitle.setForeground(Color.BLUE);

        JLabel lbMaNV = new JLabel("Mã phòng ban: ");
        JLabel lbTen = new JLabel("Tên phòng ban: ");
        JLabel lbTim = new JLabel("Nhập mã PB cần tìm: ");

        txtMaPB = new JTextField();
        txtTen = new JTextField();
        txtTim = new JTextField();

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

        int widthPn = 600, widthBtn = 58, h = 20;
        lbTitle.setBounds(186, 5, 255, 20);
        lbMaNV.setBounds(10, 30, 108, 20);
        lbTen.setBounds(10, 55, 108, 20);

        txtMaPB.setBounds(120, 30, 485, 22);
        txtTen.setBounds(120, 55, 485, 22);

        pnTable.setBounds(10, 86, 600, 264);
        sql.setBounds(0, 0, 600, 264);
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
        pnMain.add(txtMaPB);
        pnMain.add(lbTen);
        pnMain.add(txtTen);
        pnMain.add(txtTen);
        pnMain.add(pnTable);
        pnMain.add(pnSouth);

        this.add(pnMain);

        btnTim.addActionListener(this);
        btnThem.addActionListener(this);
        btnXoaTrang.addActionListener(this);
        btnXoa.addActionListener(this);
        btnSua.addActionListener(this);

        table.addMouseListener(this);
        
        txtTim.addKeyListener(this);
        txtMaPB.addKeyListener(this);
        txtTen.addKeyListener(this);

        DocDuLieuVaoModel(pb_DAO.getAllDsPhongBan());
    }

    public static void main(String[] args) {
        new PhongBanGUI().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXoaTrang)) {
            txtMaPB.setText("");
            txtTen.setText("");
            txtMaPB.requestFocus();
        } else if (o.equals(btnThem)) {
            PhongBan pb = getSelectedDataTable();
            try {
                pb_DAO.create(pb);
                model.addRow(new Object[] { pb.getMaPB(), pb.getTenPB() });
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Trùng");
            }
        } else if (o.equals(btnXoa)) {
            PhongBan nv = getSelectedDataTable();
            int row = table.getSelectedRow();
            try {
                if (row == -1) {
                    JOptionPane.showMessageDialog(this, "Bạn có chưa chọn dòng cần xoá !!!");
                } else {
                    int select;
                    select = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng đã chọn ?", "Cảnh báo",
                            JOptionPane.YES_NO_OPTION);
                    if (select == JOptionPane.YES_OPTION) {
                        pb_DAO.delete(nv);
                        model.removeRow(row);
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                    }
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } else if (o.equals(btnSua)) {
            PhongBan pb = getSelectedDataTable();
            try {
                pb_DAO.update(pb);
                int row = table.getSelectedRow();
                model.setValueAt(pb.getMaPB(), row, 0);
                model.setValueAt(pb.getTenPB(), row, 1);
            } catch (Exception e3) {
                JOptionPane.showMessageDialog(this, "Sửa thông tin thất bại");
            }
        } else if (o.equals(btnTim)) {
            String maPB = txtTim.getText();
            if (maPB.isEmpty()) {
                model.getDataVector().removeAllElements();
                ArrayList<PhongBan> ds = pb_DAO.getAllDsPhongBan();
                DocDuLieuVaoModel(ds);
            } else {
                try {
                    model.getDataVector().removeAllElements();
                    ArrayList<PhongBan> ds = pb_DAO.getNhanVienTheoMaPB(maPB);
                    if (ds.size() <= 0) {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy phòng ban");
                    } else
                        DocDuLieuVaoModel(ds);
                } catch (Exception e4) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy phòng ban");
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object o = e.getSource();
        if (o.equals(txtTim)) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                btnTim.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        txtMaPB.setText(model.getValueAt(row, 0).toString());
        txtTen.setText(model.getValueAt(row, 1).toString());
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

    private void DocDuLieuVaoModel(ArrayList<PhongBan> dsPhongBan) {
        for (int i = 0; i < dsPhongBan.size(); i++) {
            PhongBan nv = dsPhongBan.get(i);
            model.addRow(new Object[] { nv.getMaPB(), nv.getTenPB() });
        }
    }

    private PhongBan getSelectedDataTable() {
        String maPB = txtMaPB.getText().trim();
        String tenPB = txtTen.getText().trim();
        PhongBan pb = new PhongBan(maPB, tenPB);
        return pb;
    }

}
