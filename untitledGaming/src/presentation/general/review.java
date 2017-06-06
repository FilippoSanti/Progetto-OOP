package presentation.general;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.image.ImageProducer;
import java.util.Arrays;
import java.util.List;

public class review extends starRating {

    private JFrame frmUntitledGaming;

    /**
     * Create the application.
     */
    public review() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setTitle("Untitled Gaming - Write a review");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 750, 500);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);

        JLabel lblValutaQuestoGioco = new JLabel("Valuta questo tossTheCoin:");
        lblValutaQuestoGioco.setForeground(SystemColor.textInactiveText);
        lblValutaQuestoGioco.setHorizontalAlignment(SwingConstants.CENTER);
        lblValutaQuestoGioco.setFont(new Font("Georgia", Font.ITALIC, 20));
        lblValutaQuestoGioco.setBounds(10, 60, 724, 25);
        frmUntitledGaming.getContentPane().add(lblValutaQuestoGioco);

        JLabel lblScriviUnCommento = new JLabel("Write a comment:");
        lblScriviUnCommento.setHorizontalAlignment(SwingConstants.CENTER);
        lblScriviUnCommento.setForeground(SystemColor.textInactiveText);
        lblScriviUnCommento.setFont(new Font("Georgia", Font.ITALIC, 20));
        lblScriviUnCommento.setBounds(10, 198, 724, 25);
        frmUntitledGaming.getContentPane().add(lblScriviUnCommento);

        JEditorPane dtrpnLasciaQuIl = new JEditorPane();
        dtrpnLasciaQuIl.setToolTipText("Scrivi un commento...");
        dtrpnLasciaQuIl.setText("   Lascia qu\u00EC il tuo commento...");
        dtrpnLasciaQuIl.setFont(new Font("Oregano", Font.ITALIC, 17));
        dtrpnLasciaQuIl.setBackground(new Color(220, 220, 220));
        dtrpnLasciaQuIl.setBounds(89, 243, 567, 130);
        frmUntitledGaming.getContentPane().add(dtrpnLasciaQuIl);

        JButton btnInviaRecensione = new JButton("Invia Recensione");
        btnInviaRecensione.setToolTipText("Invia Recensione");
        btnInviaRecensione.setFont(new Font("MV Boli", Font.ITALIC, 14));
        btnInviaRecensione.setBounds(302, 401, 141, 37);
        frmUntitledGaming.getContentPane().add(btnInviaRecensione);

        JPanel panel = new JPanel();
        panel.setBounds(89, 96, 567, 91);
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("img/31g.png"));
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

    }
}
