package presentation.general;

import business.model.Review;
import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.sql.SQLException;
import java.util.Arrays;

public class viewReview extends starView {

    Utente utente = null;
    private JFrame frmUntitledGaming;
    int userId;
    int riga;
    int gameID;

    public viewReview(Utente c, int row, int u, int gam) {
        this.utente = c;
        this.userId = u;
        this.riga = row;
        this.gameID = gam;
        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Visualizza Recensione");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JLabel lblLaTuaRecensione = new JLabel("La Tua Recensione :");
        lblLaTuaRecensione.setHorizontalAlignment(SwingConstants.CENTER);
        lblLaTuaRecensione.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblLaTuaRecensione.setBounds(0, 50, 944, 61);
        frmUntitledGaming.getContentPane().add(lblLaTuaRecensione);

        JLabel lblScriviUnCommento = new JLabel("Il Tuo Commento :");
        lblScriviUnCommento.setHorizontalAlignment(SwingConstants.LEFT);
        lblScriviUnCommento.setForeground(SystemColor.textInactiveText);
        lblScriviUnCommento.setFont(new Font("Georgia", Font.ITALIC, 25));
        lblScriviUnCommento.setBounds(96, 315, 232, 34);
        frmUntitledGaming.getContentPane().add(lblScriviUnCommento);

        JButton button = new JButton("");
        button.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        button.setToolTipText("torna indietro");
        button.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                new reviewList(utente, riga, gameID);
            }
        });

        JLabel lblValutazione = new JLabel("Valutazione :");
        lblValutazione.setHorizontalAlignment(SwingConstants.LEFT);
        lblValutazione.setForeground(SystemColor.textInactiveText);
        lblValutazione.setFont(new Font("Georgia", Font.ITALIC, 25));
        lblValutazione.setBounds(96, 188, 188, 29);
        frmUntitledGaming.getContentPane().add(lblValutazione);

        JPanel panel = new JPanel();
        panel.setBounds(279, 155, 490, 105);


        JTextPane txtpncommentoPrecedentementeInserito = new JTextPane();
        Review rev = null;

        try {
            rev = eventsListener.getReview(userId, gameID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Star rating
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g_1.png"));
        ImageProducer ip = defaultIcon.getImage().getSource();
        java.util.List<ImageIcon>
                list = Arrays.asList(
                makeStarImageIcon(ip, .6f, .6f, 0f),
                makeStarImageIcon(ip, .7f, .7f, 0f),
                makeStarImageIcon(ip, .8f, .8f, 0f),
                makeStarImageIcon(ip, .9f, .9f, 0f),
                makeStarImageIcon(ip, 1f, 1f, 0f));
        LevelBar lb = new LevelBar(defaultIcon, list, 2);

        panel.add(makeStarRatingPanel("", lb));
        lb.setLevel((int) rev.getVote() - 1);

        frmUntitledGaming.getContentPane().add(panel);

        txtpncommentoPrecedentementeInserito.setText(rev.getText());

        txtpncommentoPrecedentementeInserito.setFont(new Font("Oregano", Font.ITALIC, 25));
        txtpncommentoPrecedentementeInserito.setEditable(false);
        txtpncommentoPrecedentementeInserito.setBackground(new Color(220, 220, 220));
        txtpncommentoPrecedentementeInserito.setBounds(62, 392, 818, 198);
        frmUntitledGaming.getContentPane().add(txtpncommentoPrecedentementeInserito);

        frmUntitledGaming.setVisible(true);


    }
}
