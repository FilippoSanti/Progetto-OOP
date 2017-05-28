// java.lang.NullPointerException se eseguito su intellij
package presentation.user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class gameList {

    private JFrame frmUntitledGaming;

    /**
     * Create the application.
     */
    public gameList() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gameList window = new gameList();
                    window.frmUntitledGaming.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        JFrame frmUntitedGaming = new JFrame();
        frmUntitedGaming.setTitle("   Untited Gaming  -  I Tuoi Giochi");
        frmUntitedGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitedGaming.setResizable(false);
        JFrame frame = frmUntitedGaming;
        frmUntitedGaming.getContentPane().setLayout(null);

        Panel panel = new Panel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(47, 85, 60, 60);
        frmUntitedGaming.getContentPane().add(panel);

        JButton button_1 = new JButton("");
        button_1.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\back_icon.png"));
        button_1.setToolTipText("torna indietro");
        button_1.setBounds(10, 11, 37, 31);
        frmUntitedGaming.getContentPane().add(button_1);

        JLabel lblITuoiGiochi = new JLabel("I Tuoi Giochi");
        lblITuoiGiochi.setHorizontalAlignment(SwingConstants.CENTER);
        lblITuoiGiochi.setFont(new Font("Vivaldi", Font.BOLD, 30));
        lblITuoiGiochi.setBounds(0, 30, 744, 37);
        frmUntitedGaming.getContentPane().add(lblITuoiGiochi);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(739, 463, -737, -386);
        frmUntitedGaming.getContentPane().add(scrollPane);

        Panel panel_1 = new Panel();
        panel_1.setBackground(Color.BLUE);
        panel_1.setBounds(47, 175, 60, 60);
        frmUntitedGaming.getContentPane().add(panel_1);

        Panel panel_2 = new Panel();
        panel_2.setBackground(Color.YELLOW);
        panel_2.setBounds(47, 265, 60, 60);
        frmUntitedGaming.getContentPane().add(panel_2);

        Panel panel_3 = new Panel();
        panel_3.setBackground(Color.GREEN);
        panel_3.setBounds(47, 355, 60, 60);
        frmUntitedGaming.getContentPane().add(panel_3);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 0, 2, 2);
        frmUntitedGaming.getContentPane().add(scrollPane_1);

        JLabel lblDevoFarScrollare = new JLabel("devo far scrollare la pagina");
        lblDevoFarScrollare.setBounds(296, 214, 161, 14);
        frmUntitedGaming.getContentPane().add(lblDevoFarScrollare);
        frame.setBounds(100, 100, 750, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton button = new JButton("");
        button.setBounds(10, 11, 37, 31);
        button.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\back_icon.png"));
        button.setToolTipText("torna indietro");
        frame.getContentPane().add(button);
    }
}
