package presentation;

import business.implementation.ReviewManagement;
import business.implementation.UserManagement;
import controller.eventsListener;
import business.model.Review;
import business.model.Utente;
import controller.eventsListener;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class approveComment {

    private JFrame frmUntitledGaming;

    Utente utente;
    Review review;

    public approveComment(Utente c, Review r) {
        this.utente = c;
        this.review = r;
        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/imgs/UG_silver_logo.png"));
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Leggi Commento");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JButton btnApprovaCommento = new JButton("Approva Recensione");
        btnApprovaCommento.setToolTipText("Approva Recensione");
        btnApprovaCommento.setForeground(new Color(24, 160, 10));
        btnApprovaCommento.setBackground(new Color(152, 251, 152));
        btnApprovaCommento.setFont(new Font("MV Boli", Font.ITALIC, 18));
        btnApprovaCommento.setBounds(124, 545, 260, 46);
        frmUntitledGaming.getContentPane().add(btnApprovaCommento);
        btnApprovaCommento.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                try {
                    new ReviewManagement().approveReview(review);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                business.implementation.Utils.Utilities.changePage("evalutateReview", utente);

            }
        });

        JButton btnEliminaCommento = new JButton("Elimina Recensione");
        btnEliminaCommento.setToolTipText("Elimina Recensione");
        btnEliminaCommento.setForeground(new Color(155, 17, 0));
        btnEliminaCommento.setFont(new Font("MV Boli", Font.ITALIC, 18));
        btnEliminaCommento.setBackground(new Color(240, 142, 126));
        btnEliminaCommento.setBounds(560, 545, 260, 46);
        frmUntitledGaming.getContentPane().add(btnEliminaCommento);

        btnEliminaCommento.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                try {
                    new ReviewManagement().deleteReview(review);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                business.implementation.Utils.Utilities.changePage("evalutateReview", utente);
            }
        });

        JLabel lblHaScritto_1 = new JLabel("  ha scritto:");
        lblHaScritto_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblHaScritto_1.setForeground(SystemColor.textInactiveText);
        lblHaScritto_1.setFont(new Font("Georgia", Font.ITALIC, 30));
        lblHaScritto_1.setBounds(417, 87, 190, 35);
        frmUntitledGaming.getContentPane().add(lblHaScritto_1);

        JLabel lblusername = null;
        try {
            lblusername = new JLabel(new UserManagement().getUsername(review.getUser_id()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lblusername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblusername.setForeground(SystemColor.textInactiveText);
        lblusername.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 30));
        lblusername.setBounds(177, 87, 226, 35);
        frmUntitledGaming.getContentPane().add(lblusername);

        JTextPane txtpncommentoPrecedentementeInserito = new JTextPane();
        txtpncommentoPrecedentementeInserito.setBackground(new Color(220, 220, 220));
        txtpncommentoPrecedentementeInserito.setFont(new Font("Oregano", Font.ITALIC, 25));
        txtpncommentoPrecedentementeInserito.setText(review.getText());
        txtpncommentoPrecedentementeInserito.setEditable(false);
        txtpncommentoPrecedentementeInserito.setBounds(124, 206, 696, 223);
        frmUntitledGaming.getContentPane().add(txtpncommentoPrecedentementeInserito);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setToolTipText("torna indietro");
        btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        btnNewButton_1.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(btnNewButton_1);
        frmUntitledGaming.setVisible(true);
        btnNewButton_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                business.implementation.Utils.Utilities.changePage("evalutateReview", utente);

            }
        });
    }
}