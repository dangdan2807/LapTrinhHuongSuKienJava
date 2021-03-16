package baiMau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MayTinh extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buttonGiai;
	private JButton buttonXoa;
	private JButton buttonThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtKQ;
	private JRadioButton radCong;
	private JRadioButton radTru;
	private JRadioButton radNhan;
	private JRadioButton radChia;

	public MayTinh() {
		setTitle("Cộng - Trừ - Nhân - Chia");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
	}

	private void createGUI() {
		//Ta thấy Form chia 4 phần: North, West, South và Center
		JPanel panelNorth, panelWest, panelSouth, panelCenter, panelCenterCenter;

		//Phần North
		panelNorth = new JPanel();
		add(panelNorth, BorderLayout.NORTH);

		panelNorth.setPreferredSize(new Dimension(0, 50)); //Chi�?u cao là 50
		JLabel lblTieuDe;
		panelNorth.add(lblTieuDe = new JLabel("Cộng Trừ Nhân Chia"));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 24));
		lblTieuDe.setForeground(Color.blue);

		//Phần South - ta chuẩn bị 1 hình ảnh
		add(panelSouth = new JPanel(), BorderLayout.SOUTH);
		panelSouth.setPreferredSize(new Dimension(0, 50));
		panelSouth.setBackground(Color.PINK);
		panelSouth.add(new JLabel(new ImageIcon("images/hinhBai3Tuan01.png")));

		//Phần West
		add(panelWest = new JPanel(), BorderLayout.WEST);
		panelWest.setBorder(BorderFactory.createTitledBorder("Ch�?n tác vụ"));
		panelWest.setPreferredSize(new Dimension(100, 0));
		panelWest.setBackground(Color.lightGray);
		//�?ể kích thước của các JButton bằng nhau, ta ch�?n layout cho panelWest là 
		//Absolute layout, sau đó cho kích thước của các JButton bằng nhau
		panelWest.setLayout(null);
		panelWest.add(buttonGiai = new JButton("Giải"));
		panelWest.add(buttonXoa = new JButton("Xóa"));
		panelWest.add(buttonThoat = new JButton("Thoát"));

		buttonGiai.setMnemonic(KeyEvent.VK_G); //Phím tắt kết hợp phím Alt
		buttonXoa.setMnemonic(KeyEvent.VK_X);
		buttonThoat.setMnemonic(KeyEvent.VK_T);

		//Xác định vị trí và kích thước để đặt các nút này vào West
		buttonGiai.setBounds(10, 20, 80, 30);//x = 10, y = 20, Width = 80, Height = 30
		buttonXoa.setBounds(10, 60, 80, 30); //y + 40
		buttonThoat.setBounds(10, 100, 80, 30);

		//Phần Center
		add(panelCenter = new JPanel(), BorderLayout.CENTER);
		//Tương tự, cô dùng Absolute layout cho phần Center
		panelCenter.setLayout(null);
		panelCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));

		JLabel lblA, lblB, lblKQ;
		panelCenter.add(lblA = new JLabel("Nhập a: "));
		panelCenter.add(lblB = new JLabel("Nhập b: "));
		panelCenter.add(lblKQ = new JLabel("Kết quả: "));

		panelCenter.add(txtA = new JTextField());
		panelCenter.add(txtB = new JTextField());
		panelCenter.add(txtKQ = new JTextField());

		//Thêm 1 panel cho các JRadioButton
		panelCenter.add(panelCenterCenter = new JPanel());
		panelCenterCenter.add(radCong = new JRadioButton("Cộng"));
		panelCenterCenter.add(radTru = new JRadioButton("Trừ"));
		panelCenterCenter.add(radNhan = new JRadioButton("Nhân"));
		panelCenterCenter.add(radChia = new JRadioButton("Chia"));
		panelCenterCenter.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		panelCenterCenter.setLayout(new GridLayout(2, 2)); //2 dòng, 2 cột = 4 ô

		//Xác định vị trí đặt các components này
		lblA.setBounds(50, 20, 50, 30);
		lblB.setBounds(50, 60, 50, 30);
		lblKQ.setBounds(50, 220, 50, 30);

		txtA.setBounds(100, 20, 250, 30);
		txtB.setBounds(100, 60, 250, 30);
		txtKQ.setBounds(100, 220, 250, 30);

		panelCenterCenter.setBounds(100, 100, 250, 100);

		//�?ối với JRadioButton, mỗi lần chỉ ch�?n được 1, nên ta đưa chúng vào 1 group
		ButtonGroup group = new ButtonGroup();
		group.add(radChia);
		group.add(radCong);
		group.add(radTru);
		group.add(radNhan);
		radCong.setSelected(true);//Default ch�?n JRadioButton cộng

		txtKQ.setEditable(false);
		//Xong phần thiết kế giao diện

		//Xử lý sự kiện
		buttonGiai.addActionListener(this);
		buttonXoa.addActionListener(this);
		buttonThoat.addActionListener(this);
	}

	public static void main(String[] args) {
		new MayTinh().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(buttonThoat))
			System.exit(0);
		else if(o.equals(buttonXoa)){
			txtA.setText("");
			txtB.setText("");
			txtKQ.setText("");
			radCong.setSelected(true);
			txtA.requestFocus();
		}else if(o.equals(buttonGiai)){
			if(!isInt(txtA.getText()))
				focus(txtA);
			else if(!isInt(txtB.getText()))
				focus(txtB);
			else{
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				double kq = 0.0;
				if(radCong.isSelected()) //Nút cộng được chon
					kq = a + b;
				else if(radTru.isSelected())
					kq = a - b;
				else if(radNhan.isSelected())
					kq = a * b;
				else if(radChia.isSelected())
					if(b != 0)
						kq = a / (double)b;
					else
						focus(txtB);
				txtKQ.setText(kq + "");
			}
		}
	}

	private void focus(JTextField text) {
		JOptionPane.showMessageDialog(this, "Lỗi nhập liệu " + text.getText());
		text.selectAll();
		text.requestFocus();
		return;
	}

	private boolean isInt(String text) {
		try{
			Integer.parseInt(text);
		}catch(NumberFormatException ex){
			return false;
		}
		return true;
	}

}
