package week3.JTableEditIO;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.table.*;

public class JTableEditDemo extends JFrame implements ActionListener, MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String[] cols = { "Mã Sách", "Tên Sách", "Số Trang" };

    JTextField txtMaSach, txtTenSach, txtSoTrang;
    JButton btnAdd, btnRemove, btnExit, btnLuu, btnXoaRong;

    DefaultTableModel model;
    JTable table;
    private QuanLySach ds;
    // lấy đường dẫn tới project - ngang cấp src
    String workingDir = System.getProperty("user.dir") + "/src/week3/JTableEditIO/";

    public JTableEditDemo() {
        super("Quản Lý Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        // label
        JLabel lbMaSach = new JLabel("Mã sách: ");
        JLabel lbTenSach = new JLabel("Tên sách: ");
        JLabel lbSL = new JLabel("Số Trang: ");

        // btn
        btnAdd = new JButton("Thêm");
        btnRemove = new JButton("Xoá Dòng");
        btnLuu = new JButton("Lưu");
        btnExit = new JButton("Thoát");
        btnXoaRong = new JButton("Xoá Rỗng");

        // textField
        txtMaSach = new JTextField(25);
        txtTenSach = new JTextField(25);
        txtSoTrang = new JTextField(25);

        // table
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        //
        JPanel pRow1 = new JPanel();
        JPanel pRow2 = new JPanel();
        JPanel pRow3 = new JPanel();
        JPanel pRow4 = new JPanel();

        pRow1.add(lbMaSach);
        pRow1.add(Box.createHorizontalStrut(10));
        pRow1.add(txtMaSach);
        pRow2.add(lbTenSach);
        pRow2.add(Box.createHorizontalStrut(5));
        pRow2.add(txtTenSach);
        pRow3.add(lbSL);
        pRow3.add(Box.createHorizontalStrut(5));
        pRow3.add(txtSoTrang);
        pRow4.add(btnAdd);
        pRow4.add(btnXoaRong);
        pRow4.add(btnRemove);
        pRow4.add(btnLuu);
        pRow4.add(btnExit);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(pRow1);
        main.add(pRow2);
        main.add(pRow3);
        main.add(pRow4);

        JSplitPane spl = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        spl.setTopComponent(main);
        spl.setBottomComponent(new JScrollPane(table));
        add(spl);

        // Sự kiện

        // kiểm tra và tạo file data
        File f = new File(workingDir + "data");
        if (!f.exists()) {
            f.mkdirs();
        }

        LuuTru data = new LuuTru();
        ds = new QuanLySach();
        try {
            ds = (QuanLySach) data.DocFile(workingDir + "data/dsSach.txt");
            System.out.println(ds.getSize());
            for (int i = 0; i < ds.getSize(); i++) {
                Sach sach = ds.getElement(i);
                model.addRow(new Object[] { sach.getMaSach(), sach.getTenSach(), sach.getSoTrang() });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnExit.addActionListener(this);
        btnLuu.addActionListener(this);
        btnXoaRong.addActionListener(this);

        table.addMouseListener(this);
    }

    public static void main(String[] args) {

        new JTableEditDemo().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        // lay dong dang chon tren table
        txtMaSach.setText(table.getValueAt(row, 0).toString());
        txtTenSach.setText(table.getValueAt(row, 1).toString());
        txtSoTrang.setText(table.getValueAt(row, 2).toString());
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
        if (o.equals(btnExit)) {
            System.exit(0);
        } else if (o.equals(btnAdd)) {
            if (txtMaSach.getText().equals("") || txtTenSach.getText().equals("") || txtSoTrang.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Phải nhập dữ liệu trước.", "Thông báo", JOptionPane.YES_NO_OPTION);
            } else {
                if (isInt(txtSoTrang)) {
                    int num = Integer.parseInt(txtSoTrang.getText());
                    if (num >= 0) {
                        Sach sach = new Sach(txtMaSach.getText(), txtTenSach.getText(), num);
                        ds.themSach(sach);
                        model.addRow(new Object[] { txtMaSach.getText(), txtTenSach.getText(), num });
                    } else {
                        JOptionPane.showMessageDialog(this, "Số lượng trang sách phải là số nguyên dương.", "thông báo",
                                JOptionPane.OK_OPTION);
                        focusTextField(txtSoTrang);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Số lượng sách phải là số nguyên dương", "thông báo",
                            JOptionPane.OK_OPTION);
                    focusTextField(txtSoTrang);
                }
            }
        } else if (o.equals(btnRemove)) {
            if (table.getSelectedRow() == -1)
                JOptionPane.showMessageDialog(this, "Phải chọn dòng cần xoá.");
            else {
                int tl;
                tl = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá dòng này", "Cảnh báo",
                        JOptionPane.YES_NO_OPTION);
                if (tl == JOptionPane.YES_OPTION) {
                    // xoá dữ liệu trong danh sách đã lưu
                    ds.xoaSach(table.getSelectedRow());
                    // XOA dong dang chon trong table
                    model.removeRow(table.getSelectedRow());
                }
            }
        } else if (o.equals(btnXoaRong)) {
            txtMaSach.setText("");
            txtTenSach.setText("");
            txtSoTrang.setText("");
        } else if (o.equals(btnLuu)) {
            LuuTru lt = new LuuTru();
            try {
                lt.LuuFile(ds, workingDir + "data/dsSach.txt");
                System.out.println("done");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    // kiểm tra số nguyên
    private boolean isInt(JTextField text) {
        boolean result = true;
        try {
            Integer.parseInt(text.getText());
        } catch (NumberFormatException ex) {
            result = false;
        }
        return result;
    }

    private void focusTextField(JTextField text) {
        text.selectAll();
        text.requestFocus();
    }
}