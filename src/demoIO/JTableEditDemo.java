package demoIO;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableEditDemo extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] cols = { "masv", "Ho", "Ten" };
	DefaultTableModel model;
	JTable table;

	JTextField txtHo, txtTen, txtMassv;
	JButton btnAdd, btnRemove, btnExit, btnLuu;
	String url = "C:/Users/Admin/Desktop/dangdan/Workspace/java/BaiTap/src/demoIO/";
	DanhSachSinhVien ds;

	public JTableEditDemo() {
		super("Edit Table");

		// CREATE TABLE FOR EDIT
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		// add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel p0 = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p0.add(new JLabel("Ms: "));
		p0.add(txtMassv = new JTextField(15));
		p1.add(new JLabel("Ho: "));
		p1.add(txtHo = new JTextField(15));
		p2.add(new JLabel("Ten:"));
		p2.add(txtTen = new JTextField(15));
		p3.add(btnAdd = new JButton("Them"));
		p3.add(btnRemove = new JButton("Xoa"));
		p3.add(btnLuu = new JButton("Lưu"));
		p3.add(btnExit = new JButton("Thoat"));

		Box b = Box.createVerticalBox();
		b.add(p0);
		b.add(p1);
		b.add(p2);
		b.add(p3);
		JPanel p = new JPanel();
		p.add(b);
		// add(p, BorderLayout.NORTH);

		JSplitPane spl = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		spl.setTopComponent(p);
		spl.setBottomComponent(new JScrollPane(table));
		add(spl);

		LuuTru lt = new LuuTru();
		ds = new DanhSachSinhVien();
		try {
			ds = (DanhSachSinhVien) lt.DocFile(url + "data/dsSvien.txt");
			System.out.println(ds.getSize());
			for (int i = 0; i < ds.getSize(); i++) {
				SinhVien sv = ds.getElement(i);
				model.addRow(new Object[] { sv.getMssv(), sv.getHo(), sv.getTen() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnExit.addActionListener(this);
		btnLuu.addActionListener(this);

		table.addMouseListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			if (txtHo.getText().equals("") || txtTen.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Phai nhap du lieu truoc.");
			else {

				SinhVien sv = new SinhVien(txtMassv.getText(), txtHo.getText(), txtTen.getText());
				ds.themSinhVien(sv);
				model.addRow(new Object[] { txtMassv.getText(), txtHo.getText(), txtTen.getText() });

			}
		} else if (o.equals(btnRemove)) {
			if (table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phai chon dong can xoa.");
			else {
				int tl;
				tl = JOptionPane.showConfirmDialog(this, "Ban co muon xoa dong nay khong?", "Canh bao",
						JOptionPane.YES_NO_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					// XOA dong dang chon trong table
					model.removeRow(table.getSelectedRow());
				}
			}
		} else if (o.equals(btnExit))
			System.exit(0);
		else if (o.equals(btnLuu)) {
			LuuTru lt = new LuuTru();
			try {
				lt.LuuFile(ds, url + "data/dsSVien.txt");
				System.out.println("done");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		// lay dong dang chon tren table
		txtMassv.setText(table.getValueAt(row, 0).toString());
		txtHo.setText(table.getValueAt(row, 1).toString());
		txtTen.setText(table.getValueAt(row, 2).toString());
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public static void main(String arg[]) {
		new JTableEditDemo();
	}
}
