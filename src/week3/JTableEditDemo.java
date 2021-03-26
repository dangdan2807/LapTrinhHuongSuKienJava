package week3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class JTableEditDemo extends JFrame implements ActionListener, MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String[] cols = { "Mã Sách", "Tên Sách", "Tác Giả", "Số Lượng", "NXB" };
    private int fontSize = 14;

    JTextField txtMaSach, txtTenSach, txtTacGia, txtSL, txtNXB;
    JButton btnAdd, btnRemove, btnExit, btnLuu;

    DefaultTableModel model;
    JTable table;

    public JTableEditDemo() {
        super("Quản Lý Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        // label
        JLabel lbMaSach = new JLabel("Mã sách: ");
        JLabel lbTenSach = new JLabel("Tên sách: ");
        JLabel lbTacGia = new JLabel("Tác giả: ");
        JLabel lbSL = new JLabel("Số lượng: ");
        JLabel lbNXB = new JLabel("NXB: ");

        // btn
        btnAdd = new JButton("Thêm");
        btnRemove = new JButton("Xoá");
        btnLuu = new JButton("Lưu");
        btnExit = new JButton("Thoát");

        // textField
        txtMaSach = new JTextField(15);
        txtTenSach = new JTextField(15);
        txtTacGia = new JTextField(15);
        txtSL = new JTextField(15);
        txtNXB = new JTextField(15);

        // set font label + btn + textField
        lbMaSach.setFont(new Font("Arial", Font.BOLD, fontSize));
        lbTenSach.setFont(new Font("Arial", Font.BOLD, fontSize));
        lbTacGia.setFont(new Font("Arial", Font.BOLD, fontSize));
        lbSL.setFont(new Font("Arial", Font.BOLD, fontSize));
        lbNXB.setFont(new Font("Arial", Font.BOLD, fontSize));

        btnAdd.setFont(new Font("Arial", Font.BOLD, fontSize));
        btnRemove.setFont(new Font("Arial", Font.BOLD, fontSize));
        btnLuu.setFont(new Font("Arial", Font.BOLD, fontSize));
        btnExit.setFont(new Font("Arial", Font.BOLD, fontSize));

        txtMaSach.setFont(new Font("Arial", Font.BOLD, fontSize));
        txtTenSach.setFont(new Font("Arial", Font.BOLD, fontSize));
        txtTacGia.setFont(new Font("Arial", Font.BOLD, fontSize));
        txtSL.setFont(new Font("Arial", Font.BOLD, fontSize));
        txtNXB.setFont(new Font("Arial", Font.BOLD, fontSize));

        // table
        model = new DefaultTableModel(cols, 0);
        table = new JTable(model);

        //
        JPanel pRow1 = new JPanel();
        JPanel pRow2 = new JPanel();
        JPanel pRow3 = new JPanel();
        JPanel pRow4 = new JPanel();
        JPanel pRow5 = new JPanel();
        JPanel pRow6 = new JPanel();

        pRow1.add(lbMaSach);
        pRow1.add(txtMaSach);
        pRow2.add(lbTenSach);
        pRow2.add(txtTenSach);
        pRow3.add(lbTacGia);
        pRow3.add(txtTacGia);
        pRow4.add(lbSL);
        pRow4.add(txtSL);
        pRow5.add(lbNXB);
        pRow5.add(txtNXB);
        pRow6.add(btnAdd);
        pRow6.add(btnRemove);
        pRow6.add(btnLuu);
        pRow6.add(btnExit);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(pRow1);
        main.add(pRow2);
        main.add(pRow3);
        main.add(pRow4);
        main.add(pRow5);
        main.add(pRow6);

        JSplitPane spl = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		spl.setTopComponent(main);
		spl.setBottomComponent(new JScrollPane(table));
		add(spl);
    }

    public static void main(String[] args) {
        new JTableEditDemo().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    }
}
