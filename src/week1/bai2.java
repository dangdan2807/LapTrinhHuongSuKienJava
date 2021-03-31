package week1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai2 extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField text;
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
        pnMain.add(pnNorth, BorderLayout.NORTH);

        text = new JTextField(40);
        btnGeneral = new JButton("General");
        pnNorth.add(text);
        pnNorth.add(btnGeneral);

        // Center panel
        JPanel pnCenter = new JPanel();
        pnMain.add(pnCenter);

        jList = new JTextArea(14, 50);
        jList.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        pnCenter.add(jList);

        // Thêm vào giao diện
        this.add(pnMain);
        btnGeneral.addActionListener(this);
    }

    // sàng số nguyên tố
    public boolean isPrime(int n) {
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
            jList.setText("");
            try {
                int n = Integer.parseInt(text.getText());
                if (n > 0) {
                    int i = 2;
                    while (n > 0) {
                        if (isPrime(i)) {
                            jList.append(i + "\n");
                            n--;
                        }
                        i++;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nhập số nguyên dương.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
            }
        }
        focusTextField();
    }

    private void focusTextField() {
        text.selectAll();
        text.requestFocus();
        return;
    }
}
