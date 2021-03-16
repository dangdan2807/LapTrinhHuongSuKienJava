package Demo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class bai16 extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel, p1, p2, p3, p4, p5, p6, p7, p8;

	public bai16() {
		setTitle("Border Demo");
		setSize(500, 500); // set kích thước cửa sổ
		setDefaultCloseOperation(EXIT_ON_CLOSE); // khi tắt thì tắt hẳn luôn sẽ không chạy ngầm
		setLocationRelativeTo(null);
//		setResizable(false);

		panel = new JPanel();
//		set layout có 0 hàng, 2 cột, chiều dọc: 5, chiều ngang 10
		panel.setLayout(new GridLayout(0, 2, 5, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		this.add(panel);

		p1 = new JPanel();
		Border lineBorder = BorderFactory.createLineBorder(Color.red, 3);
		p1.setBorder(lineBorder);
		p1.add(new JLabel("Line Border"));
		panel.add(p1);

		p2 = new JPanel();
		Border etchedBorder = BorderFactory.createEtchedBorder();
		p2.setBorder(etchedBorder);
		p2.add(new JLabel("Etched Border"));
		panel.add(p2);

		p3 = new JPanel();
		p3.setBorder(BorderFactory.createRaisedBevelBorder());
		p3.add(new JLabel("Raised Bevel Border"));
		panel.add(p3);

		p4 = new JPanel();
		p4.setBorder(BorderFactory.createLoweredBevelBorder());
		p4.add(new JLabel("Lowered Bevel Border"));
		panel.add(p4);

		p5 = new JPanel();
		p5.setBorder(BorderFactory.createTitledBorder("Title"));
		p5.add(new JLabel("Titled Border"));
		panel.add(p5);
		
		p6 = new JPanel();
		TitledBorder titledP6 = BorderFactory.createTitledBorder("Title");
		titledP6.setTitleJustification(TitledBorder.RIGHT);
		p6.setBorder(titledP6);
		p6.add(new JLabel("Titled Border (right)"));
		panel.add(p6);
		
		p7 = new JPanel();
		p7.setBorder(BorderFactory.createCompoundBorder(lineBorder, etchedBorder));
		p7.add(new JLabel("Compound Border"));
		panel.add(p7);
		
		p8 = new JPanel();
		p8.setBorder(BorderFactory.createMatteBorder(2, 5, 2, 2, Color.red));
		p8.add(new JLabel("Matte Border"));
		panel.add(p8);
	}

	public static void main(String[] args) {
		new bai16().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
