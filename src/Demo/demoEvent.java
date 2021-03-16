package Demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class demoEvent extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p;
	private JButton btnRed;
	private JButton btnYellow;
	private JButton btnExit;

	public demoEvent() {
//		hiệu chỉnh Frame
		setTitle("Demo JFrame");
		setSize(300, 250); // set kích thước cửa sổ
		setDefaultCloseOperation(EXIT_ON_CLOSE); // khi tắt thì tắt hẳn luôn sẽ không chạy ngầm
		setLocationRelativeTo(null);

//		Thêm các component vào frame
//		Khai báo 1 panel
		p = new JPanel();
//		gắn panel vào jframe
		this.add(p);

		btnRed = new JButton("Red");
		btnYellow = new JButton("Yellow");
		btnExit = new JButton("Exit");
		

		p.add(btnRed);
		p.add(btnYellow);
		p.add(btnExit);

		btnRed.addActionListener(this);
		btnYellow.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public static void main(String[] args) {
		new demoEvent().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj.equals(btnRed))
			p.setBackground(Color.RED);
		else if(obj.equals(btnYellow))
			p.setBackground(Color.YELLOW);
		else
			System.exit(0);
	}
}
