package week3;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

// import java.awt.*;
import java.awt.event.*;

public class JTreeDemo extends JFrame implements ActionListener, TreeSelectionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private DefaultMutableTreeNode root;
    private JTree tree;

    public JTreeDemo() {
        setTitle("JTree Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        root = new DefaultMutableTreeNode("Root Node");
        tree = new JTree(root);

        add(new JScrollPane(tree));

        DefaultMutableTreeNode parent = new DefaultMutableTreeNode("Parents");
        DefaultMutableTreeNode Child1 = new DefaultMutableTreeNode("Tèo Nguyễn");
        DefaultMutableTreeNode Child2 = new DefaultMutableTreeNode("Đạt nguyễn");
        root.add(parent);
        parent.add(Child1);
        parent.add(Child2);

        // lắng nghe sự kiện
        tree.addTreeSelectionListener(this);
    }

    public static void main(String[] args) {
        new JTreeDemo().setVisible(true);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath selPath = e.getNewLeadSelectionPath();
        Object o = selPath.getLastPathComponent();
        JOptionPane.showMessageDialog(null, o);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
