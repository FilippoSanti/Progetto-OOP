package presentation.general;

import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class allGames {

    Utente utente;
    private JFrame frmUntitledGaming;
    int row;

    /* Create the application */
    public allGames(Utente c, int a) {
        this.utente = c;
        this.row = a;
        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setVisible(true);
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Scelta Giochi");
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

        // Go back
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                controller.eventsListener.changePage("logged", utente);

            }
        });


        int fineLista = 0;
        try {
            fineLista = eventsListener.getApprovedReviews().getRowCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int inizioLista = row + 4;
        if ((row + 4) >= fineLista) {inizioLista = fineLista;}

        JLabel lblListaGiochi = new JLabel("Lista Giochi" + "(" + (inizioLista) + " / " + (fineLista) + ")");

        lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
        lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblListaGiochi.setBounds(0, 23, 944, 61);
        frmUntitledGaming.getContentPane().add(lblListaGiochi);

        // Next button
        JButton btnSuccessiva = new JButton("");
        btnSuccessiva.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_next.png")));
        btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
        btnSuccessiva.setToolTipText("Pagina Successiva");
        btnSuccessiva.setBounds(830, 581, 45, 45);

        try {
            if (row +4 >= eventsListener.getGames().getRowCount()) {
                btnSuccessiva.setEnabled(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Next
        frmUntitledGaming.getContentPane().add(btnSuccessiva);

        btnSuccessiva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                new allGames(utente, row + 4);

            }
        });

        // Previous button
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
                new allGames(utente, row - 4);
            }
        });

        // Game 1
        try {

            JTable table   = new JTable(eventsListener.getGames());
            String titolo  = String.valueOf(table.getValueAt(row, 1));
            int    gameID  = controller.eventsListener.getGameIDFromName(titolo);
            
            // Game logo
            JPanel panel = new JPanel();
            panel.setBackground(Color.YELLOW);
            panel.setBounds(65, 83, 90, 90);
            frmUntitledGaming.getContentPane().add(panel);

            JLabel lblNewLabel = new JLabel(titolo);
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setLabelFor(panel);

            JLabel lblInserireQuIl = new JLabel("");
            panel.add(lblInserireQuIl);
            lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 21));
            lblNewLabel.setBounds(172, 112, 375, 31);
            frmUntitledGaming.getContentPane().add(lblNewLabel);

            // Game button
            JButton btnGioca0 = new JButton("Gioca!");
            btnGioca0.setToolTipText("Gioca!");
            btnGioca0.setFont(new Font("MV Boli", Font.ITALIC, 17));
            btnGioca0.setBounds(743, 113, 142, 30);
            frmUntitledGaming.getContentPane().add(btnGioca0);

            // Listener tasto gioca
            btnGioca0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frmUntitledGaming.setVisible(false);
                    eventsListener.changePage(titolo, utente);
                }
            });

            // Button recensioni
            JButton btnRecensioni = new JButton("Recensioni");
            btnRecensioni.setToolTipText("Recensioni");
            btnRecensioni.setFont(new Font("MV Boli", Font.ITALIC, 17));
            btnRecensioni.setBounds(573, 114, 142, 30);
            frmUntitledGaming.getContentPane().add(btnRecensioni);

            // Listener tasto recensioni
            btnRecensioni.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frmUntitledGaming.setVisible(false);
                    new reviewList(utente, 0, gameID);
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Game 2
        try {
            if (row + 1 >= eventsListener.getGames().getRowCount()) {

                // Show an empty label
                JPanel panel_1 = new JPanel();
                JLabel lblNewLabel = new JLabel("Empty");
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_1);

            } else {
                JTable table = new JTable(eventsListener.getGames());
                String titolo1 = String.valueOf(table.getValueAt(row +1 ,1));
                int    gameID  = controller.eventsListener.getGameIDFromName(titolo1);

                // Game logo
                JPanel panel_1 = new JPanel();
                panel_1.setBackground(Color.BLUE);
                panel_1.setBounds(65, 203, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_1);

                JLabel lblNewLabel = new JLabel(titolo1);
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_1);

                JLabel lblInserireQuIl = new JLabel("");
                panel_1.add(lblInserireQuIl);
                lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 21));

                lblNewLabel.setBounds(172, 235, 375, 31);
                frmUntitledGaming.getContentPane().add(lblNewLabel);

                // Game button
                JButton btnGioca = new JButton("Gioca!");
                btnGioca.setToolTipText("Gioca!");
                btnGioca.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca.setBounds(743, 236, 142, 30);
                frmUntitledGaming.getContentPane().add(btnGioca);

                // Button recensioni
                JButton button_2 = new JButton("Recensioni");
                button_2.setToolTipText("Recensioni");
                button_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
                button_2.setBounds(573, 237, 142, 30);
                frmUntitledGaming.getContentPane().add(button_2);

                // Apre la lista recensioni
                button_2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frmUntitledGaming.setVisible(false);
                        new reviewList(utente, 0, gameID);
                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Game 3
        try {

            if (row + 2 >= eventsListener.getGames().getRowCount()) {

                // Show an empty label
                JPanel panel_1 = new JPanel();
                JLabel lblNewLabel = new JLabel("Empty");
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_1);

            } else {
                JTable table = new JTable(eventsListener.getGames());
                String titolo1 = String.valueOf(table.getValueAt(row + 2, 1));
                int    gameID  = controller.eventsListener.getGameIDFromName(titolo1);

                // Game logo
                JPanel panel_2 = new JPanel();
                panel_2.setBackground(Color.GREEN);
                panel_2.setBounds(65, 321, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_2);

                JLabel lblNewLabel = new JLabel(titolo1);
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_2);

                JLabel lblInserireQuIl = new JLabel("");
                panel_2.add(lblInserireQuIl);
                lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 21));
                lblNewLabel.setBounds(172, 350, 375, 31);
                frmUntitledGaming.getContentPane().add(lblNewLabel);

                // Game button
                JButton btnGioca_1 = new JButton("Gioca!");
                btnGioca_1.setToolTipText("Gioca!");
                btnGioca_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_1.setBounds(743, 351, 142, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_1);

                // Button recensioni
                JButton button_1 = new JButton("Recensioni");
                button_1.setToolTipText("Recensioni");
                button_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
                button_1.setBounds(573, 352, 142, 30);
                frmUntitledGaming.getContentPane().add(button_1);

                // Apre la lista recensioni
                button_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frmUntitledGaming.setVisible(false);
                        new reviewList(utente, 0, gameID);
                    }
                });
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Game 4
        try {

            if (row + 3 >= eventsListener.getGames().getRowCount()) {

                // Show an empty label
                JPanel panel_1 = new JPanel();
                JLabel lblNewLabel = new JLabel("Empty");
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_1);

            } else {
                JTable table = new JTable(eventsListener.getGames());
                String titolo1 = String.valueOf(table.getValueAt(row + 3, 1));
                int    gameID  = controller.eventsListener.getGameIDFromName(titolo1);

                // Game logo
                JPanel panel_3 = new JPanel();
                panel_3.setBackground(Color.RED);
                panel_3.setBounds(65, 440, 90, 90);
                frmUntitledGaming.getContentPane().add(panel_3);

                JLabel lblNewLabel = new JLabel(titolo1);
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setLabelFor(panel_3);

                JLabel lblInserireQuIl = new JLabel("");
                panel_3.add(lblInserireQuIl);
                lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 21));
                lblNewLabel.setBounds(172, 469, 375, 31);
                frmUntitledGaming.getContentPane().add(lblNewLabel);

                // Game button
                JButton btnGioca_1 = new JButton("Gioca!");
                btnGioca_1.setToolTipText("Gioca!");
                btnGioca_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_1.setBounds(743, 470, 142, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_1);

                // Button recensioni
                JButton button_1 = new JButton("Recensioni");
                button_1.setToolTipText("Recensioni");
                button_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
                button_1.setBounds(573, 471, 142, 30);
                frmUntitledGaming.getContentPane().add(button_1);

                // Apre la lista recensioni
                button_1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frmUntitledGaming.setVisible(false);
                        new reviewList(utente, 0, gameID);
                    }
                });

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}