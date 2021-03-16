package Demo;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

public class JCheckBoxDemo extends JFrame implements ItemListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JTextField text;
    private JCheckBox chkBold;
    private JCheckBox chkItalic;

    public JCheckBoxDemo() {
        // cấu hình
        setTitle("JCheckBox Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 110);
        // setResizable(false);
        setLocationRelativeTo(null);

        Box boxVertical = Box.createVerticalBox();
        Box boxHorizontal1 = Box.createHorizontalBox();
        Box boxHorizontal2 = Box.createHorizontalBox();

        text = new JTextField();
        text.setText("watch the font style change");

        chkBold = new JCheckBox("Bold");
        chkItalic = new JCheckBox("italic");

        boxHorizontal1.add(Box.createHorizontalStrut(10));
        boxHorizontal1.add(text);
        boxHorizontal1.add(Box.createHorizontalStrut(10));

        boxHorizontal2.add(chkBold);
        boxHorizontal2.add(chkItalic);
        boxVertical.add(boxHorizontal1);
        boxVertical.add(boxHorizontal2);
        this.add(boxVertical, BorderLayout.NORTH);

        chkBold.addItemListener(this);
        chkItalic.addItemListener(this);
    }

    public static void main(String[] args) {
        new JCheckBoxDemo().setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        Object obj = e.getSource();
        Font f = text.getFont();
        if (obj == chkBold) {

            text.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));
        } else if (obj == chkItalic) {
            text.setFont(f.deriveFont(f.getStyle() ^ Font.ITALIC));
        }

    }

}
