package presentation.general;

import business.model.Utente;
import controller.eventsListener;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.image.ImageProducer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class review extends MainPanel {

    private JFrame frmUntitledGaming;

Utente utente;
    /**
     * Create the application.
     */
    public review(Utente c) {

        this.utente = c;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Scrivi Recensione");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);

        JLabel lblValutaQuestoGioco = new JLabel("Valuta");
        lblValutaQuestoGioco.setForeground(SystemColor.textInactiveText);
        lblValutaQuestoGioco.setHorizontalAlignment(SwingConstants.RIGHT);
        lblValutaQuestoGioco.setFont(new Font("Georgia", Font.ITALIC, 30));
        lblValutaQuestoGioco.setBounds(10, 63, 401, 52);
        frmUntitledGaming.getContentPane().add(lblValutaQuestoGioco);

        JLabel lblScriviUnCommento = new JLabel("Scrivi Commento:");
        lblScriviUnCommento.setHorizontalAlignment(SwingConstants.CENTER);
        lblScriviUnCommento.setForeground(SystemColor.textInactiveText);
        lblScriviUnCommento.setFont(new Font("Georgia", Font.ITALIC, 30));
        lblScriviUnCommento.setBounds(10, 229, 924, 52);
        frmUntitledGaming.getContentPane().add(lblScriviUnCommento);

        JEditorPane dtrpnLasciaQuIl = new JEditorPane();
        dtrpnLasciaQuIl.setToolTipText("Scrivi un Commento...");

        //listen for focus
        dtrpnLasciaQuIl.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                dtrpnLasciaQuIl.setText("  ");
            }
            public void focusLost (FocusEvent e){
                if (dtrpnLasciaQuIl.getText().isEmpty())
                    dtrpnLasciaQuIl.setText("   Lascia qu\u00EC il Tuo Commento......");
            }
        });


        dtrpnLasciaQuIl.setText("   Lascia qu\u00EC il Tuo Commento......");
        dtrpnLasciaQuIl.setFont(new Font("Oregano", Font.PLAIN, 25));
        dtrpnLasciaQuIl.setBackground(new Color(220, 220, 220));
        dtrpnLasciaQuIl.setBounds(124, 313, 696, 223);
        frmUntitledGaming.getContentPane().add(dtrpnLasciaQuIl);


        JButton btnInviaRecensione = new JButton("Invia Recensione");
        btnInviaRecensione.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnInviaRecensione.setToolTipText("Invia Recensione");
        btnInviaRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnInviaRecensione.setBounds(355, 573, 234, 52);
        frmUntitledGaming.getContentPane().add(btnInviaRecensione);

        btnInviaRecensione.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                eventsListener.changePage("reviewList", utente);
                try {
                    controller.eventsListener.addReview(utente, dtrpnLasciaQuIl.getText(), 4);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        JPanel panel = new JPanel();
        panel.setBounds(115, 127, 696, 90);
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g_1.png"));
        ImageProducer ip = defaultIcon.getImage().getSource();
        List<ImageIcon>
                list = Arrays.asList(
                makeStarImageIcon(ip, .6f, .6f, 0f),
                makeStarImageIcon(ip, .7f, .7f, 0f),
                makeStarImageIcon(ip, .8f, .8f, 0f),
                makeStarImageIcon(ip, .9f, .9f, 0f),
                makeStarImageIcon(ip,  1f,  1f, 0f));
        panel.add(makeStarRatingPanel("", new LevelBar(defaultIcon, list, 2)));
        frmUntitledGaming.getContentPane().add(panel);

        JLabel lblnomeGioco = new JLabel("-Nome Gioco-");
        lblnomeGioco.setHorizontalAlignment(SwingConstants.LEFT);
        lblnomeGioco.setForeground(SystemColor.textInactiveText);
        lblnomeGioco.setFont(new Font("Georgia", Font.ITALIC, 30));
        lblnomeGioco.setBounds(421, 63, 489, 52);
        frmUntitledGaming.getContentPane().add(lblnomeGioco);

        JButton button = new JButton("");
        button.setIcon(new ImageIcon("imgs/back_icon.png"));
        button.setToolTipText("Torna Indietro");
        button.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(button);

        JButton btnTornaAllaHome = new JButton("Torna alla Home");
        btnTornaAllaHome.setToolTipText("Torna alla Home");
        btnTornaAllaHome.setFont(new Font("MV Boli", Font.ITALIC, 15));
        btnTornaAllaHome.setBounds(758, 26, 161, 35);
        frmUntitledGaming.getContentPane().add(btnTornaAllaHome);

        frmUntitledGaming.setVisible(true
        );
    }
}
