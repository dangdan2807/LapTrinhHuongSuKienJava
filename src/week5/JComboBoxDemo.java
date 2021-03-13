package week5;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class JComboBoxDemo extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JComboBox cboFont;
    private JLabel lblTitle;

    public JComboBoxDemo() {
        // cấu hình
        setTitle("checkbox event");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        // setResizable(false);
        setLocationRelativeTo(null);

        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        lblTitle = new JLabel("the quick brown fox jumps over the lazy dog");
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 12));

        cboFont = new JComboBox();
        cboFont.addItem("Serif");
        cboFont.addItem("SansSerif");
        cboFont.addItem("Monospaced");

        b1.add(lblTitle);

        b2.add(Box.createHorizontalStrut(10));
        b2.add(cboFont);
        b2.add(Box.createHorizontalStrut(10));

        b.add(Box.createVerticalStrut(20));
        b.add(b1);
        b.add(Box.createVerticalStrut(10));
        b.add(b2);
        this.add(b, BorderLayout.NORTH);

        cboFont.addActionListener(this);
    }

    public static void main(String[] args) {
        new JComboBoxDemo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object choice = cboFont.getSelectedItem();
        lblTitle.setFont(new Font(choice.toString(), Font.PLAIN, 12));
    }
}
