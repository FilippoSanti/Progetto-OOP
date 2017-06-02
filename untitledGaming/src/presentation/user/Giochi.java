/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/
// ScrollDemo.java
//A simple JScrollPane demonstration.
//

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import java.awt.Panel;

public class Giochi extends JFrame {

    JScrollPane scrollpane;

    public Giochi() {
        super("JScrollPane Demonstration");
        setSize(750, 497);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    public void init() {

        JPanel p = new JPanel();
        p.setSize(600, 400);
        p.setLayout(new GridLayout(13, 6, 10, 0));
        
        scrollpane = new JScrollPane(p);
        
        JButton btnNewButton_1 = new JButton("New button");
        p.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("New button");
        p.add(btnNewButton_2);
        
        Panel panel = new Panel();
        p.add(panel);
        
        JButton btnNewButton = new JButton("New button");
        p.add(btnNewButton);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        new Giochi();
    }
}