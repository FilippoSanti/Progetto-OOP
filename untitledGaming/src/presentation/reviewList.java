package presentation;

import business.implementation.UserManagement;
import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class reviewList extends starView {

    private JFrame frmUntitledGaming;
    int row, game;
    Utente utente;

    public reviewList(Utente c, int a, int gameID) {
        this.utente = c;
        this.row = a;
        this.game = gameID;
        initialize();
    }

    private void initialize() {
        int game = this.game;

        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/imgs/UG_silver_logo.png"));
        frmUntitledGaming.setVisible(true);
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Lista Commenti ");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JButton btnLaTuaRecensione = new JButton("La Mia Recensione");
        btnLaTuaRecensione.setToolTipText("La Mia Recensione");
        btnLaTuaRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnLaTuaRecensione.setBounds(375, 570, 198, 45);
        frmUntitledGaming.getContentPane().add(btnLaTuaRecensione);
        frmUntitledGaming.setVisible(true);

        btnLaTuaRecensione.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    if (eventsListener.reviewFoundOnProfile(utente.getUserId(), game)) {
                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, 0, utente.getUserId(), game);
                    } else {
                        frmUntitledGaming.setVisible(false);
                        new review(utente, game);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button = new JButton("");
        button.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        button.setToolTipText("Torna indietro");
        button.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(button);

        // allGames view button
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                eventsListener.changePage("allGames", utente);
            }
        });

        int fineLista = 0;
        try {
            fineLista = eventsListener.getReviewsByID(game).getRowCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JLabel lblListaGiochi = null;

        int inizioLista = row + 4;
        if ((row + 4) >= fineLista)
            inizioLista = fineLista;
        lblListaGiochi = new JLabel("Lista Commenti" + "(" + (inizioLista) + " / " + (fineLista) + ")");

        lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
        lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblListaGiochi.setBounds(0, 23, 944, 61);
        frmUntitledGaming.getContentPane().add(lblListaGiochi);

        //Next Button
        JButton btnSuccessiva = new JButton("");
        btnSuccessiva.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_next.png")));
        btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
        btnSuccessiva.setToolTipText("Pagina Successiva");
        btnSuccessiva.setBounds(830, 581, 45, 45);

        try {
            if (row + 4 >= eventsListener.getReviewsByID(game).getRowCount()) {
                btnSuccessiva.setEnabled(false);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        frmUntitledGaming.getContentPane().add(btnSuccessiva);
        btnSuccessiva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                new reviewList(utente, row + 4, -1);

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
                new reviewList(utente, row - 4, -1);
            }
        });

        // If the list is empty, we show a message dialog
        if (fineLista == 0) {
            JOptionPane.showMessageDialog(null, "Nessuna recensione disponibile");
        }

        /** First Review **/
        JLabel label = null;
        try {
            if (!(row >= eventsListener.getReviewsByID(game).getRowCount())) {

                JTable table = new JTable(eventsListener.getReviewsByID(game));
                String a = String.valueOf(eventsListener.getReviewsByID(game).getValueAt(row, 1));

                int voteInt = Integer.parseInt(table.getValueAt(row, 3).toString());
                System.out.println(voteInt);

                // Get the user id
                int b = Integer.parseInt(a);

                // Create a new label
                label = new JLabel(UserManagement.getUsername(b));

                // Star Rating
                JPanel panel_4 = new JPanel();
                panel_4.setToolTipText("Valutazione");
                panel_4.setBounds(384, 112, 311, 45);
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
                lb.setLevel(voteInt - 1);
                frmUntitledGaming.getContentPane().add(panel_4);

                // Read comment button
                JButton btnRecensione = new JButton("Leggi Commento");
                btnRecensione.setToolTipText("Leggi Commento");
                btnRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnRecensione.setBounds(710, 119, 180, 30);
                frmUntitledGaming.getContentPane().add(btnRecensione);

                JPanel panel_back = new JPanel();
                panel_back.setBackground(Color.YELLOW);
                panel_back.setBounds(66, 88, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_back);

                // View review button
                btnRecensione.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, row, b, game);

                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("Oregano", Font.PLAIN, 21));
        label.setBounds(166, 119, 211, 30);
        frmUntitledGaming.getContentPane().add(label);

        /** Review 2 **/
        JLabel label_1 = null;
        try {
            if (!(row + 1 >= eventsListener.getReviewsByID(game).getRowCount())) {

                JTable table = new JTable(eventsListener.getReviewsByID(game));
                String a = String.valueOf(eventsListener.getReviewsByID(game).getValueAt(row + 1, 1));

                int voteInt = Integer.parseInt(table.getValueAt(row + 1, 3).toString());

                // Get the user id
                int b = Integer.parseInt(a);

                // Create a new label
                label_1 = new JLabel(UserManagement.getUsername(b));

                // Star Rating
                JPanel panel_5 = new JPanel();
                panel_5.setToolTipText("Valutazione");
                panel_5.setBounds(384, 236, 311, 45);
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
                lb.setLevel(voteInt - 1);
                frmUntitledGaming.getContentPane().add(panel_5);

                JButton btnGioca = new JButton("Leggi Commento");
                btnGioca.setToolTipText("Leggi Commento");
                btnGioca.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca.setBounds(710, 242, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca);

                JPanel panel_1 = new JPanel();
                panel_1.setBackground(Color.BLUE);
                panel_1.setBounds(66, 208, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_1);

                btnGioca.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, row, b, game);

                    }
                });
            }

            label_1.setHorizontalAlignment(SwingConstants.CENTER);
            label_1.setForeground(Color.DARK_GRAY);
            label_1.setFont(new Font("Oregano", Font.PLAIN, 21));
            label_1.setBounds(166, 242, 211, 30);
            frmUntitledGaming.getContentPane().add(label_1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /** Review 3 **/
        JLabel label_2 = null;
        try {
            if (!(row + 2 >= eventsListener.getReviewsByID(game).getRowCount())) {

                JTable table = new JTable(eventsListener.getReviewsByID(game));
                String a = String.valueOf(eventsListener.getReviewsByID(game).getValueAt(row + 2, 1));

                int voteInt = Integer.parseInt(table.getValueAt(row + 2, 3).toString());

                // Get the user id
                int b = Integer.parseInt(a);

                // Create a new label
                label_2 = new JLabel(UserManagement.getUsername(b));

                // Star Rating
                JPanel panel_6 = new JPanel();
                panel_6.setToolTipText("Valutazione");
                panel_6.setBounds(384, 351, 311, 45);

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
                lb.setLevel(voteInt - 1);
                frmUntitledGaming.getContentPane().add(panel_6);

                JButton btnGioca_1 = new JButton("Leggi Commento");
                btnGioca_1.setToolTipText("Leggi Commento");
                btnGioca_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_1.setBounds(710, 357, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_1);

                JPanel panel_2 = new JPanel();
                panel_2.setBackground(Color.GREEN);
                panel_2.setBounds(66, 326, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_2);

                btnGioca_1.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, row, b, game);
                    }
                });
            }


            label_2.setHorizontalAlignment(SwingConstants.CENTER);
            label_2.setForeground(Color.DARK_GRAY);
            label_2.setFont(new Font("Oregano", Font.PLAIN, 21));
            label_2.setBounds(166, 357, 211, 30);
            frmUntitledGaming.getContentPane().add(label_2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /** Review 4 **/
        JLabel label_3 = null;
        try {
            if (row + 3 >= eventsListener.getReviewsByID(game).getRowCount()) {

                JTable table = new JTable(eventsListener.getReviewsByID(game));
                String a = String.valueOf(eventsListener.getReviewsByID(game).getValueAt(row + 3, 1));

                int voteInt = Integer.parseInt(table.getValueAt(row + 3, 3).toString());

                // Get the user id
                int b = Integer.parseInt(a);

                // Create a new label
                label_3 = new JLabel(UserManagement.getUsername(b));

                // Attenzione a modificare perchè le List,ImageIcon e ip sotto ereditano le dichiarazioni fatte nella prima starRating
                JPanel panel_7 = new JPanel();
                panel_7.setToolTipText("Valutazione");
                panel_7.setBounds(384, 468, 311, 45);

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
                lb.setLevel(voteInt - 1);
                frmUntitledGaming.getContentPane().add(panel_7);

                JButton btnGioca_2 = new JButton("Leggi Commento");
                btnGioca_2.setToolTipText("Leggi Commento");
                btnGioca_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_2.setBounds(710, 475, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_2);

                JPanel panel_3 = new JPanel();
                panel_3.setBackground(Color.RED);
                panel_3.setBounds(66, 445, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_3);

                btnGioca_2.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, row, b, game);
                    }
                });
            }

            label_3.setHorizontalAlignment(SwingConstants.CENTER);
            label_3.setForeground(Color.DARK_GRAY);
            label_3.setFont(new Font("Oregano", Font.PLAIN, 21));
            label_3.setBounds(166, 475, 211, 30);
            frmUntitledGaming.getContentPane().add(label_3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}