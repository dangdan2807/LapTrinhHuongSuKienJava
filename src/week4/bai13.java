package week4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class bai13 extends JFrame implements ActionListener{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Box bChinh;
	private Box bRow1;
	private Box bRow2;
	private JLabel label1;
	private JLabel label2;
	private double doF;
	private double doC;
	private JTextField text1;
	private JPanel p;

	public bai13() {
		setTitle("Fahrenheit");
		setSize(400, 150); // set kích thước cửa sổ
		setDefaultCloseOperation(EXIT_ON_CLOSE); // khi tắt thì tắt hẳn luôn sẽ không chạy ngầm
		setLocationRelativeTo(null);
		setResizable(false);
		
		p = new JPanel();
		this.add(p);
		
		doF = 0;
		doC = 0;
		
		label1 = new JLabel("Enter Fahrenheit temperature: ");
		label1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		label2 = new JLabel("Temperature in Celsius: " + doC);
		label2.setFont(new Font("Arial", Font.PLAIN, 18));
		
		text1 = new JTextField(4);
		text1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		bChinh = Box.createVerticalBox();
		bRow1 = Box.createHorizontalBox();
		bRow2 = Box.createHorizontalBox();
		
		p.add(label1);
		p.add(text1);

		bRow1.add(p);
		bRow2.add(label2);
		
		bChinh.add(Box.createRigidArea(new Dimension(10, 10)));
		bChinh.add(bRow1);
		bChinh.add(Box.createRigidArea(new Dimension(10, 10)));
		bChinh.add(bRow2);
		
		text1.addActionListener(this);
		
		this.add(bChinh, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new bai13().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(text1))
		{
			doF = Integer.parseInt(text1.getText());
			doC = (doF - 32) * 5 / 9;
			label2.setText("Temperature in Celsius: " + doC);
		}
	}
}
