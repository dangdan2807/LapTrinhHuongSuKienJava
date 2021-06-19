package onThi.src.GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import onThi.src.DAO.*;
import onThi.src.entity.*;

public class FrmLopHoc extends JFrame implements ActionListener, MouseListener {

	private JTextField txtMaLop;
	private JTextField txtTenLop;
	private JTextField txtSiSo;
	private JComboBox<String> cboGVCN;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnTimGV, btnTimLop;
	private DefaultTableModel dataModel;
	private JTable table;

	public FrmLopHoc() {
		setTitle("Thông tin lớp học");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Box b, b1, b2, b3, b4, b44, b5, b6, b7;
		// Dùng Box layout
		add(b = Box.createVerticalBox()); // Box theo chiều dọc
		b.add(Box.createVerticalStrut(10)); // Tạo khoảng cách theo chiều dọc
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10)); // b1 -> b7: Box theo chiều ngang
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b44 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));

		JLabel lblTieuDe, lblMaLop, lblTenLop, lblGVCN, lblSiSo;
		b1.add(lblTieuDe = new JLabel("THÔNG TIN LỚP HỌC", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 26));

		b2.add(lblMaLop = new JLabel("Mã lớp: ", JLabel.RIGHT));
		b2.add(txtMaLop = new JTextField());
		b3.add(lblTenLop = new JLabel("Tên lớp: ", JLabel.RIGHT));
		b3.add(txtTenLop = new JTextField());
		b4.add(lblGVCN = new JLabel("Giáo viên chủ nhiệm: ", JLabel.RIGHT));
		b4.add(cboGVCN = new JComboBox<String>());
		cboGVCN.setEditable(false);
		b44.add(lblSiSo = new JLabel("Sỉ số : ", JLabel.RIGHT));
		b44.add(txtSiSo = new JTextField());

		lblMaLop.setPreferredSize(lblGVCN.getPreferredSize());
		lblTenLop.setPreferredSize(lblGVCN.getPreferredSize());
		lblSiSo.setPreferredSize(lblGVCN.getPreferredSize());

		b5.add(btnThem = new JButton("Thêm"));
		b5.add(btnXoaRong = new JButton("Làm mới"));
		b5.add(btnSua = new JButton("Sửa"));
		b5.add(btnXoa = new JButton("Xóa"));
		b5.add(btnTimGV = new JButton("Tìm theo mã giáo viên"));
		b5.add(btnTimLop = new JButton("Tìm theo mã lớp"));

		String[] headers = { "Mã lớp", "Tên lớp", "Giáo viên CN", "Sỉ số" };
		dataModel = new DefaultTableModel(headers, 0);
		JScrollPane scroll;
		b6.add(scroll = new JScrollPane(table = new JTable(dataModel)));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học"));

		b7.add(Box.createHorizontalStrut(600));

		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimGV.addActionListener(this);
		btnTimLop.addActionListener(this);

		// Khi chương trình chạy, nạp toàn bộ danh sách lớp học lên
		// bảng
		loadCbo();
		docDuLieuVaoTable(LopHocDAO.getInstance().getLopHocList());

		table.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (ValidData()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					LopHoc lp = getDataInForm();
					boolean re = LopHocDAO.getInstance().insert(lp);
					if (re) {
						dataModel.addRow(new Object[] { lp.getMaLop(), lp.getTenLop(),
								lp.getGiaoVien().getTenGiaoVien(), lp.getSiSo() });
						dataModel.fireTableDataChanged();
						JOptionPane.showMessageDialog(this, "Thêm lớp học thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Thêm lớp học that bai");
					}

				} else {
					JOptionPane.showMessageDialog(this, "Chon 1 dong can xoa");
				}
			}
		} else if (o.equals(btnXoaRong)) {
			xoaRongTextFields();
		} else if (o.equals(btnSua)) {
			if (ValidData()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					LopHoc lp = getDataInForm();
					boolean re = LopHocDAO.getInstance().update(lp);
					if (re) {
						table.setValueAt(lp.getMaLop(), row, 0);
						table.setValueAt(lp.getTenLop(), row, 1);
						table.setValueAt(lp.getGiaoVien().getTenGiaoVien(), row, 2);
						table.setValueAt(lp.getSiSo(), row, 3);
						dataModel.fireTableDataChanged();
						JOptionPane.showMessageDialog(this, "cap nhat lớp học thành công");
					} else {
						JOptionPane.showMessageDialog(this, "cap nhat lớp học that bai");
					}

				}
			} else {
				JOptionPane.showMessageDialog(this, "Chon 1 dong can xoa");
			}
		} else if (o.equals(btnXoa)) {
			if (ValidData()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					LopHoc lp = getDataInForm();
					boolean re = LopHocDAO.getInstance().delete(lp.getMaLop());
					if (re) {
						dataModel.removeRow(row);
						dataModel.fireTableDataChanged();
						JOptionPane.showMessageDialog(this, "xoa lớp học thành công");
					} else {
						JOptionPane.showMessageDialog(this, "xoa lớp học that bai");
					}

				}
			} else {
				JOptionPane.showMessageDialog(this, "Chon 1 dong can xoa");
			}
		} else if (o.equals(btnTimLop)) {
			if (txtMaLop.getText().trim().length() > 0) {
				String maLop = txtMaLop.getText().trim();
				ArrayList<LopHoc> dataList = LopHocDAO.getInstance().getLopHocListByID(maLop);
				dataModel.getDataVector().removeAllElements();
				docDuLieuVaoTable(dataList);

			} else {
				JOptionPane.showMessageDialog(this, "nhập mã Lop");
				txtMaLop.requestFocus();
				txtMaLop.selectAll();
			}
		} else if (o.equals(btnTimGV)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				String tenGV = cboGVCN.getSelectedItem().toString();
				String maGiaoVien = GiaoVienDAO.getInstance().getGiaoVienIDByName(tenGV);
				ArrayList<LopHoc> dataList = LopHocDAO.getInstance().getLopHocListByGiaoVienID(maGiaoVien);
				dataModel.getDataVector().removeAllElements();
				docDuLieuVaoTable(dataList);
			}
		}
	}

	private void xoaRongTextFields() {
		txtMaLop.setText("");
		txtTenLop.setText("");
		cboGVCN.setSelectedItem(null);
		txtSiSo.setText("");
		txtMaLop.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaLop.setText(dataModel.getValueAt(row, 0).toString());
		txtTenLop.setText(dataModel.getValueAt(row, 1).toString());
		cboGVCN.setSelectedItem(dataModel.getValueAt(row, 2).toString());
		txtSiSo.setText(dataModel.getValueAt(row, 3).toString());
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

	private void docDuLieuVaoTable(ArrayList<LopHoc> dataList) {
		for (LopHoc item : dataList) {
			dataModel.addRow(new Object[] { item.getMaLop(), item.getTenLop(), item.getGiaoVien().getTenGiaoVien(),
					item.getSiSo() });
		}
	}

	private void loadCbo() {
		ArrayList<GiaoVien> dataList = GiaoVienDAO.getInstance().getGiaoVienList();
		for (GiaoVien item : dataList) {
			cboGVCN.addItem(item.getTenGiaoVien());
		}
	}

	private boolean ValidData() {
		String maLop = txtMaLop.getText().trim();
		if (!(maLop.length() > 0)) {
			JOptionPane.showMessageDialog(this, "mã lớp không được rống");
			return false;
		}

		String tenLop = txtTenLop.getText().trim();
		if (!(tenLop.length() > 0)) {
			JOptionPane.showMessageDialog(this, "tên lớp không được rống");
			return false;
		}
		String siSoStr = txtSiSo.getText().trim();
		if (siSoStr.length() > 0) {
			try {
				int siSo = Integer.parseInt(siSoStr);
				if (siSo < 0) {
					JOptionPane.showMessageDialog(this, "si so lop hoc phai > 0");
					return false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "si so lop hoc phai la so");
				return false;
			}
		}
		return true;
	}

	public LopHoc getDataInForm() {
		String maLop = txtMaLop.getText().trim();
		String tenLop = txtTenLop.getText().trim();
		int siSo = Integer.parseInt(txtSiSo.getText().trim());
		String tenGV = cboGVCN.getSelectedItem().toString();
		String maGV = GiaoVienDAO.getInstance().getGiaoVienIDByName(tenGV);
		GiaoVien giaoVien = new GiaoVien(maGV, tenGV);
		return new LopHoc(maLop, tenLop, giaoVien, siSo);
	}
}
