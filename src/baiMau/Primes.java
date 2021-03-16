package baiMau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Primes extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtN;
	private JButton buttonGenerate;
	private JTextArea taPrimes;

	public Primes() {
		setTitle("Primes");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();
	}

	private void createGUI() {
		setLayout(null);//Absolute layout
		add(txtN = new JTextField());
		txtN.setBounds(50, 30, 200, 30);
		txtN.setToolTipText("Nhập số nguyên tố cần hiển thị.");

		add(buttonGenerate = new JButton("Generate"));
		buttonGenerate.setBounds(250, 30, 100, 30);

		JScrollPane scroll;
		add(scroll  = new JScrollPane(taPrimes = new JTextArea()));
		scroll.setBounds(50, 70, 300, 170);
		taPrimes.setToolTipText("Danh sách các số nguyên tố.");
		taPrimes.setEditable(false);

		buttonGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				taPrimes.setText("");
				try{
					int n = Integer.parseInt(txtN.getText());
					if(n > 0){
						for(int i = 2; i < Integer.MAX_VALUE; i++){
							if(isPrime(i)){
								n --;
								taPrimes.append(i + "\n");
							}
							if(n == 0)
								break;
						}
					}else{
						JOptionPane.showMessageDialog(null, "Nhập số nguyên dương.");
					}
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
				}
				focus();
			}
			
			private void focus() {
				txtN.selectAll();
				txtN.requestFocus();
				return;
			}

			/**
			 * Kiểm tra 1 số nguyên dương có phải là số nguyên tố
			 * @param n là số cần kiểm tra
			 * @return true nếu n là số nguyên tố, false cho các trư�?ng hợp còn lại	 
			 */
			private boolean isPrime(int n) {
				for(int i = 2; i < n; i++)
					if(n % i == 0)
						return false;
				return true;
			}
		});
	}

	public static void main(String[] args) {
		new Primes().setVisible(true);
	}
}
