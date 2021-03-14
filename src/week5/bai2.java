package week5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai2 extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField tfText1;
    private JButton btnGeneral;
    private JTextArea jList;

    public bai2() {
        setTitle("Primes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 320);
        setLocationRelativeTo(null);
        setResizable(false);
        // Main panel
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        // North panel
        JPanel pnNorth = new JPanel();
        pnNorth.add(Box.createRigidArea(new Dimension(0, 40)));
        pnMain.add(pnNorth, BorderLayout.NORTH);
        
        tfText1 = new JTextField();
        tfText1.setPreferredSize(new Dimension(330, 30));
        tfText1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGeneral = new JButton("General");
        btnGeneral.setPreferredSize(new Dimension(100, 30));
        pnNorth.add(tfText1);
        pnNorth.add(btnGeneral);

        // Center panel
        JPanel pnCenter = new JPanel();
        pnCenter.add(Box.createRigidArea(new Dimension(5, 5)));
        pnMain.add(pnCenter);

        jList = new JTextArea(10, 1);
        jList.setPreferredSize(new Dimension(435, 10));
        jList.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        jList.setFont(new Font("Arial", Font.PLAIN, 14));
        pnCenter.add(jList);

        // Thêm vào giao diện
        this.add(pnMain);
        btnGeneral.addActionListener(this);
    }

    // sàng số nguyên tố
    public boolean isPrimary(int n) {
        if (n == 2 || n == 3 || n == 5)
            return true;
        if (n % 2 == 0 || n % 5 == 0 || n % 3 == 0 || n < 2)
            return false;
        if (n < 49)
            return true;
        if (n % 7 == 0 || n % 11 == 0 || n % 13 == 0 || n % 17 == 0 || n % 19 == 0 || n % 23 == 0 || n % 29 == 0
                || n % 31 == 0 || n % 37 == 0 || n % 41 == 0 || n % 43 == 0 || n % 47 == 0)
            return false;
        if (n < 2809)
            return true;
        long maxRange = (int) (Math.sqrt(n) + 1);
        for (int i = 53; i < maxRange; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new bai2().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj.equals(btnGeneral)) {
            if (tfText1.getText().equalsIgnoreCase(""))
                JOptionPane.showConfirmDialog(null, "Thiếu tham số đầu vào", "Thông báo", JOptionPane.ERROR_MESSAGE);
            else {
                int n = Integer.parseInt((tfText1.getText()));
                if (isPrimary(n) == true) {
                    jList.append(String.valueOf(n) + "\n");
                    tfText1.setText("");
                } else {
                    JOptionPane.showConfirmDialog(null, n + " Không là phải số nguyên tố", "Thông báo",
                            JOptionPane.WARNING_MESSAGE);
                    tfText1.setText("");
                }
            }
        }
    }
}
