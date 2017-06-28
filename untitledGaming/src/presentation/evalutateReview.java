package presentation;

import business.implementation.AchievementsManager;
import business.implementation.Interfaces.AchievementsManagerInterface;
import business.implementation.Interfaces.ReviewInterface;
import business.implementation.Interfaces.UserManagementInterface;
import business.implementation.ReviewManagement;
import business.implementation.UserManagement;
import business.model.Utente;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class evalutateReview extends starView {
    Utente utente;
    int row;
    private JFrame frmUntitledGaming;

    public evalutateReview(Utente c, int r) {

        this.utente = c;
        this.row = r;
        initialize();
    }

    private void initialize() {

        ReviewInterface ri = new ReviewManagement();

        UserManagementInterface um = new UserManagement();
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/imgs/UG_silver_logo.png"));
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Valuta Recensioni");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JButton button = new JButton("");
        button.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        button.setToolTipText("torna indietro");
        button.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(button);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                business.implementation.Utils.Utilities.changePage("logged", utente);

            }
        });

        JLabel lblListaGiochi = null;
        try {
            int fineLista = ri.getPendingReviews().getRowCount();
            int inizioLista = row + 4;
            if (fineLista == 0) {
                JOptionPane.showMessageDialog(null, "Nessuna review da valutare");
            }

            if ((row + 4) >= fineLista)
                inizioLista = fineLista;
            lblListaGiochi = new JLabel("Lista Commenti" + "(" + (inizioLista) + " / " + (fineLista) + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
        lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblListaGiochi.setBounds(0, 23, 944, 61);
        frmUntitledGaming.getContentPane().add(lblListaGiochi);

        JButton btnSuccessiva = new JButton("");
        btnSuccessiva.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_next.png")));
        btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
        btnSuccessiva.setToolTipText("Pagina Successiva");
        btnSuccessiva.setBounds(830, 581, 45, 45);


        try {
            if (row + 4 >= ri.getPendingReviews().getRowCount()) {
                btnSuccessiva.setEnabled(false);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        frmUntitledGaming.getContentPane().add(btnSuccessiva);
        btnSuccessiva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                new evalutateReview(utente, row + 4);

            }
        });


        JButton button_4 = new JButton("");
        button_4.setEnabled(false);
        button_4.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_back_1.png")));
        button_4.setToolTipText("Pagina Precedente");
        button_4.setFont(new Font("MV Boli", Font.ITALIC, 13));
        button_4.setBounds(68, 581, 45, 45);
        frmUntitledGaming.getContentPane().add(button_4);

        if (row == 0) button_4.setEnabled(false);

        frmUntitledGaming.getContentPane().add(button_4);
        button_4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                new evalutateReview(utente, row - 4);
            }
        });

        /** First User */
        int vote = 0;
        int gameId1 = 0;
        int userId1 = 0;
        String gioco1 = "";

        JLabel label = null;

        try {
            if (row >= ri.getPendingReviews().getRowCount()) {
                label = new JLabel("vuoto");
            } else {

                userId1 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row, 0)));
                gameId1 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row, 3)));

                try {
                    vote = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row, 2)));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                gioco1 = um.getGameFromId(gameId1);
                String username1 = um.getUsername(userId1);
                label = new JLabel(username1);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setForeground(Color.DARK_GRAY);
                label.setFont(new Font("Oregano", Font.PLAIN, 21));
                label.setBounds(243, 148, 211, 30);
                frmUntitledGaming.getContentPane().add(label);

                JPanel panel_4 = new JPanel();
                panel_4.setToolTipText("Valutazione");
                panel_4.setBounds(464, 141, 259, 45);
                ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
                ImageProducer ip = defaultIcon.getImage().getSource();
                List<ImageIcon>
                        list = Arrays.asList(
                        makeStarImageIcon(ip, .6f, .6f, 0f),
                        makeStarImageIcon(ip, .7f, .7f, 0f),
                        makeStarImageIcon(ip, .8f, .8f, 0f),
                        makeStarImageIcon(ip, .9f, .9f, 0f),
                        makeStarImageIcon(ip, 1f, 1f, 0f));

                LevelBar lb = new LevelBar(defaultIcon, list, 2);
                panel_4.add(makeStarRatingPanel("", lb));
                lb.setLevel(vote - 1);
                frmUntitledGaming.getContentPane().add(panel_4);

                // Read the comment
                JButton btnRecensione = new JButton("Leggi Commento");
                btnRecensione.setToolTipText("Leggi Commento");
                btnRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnRecensione.setBounds(738, 148, 180, 30);
                frmUntitledGaming.getContentPane().add(btnRecensione);

                int finalGameId = gameId1;
                int finalUserId = userId1;
                btnRecensione.addActionListener(new ActionListener() {


                    public void actionPerformed(ActionEvent e) {

                        frmUntitledGaming.setVisible(false);
                        try {
                            new approveComment(utente, ri.getReview(finalUserId, finalGameId));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }
                });

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /** User 2 */
        String gioco2 = "";
        int gameId2 = 0;
        int userId2 = 0;

        JLabel label_1 = null;
        try {
            if (row + 1 >= ri.getPendingReviews().getRowCount()) {
                label_1 = new JLabel("vuoto");
            } else {
                userId2 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 1, 0)));
                gameId2 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 1, 3)));

                try {
                    vote = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 1, 2)));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                gioco2 = um.getGameFromId(gameId2);
                String username2 = um.getUsername(userId2);

                label_1 = new JLabel(username2);
                label_1.setHorizontalAlignment(SwingConstants.CENTER);
                label_1.setForeground(Color.DARK_GRAY);
                label_1.setFont(new Font("Oregano", Font.PLAIN, 21));
                label_1.setBounds(243, 271, 211, 30);
                frmUntitledGaming.getContentPane().add(label_1);

                JPanel panel_5 = new JPanel();
                panel_5.setToolTipText("Valutazione");
                panel_5.setBounds(464, 265, 259, 45);
                ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
                ImageProducer ip = defaultIcon.getImage().getSource();
                List<ImageIcon>
                        list = Arrays.asList(
                        makeStarImageIcon(ip, .6f, .6f, 0f),
                        makeStarImageIcon(ip, .7f, .7f, 0f),
                        makeStarImageIcon(ip, .8f, .8f, 0f),
                        makeStarImageIcon(ip, .9f, .9f, 0f),
                        makeStarImageIcon(ip, 1f, 1f, 0f));

                LevelBar lb = new LevelBar(defaultIcon, list, 2);
                panel_5.add(makeStarRatingPanel("", lb));
                lb.setLevel(vote - 1);
                frmUntitledGaming.getContentPane().add(panel_5);

                // Read the comment
                JButton btnGioca = new JButton("Leggi Commento");
                btnGioca.setToolTipText("Leggi Commento");
                btnGioca.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca.setBounds(738, 271, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca);
                int finalGameId2 = gameId2;
                int finalUserId2 = userId2;
                btnGioca.addActionListener(new ActionListener() {


                    public void actionPerformed(ActionEvent e) {

                        frmUntitledGaming.setVisible(false);
                        try {
                            new approveComment(utente, ri.getReview(finalUserId2, finalGameId2));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }
                });

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /** User 3 */
        int gameId3 = 0;
        int userId3 = 0;
        String gioco3 = "";
        JLabel label_2 = null;

        try {
            if (row + 2 >= ri.getPendingReviews().getRowCount()) {
                label_2 = new JLabel("vuoto");
            } else {
                userId3 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 2, 0)));
                gameId3 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 2, 3)));

                try {
                    vote = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 2, 2)));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                gioco3 = um.getGameFromId(gameId3);
                String username3 = um.getUsername(userId3);

                // Username label
                label_2 = new JLabel(username3);
                label_2.setHorizontalAlignment(SwingConstants.CENTER);
                label_2.setForeground(Color.DARK_GRAY);
                label_2.setFont(new Font("Oregano", Font.PLAIN, 21));
                label_2.setBounds(243, 386, 211, 30);
                frmUntitledGaming.getContentPane().add(label_2);

                // Star rating panel
                JPanel panel_6 = new JPanel();
                panel_6.setToolTipText("Valutazione");
                panel_6.setBounds(464, 380, 259, 45);
                ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
                ImageProducer ip = defaultIcon.getImage().getSource();
                List<ImageIcon>
                        list = Arrays.asList(
                        makeStarImageIcon(ip, .6f, .6f, 0f),
                        makeStarImageIcon(ip, .7f, .7f, 0f),
                        makeStarImageIcon(ip, .8f, .8f, 0f),
                        makeStarImageIcon(ip, .9f, .9f, 0f),
                        makeStarImageIcon(ip, 1f, 1f, 0f));

                LevelBar lb = new LevelBar(defaultIcon, list, 2);
                panel_6.add(makeStarRatingPanel("", lb));
                lb.setLevel(vote - 1);
                frmUntitledGaming.getContentPane().add(panel_6);

                // Read the comment
                JButton btnGioca_1 = new JButton("Leggi Commento");
                btnGioca_1.setToolTipText("Leggi Commento");
                btnGioca_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_1.setBounds(738, 386, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_1);

                int finalGameId3 = gameId3;
                int finalUserId3 = userId3;
                btnGioca_1.addActionListener(new ActionListener() {


                    public void actionPerformed(ActionEvent e) {

                        frmUntitledGaming.setVisible(false);
                        try {
                            new approveComment(utente, ri.getReview(finalUserId3, finalGameId3));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /** User 4 */
        int userId4 = 0;
        int gameId4 = 0;
        String gioco4 = "";
        JLabel label_3 = null;

        try {
            if (row + 3 >= ri.getPendingReviews().getRowCount()) {
                label_3 = new JLabel("vuoto");
            } else {
                userId4 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 3, 0)));
                gameId4 = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 3, 3)));

                try {
                    vote = Integer.parseInt(String.valueOf(ri.getPendingReviews().getValueAt(row + 3, 2)));
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                gioco4 = um.getGameFromId(gameId4);
                String username4 = um.getUsername(userId4);

                label_3 = new JLabel(username4);
                label_3.setHorizontalAlignment(SwingConstants.CENTER);
                label_3.setForeground(Color.DARK_GRAY);
                label_3.setFont(new Font("Oregano", Font.PLAIN, 21));
                label_3.setBounds(243, 504, 211, 30);
                frmUntitledGaming.getContentPane().add(label_3);

                JPanel panel_7 = new JPanel();
                panel_7.setToolTipText("Valutazione");
                panel_7.setBounds(464, 497, 259, 45);
                ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
                ImageProducer ip = defaultIcon.getImage().getSource();
                List<ImageIcon>
                        list = Arrays.asList(
                        makeStarImageIcon(ip, .6f, .6f, 0f),
                        makeStarImageIcon(ip, .7f, .7f, 0f),
                        makeStarImageIcon(ip, .8f, .8f, 0f),
                        makeStarImageIcon(ip, .9f, .9f, 0f),
                        makeStarImageIcon(ip, 1f, 1f, 0f));

                LevelBar lb = new LevelBar(defaultIcon, list, 2);
                panel_7.add(makeStarRatingPanel("", lb));
                lb.setLevel(vote - 1);
                frmUntitledGaming.getContentPane().add(panel_7);

                // Read the comment
                JButton btnGioca_2 = new JButton("Leggi Commento");
                btnGioca_2.setToolTipText("Leggi Commento");
                btnGioca_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_2.setBounds(738, 504, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_2);

                int finalGameId4 = gameId4;
                int finalUserId4 = userId4;
                btnGioca_2.addActionListener(new ActionListener() {


                    public void actionPerformed(ActionEvent e) {

                        frmUntitledGaming.setVisible(false);
                        try {
                            new approveComment(utente, ri.getReview(finalUserId4, finalGameId4));
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }
                });

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Static text
        JLabel lblgamenameHere_2 = new JLabel(gioco1);
        lblgamenameHere_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblgamenameHere_2.setForeground(Color.DARK_GRAY);
        lblgamenameHere_2.setFont(new Font("Oregano", Font.PLAIN, 21));
        lblgamenameHere_2.setBounds(22, 148, 211, 30);
        frmUntitledGaming.getContentPane().add(lblgamenameHere_2);

        JLabel lblgamenameHere_1 = new JLabel(gioco2);
        lblgamenameHere_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblgamenameHere_1.setForeground(Color.DARK_GRAY);
        lblgamenameHere_1.setFont(new Font("Oregano", Font.PLAIN, 21));
        lblgamenameHere_1.setBounds(22, 271, 211, 30);
        frmUntitledGaming.getContentPane().add(lblgamenameHere_1);

        JLabel lblgamenameHere = new JLabel(gioco3);
        lblgamenameHere.setHorizontalAlignment(SwingConstants.CENTER);
        lblgamenameHere.setForeground(Color.DARK_GRAY);
        lblgamenameHere.setFont(new Font("Oregano", Font.PLAIN, 21));
        lblgamenameHere.setBounds(22, 386, 211, 30);
        frmUntitledGaming.getContentPane().add(lblgamenameHere);

        JLabel lblGamenameHere = new JLabel(gioco4);
        lblGamenameHere.setHorizontalAlignment(SwingConstants.CENTER);
        lblGamenameHere.setForeground(Color.DARK_GRAY);
        lblGamenameHere.setFont(new Font("Oregano", Font.PLAIN, 21));
        lblGamenameHere.setBounds(22, 504, 211, 30);
        frmUntitledGaming.getContentPane().add(lblGamenameHere);

        JLabel lblNomeDelGioco = new JLabel("Nome del gioco:");
        lblNomeDelGioco.setForeground(Color.LIGHT_GRAY);
        lblNomeDelGioco.setFont(new Font("Georgia", Font.ITALIC, 13));
        lblNomeDelGioco.setBounds(67, 94, 140, 21);
        frmUntitledGaming.getContentPane().add(lblNomeDelGioco);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.LIGHT_GRAY);
        lblUsername.setFont(new Font("Georgia", Font.ITALIC, 13));
        lblUsername.setBounds(283, 98, 140, 21);
        frmUntitledGaming.getContentPane().add(lblUsername);

        JLabel lblRecensione = new JLabel("Valutazione:");
        lblRecensione.setForeground(Color.LIGHT_GRAY);
        lblRecensione.setFont(new Font("Georgia", Font.ITALIC, 13));
        lblRecensione.setBounds(484, 98, 140, 21);
        frmUntitledGaming.getContentPane().add(lblRecensione);
        frmUntitledGaming.setVisible(true);
    }
}