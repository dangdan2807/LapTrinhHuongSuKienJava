package TTNhanVien;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.table.*;

public class NhanVien_App extends JFrame implements ActionListener, MouseListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtLuong, txtTim;
    private JCheckBox chkPhai;
    private JButton btnTim, btnThem, btnXoaTrang, btnXoa, btnLuu;
    String[] cols = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Lương" };
    private DefaultTableModel model;
    private JTable table;
    private NhanVien_Collection listNV;

    // Lấy đường dẫn từ ổ đĩa đến project
    String workingDir = System.getProperty("user.dir") + "/src/TTNhanVien_FileObjectStream/";

    public NhanVien_App() {
        setTitle("Thông Tin Nhân Viên");
        setSize(605, 420);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        JLabel lbTitle = new JLabel("Thông Tin Nhân Viên");
        lbTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lbTitle.setForeground(Color.BLUE);

        JLabel lbMaNV = new JLabel("Mã nhân viên: ");
        JLabel lbHo = new JLabel("Họ: ");
        JLabel lbTen = new JLabel("Tên nhân viên: ");
        JLabel lbTuoi = new JLabel("Tuổi: ");
        JLabel lbLuong = new JLabel("Lương: ");
        JLabel lbPhai = new JLabel("Phái: ");
        JLabel lbTim = new JLabel("Nhập mã NV cần tìm: ");

        txtMaNV = new JTextField(54);
        txtHo = new JTextField(21);
        txtTen = new JTextField(20);
        txtTuoi = new JTextField(43);
        txtLuong = new JTextField(54);
        txtTim = new JTextField(10);

        chkPhai = new JCheckBox("Nữ");

        btnTim = new JButton("Tìm");
        btnThem = new JButton("Thêm");
        btnXoaTrang = new JButton("Xoá Trắng");
        btnXoa = new JButton("Xoá");
        btnLuu = new JButton("Lưu");

        //
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        Box pTable = Box.createVerticalBox();
        JPanel pSouth = new JPanel();
        JPanel pNorth = new JPanel();
        JPanel pCenter = new JPanel();

        p1.add(lbMaNV);
        p1.add(txtMaNV);

        p2.add(lbHo);
        p2.add(Box.createHorizontalStrut(55));
        p2.add(txtHo);
        p2.add(Box.createHorizontalStrut(1));
        p2.add(lbTen);
        p2.add(Box.createHorizontalStrut(1));
        p2.add(txtTen);

        p3.add(lbTuoi);
        p3.add(Box.createHorizontalStrut(45));
        p3.add(txtTuoi);
        p3.add(Box.createHorizontalStrut(1));
        p3.add(lbPhai);
        p3.add(Box.createHorizontalStrut(5));
        p3.add(chkPhai);

        p4.add(lbLuong);
        p4.add(Box.createHorizontalStrut(29));
        p4.add(txtLuong);

        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);
        pTable.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        //
        Box b = Box.createVerticalBox();
        b.add(p1);
        b.add(p2);
        b.add(p3);
        b.add(p4);
        b.add(pTable);

        //
        pNorth.add(lbTitle);
        pCenter.add(b);
        pSouth.add(lbTim);
        pSouth.add(txtTim);
        pSouth.add(btnTim);
        pSouth.add(btnThem);
        pSouth.add(btnXoaTrang);
        pSouth.add(btnXoa);
        pSouth.add(btnLuu);

        //
        main.add(pNorth);
        main.add(pCenter);
        main.add(pSouth);
        add(main);

        // kiểm tra và tạo folder data
        File f = new File(workingDir + "Data");
        if (!f.exists())
            f.mkdir();

        listNV = new NhanVien_Collection();
        LuuTru lt = new LuuTru();
        try {
            listNV = (NhanVien_Collection) lt.DocFile(workingDir + "Data/NhanVien.txt");
        } catch (Exception e) {
            System.out.println("Không tìm thấy file !!!");
        }

        DocDuLieuVaoModel();

        //
        btnTim.addActionListener(this);
        btnThem.addActionListener(this);
        btnXoaTrang.addActionListener(this);
        btnXoa.addActionListener(this);
        btnLuu.addActionListener(this);

        table.addMouseListener(this);
    }

    public static void main(String[] args) {
        new NhanVien_App().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        txtMaNV.setText(model.getValueAt(row, 0).toString());
        txtHo.setText(model.getValueAt(row, 1).toString());
        txtTen.setText(model.getValueAt(row, 2).toString());
        chkPhai.setSelected(model.getValueAt(row, 3).toString().equals("Nữ") ? true : false);
        txtTuoi.setText(model.getValueAt(row, 4).toString());
        txtLuong.setText(model.getValueAt(row, 5).toString());

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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnLuu)) {
            LuuTru lt = new LuuTru();
            try {
                lt.LuuFile(listNV, workingDir + "Data/NhanVien.txt");
                System.out.println("Lưu file thành công");
            } catch (Exception e1) {
                System.out.println("Lưu file thất bại");
                e1.printStackTrace();
            }
        } else if (o.equals(btnThem)) {
            if (isInt(txtTuoi) && isDouble(txtLuong)) {
                String maNV = txtMaNV.getText();
                String ho = txtHo.getText();
                String ten = txtTen.getText();
                int tuoi = Integer.parseInt(txtTuoi.getText());
                double luong = Double.parseDouble(txtLuong.getText());
                Boolean phai = chkPhai.isSelected();
                String gioiTinh = (phai ? "Nữ" : "Nam");

                if (tuoi > 0 && luong > 0) {
                    NhanVien nv = new NhanVien(maNV, ho, ten, phai, tuoi, luong);
                    if (!listNV.themNhanVien(nv))
                        JOptionPane.showMessageDialog(this, "Thông tin nhân viên đã tồn tại");
                    else
                        model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gioiTinh, nv.getTuoi(),
                                nv.getLuong() });
                } else {
                    if (tuoi <= 0) {
                        JOptionPane.showMessageDialog(this, "Tuổi phải lớn hơn không");
                        focusTextField(txtTuoi);
                    } else if (luong <= 0) {
                        JOptionPane.showMessageDialog(this, "Lương phải lớn hơn không");
                        focusTextField(txtLuong);
                    }
                }
            } else {
                if (!isInt(txtTuoi))
                    JOptionPane.showMessageDialog(this, "Tuổi phải là một số nguyên dương");
                else if (!isDouble(txtLuong))
                    JOptionPane.showMessageDialog(this, "Lương phải là một số dương");
            }

        } else if (o.equals(btnXoa)) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá");
            } else {
                int tb;
                tb = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng này?", "Cảnh báo",
                        JOptionPane.YES_NO_OPTION);
                if (tb == JOptionPane.YES_OPTION) {
                    int index = table.getSelectedRow();
                    model.removeRow(index);
                    NhanVien nv = listNV.getElement(index);
                    listNV.xoaNhanVien(nv.getMaNV());
                }
            }
        } else if (o.equals(btnXoaTrang)) {
            txtMaNV.setText("");
            txtTen.setText("");
            txtHo.setText("");
            txtTuoi.setText("");
            txtLuong.setText("");
            chkPhai.setSelected(false);
            txtMaNV.requestFocus();
        } else if (o.equals(btnTim)) {
            timTheoMaNV();
        }
    }

    private void DocDuLieuVaoModel() {
        for (int i = 0; i < listNV.getSize(); i++) {
            NhanVien nv = listNV.getElement(i);
            String gt = (nv.getPhai() ? "Nữ" : "Nam");
            model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gt, nv.getTuoi(), nv.getLuong() });
        }
    }

    private void xoaDuLieuTrongModel() {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.getDataVector().removeAllElements();
    }

    private void timTheoMaNV() {
        String idNV = txtTim.getText();
        if (idNV != null && idNV.trim().length() > 0) {
            try {
                NhanVien nv = listNV.timKiem(idNV);
                if (nv != null) {
                    xoaDuLieuTrongModel();
                    String gt = (nv.getPhai() ? "Nữ" : "Nam");
                    model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gt, nv.getTuoi(),
                            nv.getLuong() });
                } else {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy");
                    return;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ");
                focusTextField(txtTim);
            }
        } else {
            xoaDuLieuTrongModel();
            DocDuLieuVaoModel();
        }
    }

    private Boolean isDouble(JTextField text) {
        try {
            Double.parseDouble(text.getText());
            return true;
        } catch (NumberFormatException e) {
            focusTextField(text);
            return false;
        }
    }

    private Boolean isInt(JTextField text) {
        try {
            Integer.parseInt(text.getText());
            return true;
        } catch (NumberFormatException e) {
            focusTextField(text);
            return false;
        }
    }

    public void focusTextField(JTextField text) {
        text.selectAll();
        text.requestFocus();
    }
}
