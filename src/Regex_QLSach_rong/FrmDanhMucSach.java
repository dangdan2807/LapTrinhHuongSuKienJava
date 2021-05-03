package Regex_QLSach_rong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmDanhMucSach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboMaSach;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;

	// private SachTableModel tableModel;
	private DefaultTableModel tableModel;
	private JButton btnLoc;

	public FrmDanhMucSach() {
		setTitle("Quáº£n lÃ½ sÃ¡ch");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// Pháº§n North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		pnlNorth.add(lblMaSach = new JLabel("MÃ£ sÃ¡ch: "));
		pnlNorth.add(lblTuaSach = new JLabel("Tá»±a sÃ¡ch: "));
		pnlNorth.add(lblTacGia = new JLabel("TÃ¡c giáº£: "));
		pnlNorth.add(lblNamXB = new JLabel("NÄƒm xuáº¥t báº£n: "));
		pnlNorth.add(lblNhaXB = new JLabel("NhÃ  xuáº¥t báº£n: "));
		pnlNorth.add(lblSoTrang = new JLabel("Sá»‘ trang: "));
		pnlNorth.add(lblDonGia = new JLabel("Ä�Æ¡n giÃ¡: "));
		pnlNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

		pnlNorth.add(txtMaSach = new JTextField());
		pnlNorth.add(txtTuaSach = new JTextField());
		pnlNorth.add(txtTacGia = new JTextField());
		pnlNorth.add(txtNamXB = new JTextField());
		pnlNorth.add(txtNhaXB = new JTextField());
		pnlNorth.add(txtSoTrang = new JTextField());
		pnlNorth.add(txtDonGia = new JTextField());
		pnlNorth.add(txtISBN = new JTextField());

		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaSach.setBounds(20, 20, w1, h);
		txtMaSach.setBounds(120, 20, 200, h);

		lblTuaSach.setBounds(20, 45, w1, h);
		txtTuaSach.setBounds(120, 45, w2, h);
		lblTacGia.setBounds(450, 45, w1, h);
		txtTacGia.setBounds(570, 45, w2, h);

		lblNamXB.setBounds(20, 70, w1, h);
		txtNamXB.setBounds(120, 70, w2, h);
		lblNhaXB.setBounds(450, 70, w1, h);
		txtNhaXB.setBounds(570, 70, w2, h);

		lblSoTrang.setBounds(20, 95, w1, h);
		txtSoTrang.setBounds(120, 95, w2, h);
		lblDonGia.setBounds(450, 95, w1, h);
		txtDonGia.setBounds(570, 95, w2, h);

		lblISBN.setBounds(20, 120, 220, h);
		txtISBN.setBounds(240, 120, 180, h);
		txtMess.setBounds(20, 145, 550, 20);

		// Pháº§n Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("ThÃªm"));
		pnlCenter.add(btnXoaRong = new JButton("XÃ³a rá»—ng"));
		pnlCenter.add(btnXoa = new JButton("XÃ³a"));
		pnlCenter.add(btnSua = new JButton("Sá»­a"));
		pnlCenter.add(btnLuu = new JButton("LÆ°u"));
		pnlCenter.add(new JLabel("TÃ¬m theo mÃ£ sÃ¡ch: "));
		pnlCenter.add(cboMaSach = new JComboBox<String>());
		cboMaSach.setPreferredSize(new Dimension(100, 25));
		pnlCenter.add(btnLoc = new JButton("Lá»�c theo tá»±a sÃ¡ch"));

		// Pháº§n South
		JScrollPane scroll;
		// String[] headers =
		// "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");

		// tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sÃ¡ch cÃ¡c cuá»‘n sÃ¡ch"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		cboMaSach.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLoc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {

		} else if (o.equals(btnXoaRong)) {
			
		}
	}

	public static void main(String[] args) {
		FrmDanhMucSach frm = new FrmDanhMucSach();
		frm.setVisible(true);
	}
}
