package presentation;

import business.implementation.AchievementsManager;
import business.implementation.UserManagement;
import business.model.Achievement;
import business.model.Utente;
import controller.eventsListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class achievementsList {

    Utente utente;
    private JFrame frmUntitledGaming;
    int row, nPages;

    /* Create the application */
    public achievementsList(Utente c, int r) {
        this.utente = c;
        this.row = r;
        initialize();
    }

    /* Create the application */
    public achievementsList() {
        initialize();
    }

    /*Initialize the contents of the frame */
    private void initialize() {
        Achievement ach = null;

        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/imgs/UG_silver_logo.png"));
        frmUntitledGaming.setVisible(true);
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Visualizza Achievements");
        frmUntitledGaming.setResizable(false);

        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        // Back button
        JButton back_btn = new JButton("");
        back_btn.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        back_btn.setToolTipText("torna indietro");
        back_btn.setFont(new Font("MV Boli", Font.ITALIC, 13));
        back_btn.setBounds(10, 11, 45, 45);

        frmUntitledGaming.getContentPane().add(back_btn);

        back_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                business.implementation.Utils.Utilities.changePage("profile", utente);

            }
        });

        // Next button
        JButton btnSuccessiva = new JButton("");
        btnSuccessiva.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_next.png")));
        btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
        btnSuccessiva.setToolTipText("Pagina Successiva");
        btnSuccessiva.setBounds(830, 581, 45, 45);

        // Get the end of the list
        int fineLista = 0;
        try {
            fineLista = new AchievementsManager().getUserAchievementsList(utente.getUserId()).getRowCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int inizioLista = row + 4;

        if ((row + 4) >= fineLista)
            inizioLista = fineLista;

        JLabel lblListaGiochi = new JLabel("Lista Achievement sbloccati " + "(" + (inizioLista) + " / " + (fineLista) + ")");
        lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
        lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblListaGiochi.setBounds(0, 23, 944, 61);
        frmUntitledGaming.getContentPane().add(lblListaGiochi);

        try {
            if (row + 4 >= new AchievementsManager().getUserAchievementsList(utente.getUserId()).getRowCount()) {
                btnSuccessiva.setEnabled(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frmUntitledGaming.getContentPane().add(btnSuccessiva);
        btnSuccessiva.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                new achievementsList(utente, row + 4);
            }
        });

        // Bottone pagina precedente
        JButton button_4 = new JButton("");
        button_4.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_back_1.png")));
        button_4.setToolTipText("Pagina Precedente");
        button_4.setFont(new Font("MV Boli", Font.ITALIC, 13));
        button_4.setBounds(68, 581, 45, 45);
        if (row == 0) button_4.setEnabled(false);

        frmUntitledGaming.getContentPane().add(button_4);
        button_4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                new achievementsList(utente, row - 4);
            }
        });

        // If the list is empty, we show a message dialog
        if (fineLista == 0) {
            JOptionPane.showMessageDialog(null, "Nessun achievement sbloccato");
        }

        // Achievement 1
        try {
            JTable table = new JTable(new AchievementsManager().getUserAchievementsList(utente.getUserId()));
            String achievementDesc = String.valueOf(table.getValueAt(row, 1));

            // Get the game id from th Table Model
            String gameID = String.valueOf(table.getValueAt(row, 2));

            // Achievement icon
            JPanel panel = new JPanel();
            BufferedImage myPicture = null;
            try {
                myPicture = ImageIO.read(new File("./src/presentation/imgs/generalIconOfAchievements.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel.add(picLabel);
            panel.setBounds(88, 89, 90, 90);
            frmUntitledGaming.getContentPane().add(panel);

            // Description
            JLabel lblDescrizione = new JLabel("Descrizione:");
            lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
            lblDescrizione.setForeground(Color.DARK_GRAY);
            lblDescrizione.setFont(new Font("Oregano", Font.PLAIN, 21));
            lblDescrizione.setBounds(204, 103, 125, 30);
            frmUntitledGaming.getContentPane().add(lblDescrizione);

            //Game name
            int id_user = Integer.parseInt(gameID);
            JTable achTable = new JTable(new UserManagement().getGameNameByID(id_user));
            String achNameString = String.valueOf(achTable.getValueAt(0, 0));

            JLabel lbltitoloGioco = new JLabel(achNameString);

            lbltitoloGioco.setHorizontalAlignment(SwingConstants.CENTER);
            lbltitoloGioco.setForeground(Color.GRAY);
            lbltitoloGioco.setFont(new Font("MV Boli", Font.ITALIC, 17));
            lbltitoloGioco.setBounds(188, 132, 156, 30);
            frmUntitledGaming.getContentPane().add(lbltitoloGioco);

            // Text description
            JTextArea txtrDescrizione = new JTextArea();
            txtrDescrizione.setWrapStyleWord(true);
            txtrDescrizione.setLineWrap(true);
            txtrDescrizione.setBackground(UIManager.getColor("Button.background"));
            txtrDescrizione.setFont(new Font("MV Boli", txtrDescrizione.getFont().getStyle(), 14));
            txtrDescrizione.setText(achievementDesc);
            txtrDescrizione.setRows(2);
            txtrDescrizione.setEditable(false);
            txtrDescrizione.setBounds(354, 107, 537, 56);
            frmUntitledGaming.getContentPane().add(txtrDescrizione);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Achievement 2
        try {

            if (row + 1 >= new AchievementsManager().getUserAchievementsList(utente.getUserId()).getRowCount()) {

                // Show an empty label
                JPanel panel_1 = new JPanel();
                JLabel lblNewLabel = new JLabel("Empty");
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_1);

            } else {

                JTable table = new JTable(new AchievementsManager().getUserAchievementsList(utente.getUserId()));
                String achievementDesc = String.valueOf(table.getValueAt(row + 1, 1));

                // Get the game id from the Table Model
                String gameID = String.valueOf(table.getValueAt(row + 1, 2));



                // Achievement icon
                JPanel panel_1 = new JPanel();
                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(new File("./src/presentation/imgs/generalIconOfAchievements.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                panel_1.add(picLabel);

                panel_1.setBounds(88, 209, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_1);

                // Description
                JLabel label_1 = new JLabel("Descrizione:");
                label_1.setHorizontalAlignment(SwingConstants.CENTER);
                label_1.setForeground(Color.DARK_GRAY);
                label_1.setFont(new Font("Oregano", Font.PLAIN, 21));
                label_1.setBounds(204, 223, 125, 30);
                frmUntitledGaming.getContentPane().add(label_1);

                //Game name
                int id_game = Integer.parseInt(gameID);
                JTable achTable = new JTable(new UserManagement().getGameNameByID(id_game));
                String achNameString = String.valueOf(achTable.getValueAt(0, 0));

                JLabel label_3 = new JLabel(achNameString);

                label_3.setHorizontalAlignment(SwingConstants.CENTER);
                label_3.setForeground(Color.GRAY);
                label_3.setFont(new Font("MV Boli", Font.ITALIC, 17));
                label_3.setBounds(188, 253, 156, 30);
                frmUntitledGaming.getContentPane().add(label_3);

                // Text description
                JTextArea txtrDescrizione_1 = new JTextArea();
                txtrDescrizione_1.setLineWrap(true);
                txtrDescrizione_1.setWrapStyleWord(true);
                txtrDescrizione_1.setFont(new Font("MV Boli", txtrDescrizione_1.getFont().getStyle(), 14));
                txtrDescrizione_1.setText(achievementDesc);
                txtrDescrizione_1.setBackground(UIManager.getColor("Button.background"));
                txtrDescrizione_1.setEditable(false);
                txtrDescrizione_1.setRows(2);
                txtrDescrizione_1.setBounds(354, 227, 537, 56);
                frmUntitledGaming.getContentPane().add(txtrDescrizione_1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Achievement 3
        try {

            if (row + 2 >= new AchievementsManager().getUserAchievementsList(utente.getUserId()).getRowCount()) {
                // Show an empty label
                JPanel panel_1 = new JPanel();
                JLabel lblNewLabel = new JLabel("Empty");
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_1);
            } else {

                JTable table = new JTable(new AchievementsManager().getUserAchievementsList(utente.getUserId()));
                String achievementDesc = String.valueOf(table.getValueAt(row + 2, 1));

                // Get the game id from the Table Model
                String gameID = String.valueOf(table.getValueAt(row + 2, 2));

                // Achievement icon
                JPanel panel_2 = new JPanel();
                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(new File("./src/presentation/imgs/generalIconOfAchievements.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                panel_2.add(picLabel);
                panel_2.setBounds(88, 327, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_2);

                // Description
                JLabel label = new JLabel("Descrizione:");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setForeground(Color.DARK_GRAY);
                label.setFont(new Font("Oregano", Font.PLAIN, 21));
                label.setBounds(204, 340, 125, 30);
                frmUntitledGaming.getContentPane().add(label);

                int id_game = Integer.parseInt(gameID);
                JTable achTable = new JTable(new UserManagement().getGameNameByID(id_game));
                String achNameString = String.valueOf(achTable.getValueAt(0, 0));
                JLabel label_3 = new JLabel(achNameString);

                label_3.setHorizontalAlignment(SwingConstants.CENTER);
                label_3.setForeground(Color.GRAY);
                label_3.setFont(new Font("MV Boli", Font.ITALIC, 17));
                label_3.setBounds(188, 370, 156, 30);
                frmUntitledGaming.getContentPane().add(label_3);

                // Text description
                JTextArea txtrDescrizioneAchievementsDa = new JTextArea();
                txtrDescrizioneAchievementsDa.setWrapStyleWord(true);
                txtrDescrizioneAchievementsDa.setFont(new Font("MV Boli", txtrDescrizioneAchievementsDa.getFont().getStyle(), 14));
                txtrDescrizioneAchievementsDa.setText(achievementDesc);
                txtrDescrizioneAchievementsDa.setBackground(UIManager.getColor("Button.background"));
                txtrDescrizioneAchievementsDa.setEditable(false);
                txtrDescrizioneAchievementsDa.setLineWrap(true);
                txtrDescrizioneAchievementsDa.setRows(2);
                txtrDescrizioneAchievementsDa.setBounds(354, 344, 537, 56);

                frmUntitledGaming.getContentPane().add(txtrDescrizioneAchievementsDa);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Achievement 4
        try {

            if (row + 3 >= new AchievementsManager().getUserAchievementsList(utente.getUserId()).getRowCount()) {

            } else {

                JTable table = new JTable(new AchievementsManager().getUserAchievementsList(utente.getUserId()));
                String achievementDesc = String.valueOf(table.getValueAt(row + 3, 1));

                // Get the game id from the Table Model
                String gameID = String.valueOf(table.getValueAt(row + 3, 2));

                // Achievement icon
                JPanel panel_3 = new JPanel();
                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(new File("./src/presentation/imgs/generalIconOfAchievements.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JLabel picLabel = new JLabel(new ImageIcon(myPicture));
                panel_3.add(picLabel);
                panel_3.setBounds(88, 446, 90, 90);
                ;
                frmUntitledGaming.getContentPane().add(panel_3);

                // Description
                JLabel label = new JLabel("Descrizione:");
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setForeground(Color.DARK_GRAY);
                label.setFont(new Font("Oregano", Font.PLAIN, 21));
                label.setBounds(204, 459, 125, 30);
                frmUntitledGaming.getContentPane().add(label);

                int id_game = Integer.parseInt(gameID);
                JTable achTable = new JTable(new UserManagement().getGameNameByID(id_game));
                String achNameString = String.valueOf(achTable.getValueAt(0, 0));
                JLabel label_3 = new JLabel(achNameString);

                label_3.setHorizontalAlignment(SwingConstants.CENTER);
                label_3.setForeground(Color.GRAY);
                label_3.setFont(new Font("MV Boli", Font.ITALIC, 17));
                label_3.setBounds(188, 489, 156, 30);
                frmUntitledGaming.getContentPane().add(label_3);

                // Text description
                JTextArea txtrDescrizioneAchievementsDa_1 = new JTextArea();
                txtrDescrizioneAchievementsDa_1.setWrapStyleWord(true);
                txtrDescrizioneAchievementsDa_1.setFont(new Font("MV Boli", txtrDescrizioneAchievementsDa_1.getFont().getStyle(), 14));
                txtrDescrizioneAchievementsDa_1.setText(achievementDesc);
                txtrDescrizioneAchievementsDa_1.setBackground(UIManager.getColor("Button.background"));
                txtrDescrizioneAchievementsDa_1.setEditable(false);
                txtrDescrizioneAchievementsDa_1.setLineWrap(true);
                txtrDescrizioneAchievementsDa_1.setRows(2);
                txtrDescrizioneAchievementsDa_1.setBounds(354, 463, 537, 56);
                frmUntitledGaming.getContentPane().add(txtrDescrizioneAchievementsDa_1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}