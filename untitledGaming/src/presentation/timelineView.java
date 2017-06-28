package presentation;

import business.implementation.AchievementsManager;
import business.implementation.Interfaces.AchievementsManagerInterface;
import business.implementation.Interfaces.ReviewInterface;
import business.implementation.Interfaces.TimelineManagementInterface;
import business.implementation.Interfaces.UserManagementInterface;
import business.implementation.ReviewManagement;
import business.implementation.TimelineManagement;
import business.implementation.UserManagement;
import business.model.Utente;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class timelineView {

    Utente utente;
    private JFrame frmUntitledGaming;

    /* Create the application */
    public timelineView(Utente c) {
        this.utente = c;
        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {


        UserManagementInterface um = new UserManagement();
        TimelineManagementInterface ti = new TimelineManagement();
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/imgs/UG_silver_logo.png"));
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Cronologia di Gioco");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.setLocationRelativeTo(null);
        frmUntitledGaming.getContentPane().setLayout(null);

        JButton button = new JButton("");
        button.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        button.setToolTipText("torna indietro");
        button.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                business.implementation.Utils.Utilities.changePage("profile", utente);

            }
        });

        JLabel lblCronologiaDiGioco = new JLabel("Cronologia di Gioco");
        lblCronologiaDiGioco.setHorizontalAlignment(SwingConstants.CENTER);
        lblCronologiaDiGioco.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblCronologiaDiGioco.setBounds(0, 51, 944, 61);
        frmUntitledGaming.getContentPane().add(lblCronologiaDiGioco);

        JLabel lblUltimogiocoGiocato = new JLabel("Ultimo Gioco Giocato :");
        lblUltimogiocoGiocato.setForeground(Color.GRAY);
        lblUltimogiocoGiocato.setFont(new Font("Georgia", Font.ITALIC, 17));
        lblUltimogiocoGiocato.setBounds(61, 210, 240, 30);
        frmUntitledGaming.getContentPane().add(lblUltimogiocoGiocato);

        JLabel lblUltimasessione = new JLabel("Data Ultima Sessione :");
        lblUltimasessione.setForeground(Color.GRAY);
        lblUltimasessione.setFont(new Font("Georgia", Font.ITALIC, 17));
        lblUltimasessione.setBounds(61, 354, 240, 30);
        frmUntitledGaming.getContentPane().add(lblUltimasessione);

        JLabel lblPuntiXpGuadagnati = new JLabel("Punti XP Guadagnati nell'Ultima Sessione :");
        lblPuntiXpGuadagnati.setForeground(Color.GRAY);
        lblPuntiXpGuadagnati.setFont(new Font("Georgia", Font.ITALIC, 17));
        lblPuntiXpGuadagnati.setBounds(61, 508, 387, 30);
        frmUntitledGaming.getContentPane().add(lblPuntiXpGuadagnati);

        JPanel panel = new JPanel();
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("./src/presentation/imgs/generalgamesLogo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        panel.add(picLabel);
        panel.setBounds(311, 178, 90, 90);
        frmUntitledGaming.getContentPane().add(panel);

        JLabel label = new JLabel("");
        panel.add(label);

        // Get the game id
        JLabel lblNewLabel = null;
        try {
            lblNewLabel = new JLabel(um.getGameFromId(ti.getTimeline(utente.getUserId()).getGioco_id()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lblNewLabel.setForeground(Color.DARK_GRAY);
        lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
        lblNewLabel.setBounds(450, 202, 306, 45);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        // Get the game's last play session
        JLabel lblInserireQui = null;
        try {
            lblInserireQui = new JLabel(ti.getTimeline(utente.getUserId()).getData_ultima_sessione().toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lblInserireQui.setForeground(Color.DARK_GRAY);
        lblInserireQui.setFont(new Font("Georgia", Font.ITALIC, 18));
        lblInserireQui.setBounds(311, 346, 306, 45);
        frmUntitledGaming.getContentPane().add(lblInserireQui);

        // Get the earned xp
        JLabel lblInserireQui_1 = null;
        try {
            lblInserireQui_1 = new JLabel(Integer.toString(ti.getTimeline(utente.getUserId()).getEsperienza_guadagnata()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lblInserireQui_1.setForeground(Color.DARK_GRAY);
        lblInserireQui_1.setFont(new Font("Georgia", Font.ITALIC, 18));
        lblInserireQui_1.setBounds(436, 500, 402, 45);
        frmUntitledGaming.getContentPane().add(lblInserireQui_1);

        frmUntitledGaming.setVisible(true);
    }
}