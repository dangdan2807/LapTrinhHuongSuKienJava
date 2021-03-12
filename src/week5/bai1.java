package week5;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class bai1 extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel ltlTitle;
    private JPanel panelNorth;

    public bai1() {
        setTitle("Giải phương trình bậc 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 110);
        setLocationRelativeTo(null);

        Box boxVertical = Box.createVerticalBox();
        Box boxNorth = Box.createHorizontalBox();
        // Box boxSouth = Box.createHorizontalBox();
        // Box boxWest = Box.createVerticalBox();
        // Box  boxCenter = Box.createVerticalBox();

        panelNorth = new JPanel();
        this.add(panelNorth);

        ltlTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
        ltlTitle.setFont(new Font("Arial", Font.BOLD, 18));
        panelNorth.add(ltlTitle);

        boxNorth.add(Box.createRigidArea(new Dimension(10, 10)));
        boxNorth.add(panelNorth);
        boxNorth.setBackground(Color.decode("#00FFFF"));


        boxVertical.add(boxNorth, BorderLayout.NORTH);
        this.add(boxVertical, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
