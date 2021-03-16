package Demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class demoEvent2 extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;

	public demoEvent2() {
//		hiệu chỉnh Frame
		setTitle("Demo JFrame");
		setSize(300, 250); // set kích thước cửa sổ
		setDefaultCloseOperation(EXIT_ON_CLOSE); // khi tắt thì tắt hẳn luôn sẽ không chạy ngầm
		setLocationRelativeTo(null);
//		setResizable(false);

//		Thêm các component vào frame
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		txtUser = new JTextField(15);
		txtPassword = new JTextField(15);

		Box bChinh = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();

		b1.add(new JLabel("User name: "));
		b1.add(txtUser);

		b2.add(new JLabel("Password: "));
		b2.add(txtPassword);

		b3.add(btnLogin);
		b3.add(btnExit);
		
		bChinh.add(Box.createRigidArea(new Dimension(10, 10)));
		bChinh.add(b1);
		bChinh.add(Box.createRigidArea(new Dimension(10, 10)));
		bChinh.add(b2);
		bChinh.add(Box.createRigidArea(new Dimension(10, 10)));
		bChinh.add(b3);
		
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);

		this.add(bChinh, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new demoEvent2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj.equals(btnLogin))
			if (txtPassword.getText().equalsIgnoreCase("123"))
				JOptionPane.showMessageDialog(this, "Dung password");
			else
				JOptionPane.showMessageDialog(this, "Sai password");
		else
			System.exit(0);
	}
}
