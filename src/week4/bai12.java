package week4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class bai12 extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnPushMe;
	private int count;
	private JLabel label;
	private JPanel p;

	public bai12() {
//		hiệu chỉnh Frame
		setTitle("Push Counter");
		setSize(400, 120); // set kích thước cửa sổ
		setDefaultCloseOperation(EXIT_ON_CLOSE); // khi tắt thì tắt hẳn luôn sẽ không chạy ngầm
		setLocationRelativeTo(null);
		setResizable(false);
		
//		Thêm các component vào frame
		count = 0;
		btnPushMe = new JButton("PushMe");
		btnPushMe.setFont(new Font("Arial", Font.PLAIN, 18));
		
		label = new JLabel(" Pushes: " + count);
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setForeground(Color.decode("#2a5b53"));
		
		p = new JPanel();
		this.add(p);
		p.setBackground(Color.decode("#9dc9d3"));
		
		p.add(btnPushMe);
		p.add(label);
		
		btnPushMe.addActionListener(this);
	}

	public static void main(String[] args) {
		new bai12().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj.equals(btnPushMe))
		{
			++count;
			label.setText(" Pushes: " + count);
		}
	}
}
