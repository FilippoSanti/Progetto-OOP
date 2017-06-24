package presentation;

import controller.eventsListener;
import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class usersList {

    private JFrame frmUntitledGaming;
    Utente utente;
    int row;

    /* Create the application */
    public usersList(Utente c, int r) {
        this.utente = c;
        this.row = r;
        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {

        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/imgs/UG_silver_logo.png"));
        frmUntitledGaming.setVisible(true);
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Lista Utenti");
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
                frmUntitledGaming.dispose();
                controller.eventsListener.changePage("logged", utente);

            }
        });


        JLabel lblListaGiochi = null;
        try {
            int fineLista = eventsListener.getUsers().getRowCount();
            int inizioLista = row + 4;
            if ((row + 4) >= fineLista)
                inizioLista = fineLista;
            lblListaGiochi = new JLabel("Lista Utenti" + "(" + (inizioLista) + " / " + (fineLista) + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
        lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblListaGiochi.setBounds(0, 23, 944, 61);
        frmUntitledGaming.getContentPane().add(lblListaGiochi);

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setBounds(65, 83, 90, 90);
        frmUntitledGaming.getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLUE);
        panel_1.setBounds(65, 203, 90, 90);
        frmUntitledGaming.getContentPane().add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.GREEN);
        panel_2.setBounds(65, 321, 90, 90);
        frmUntitledGaming.getContentPane().add(panel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.RED);
        panel_3.setBounds(65, 440, 90, 90);
        frmUntitledGaming.getContentPane().add(panel_3);

        // Utente 1
        String username1 = "";
        try {

            username1 = String.valueOf(eventsListener.getUsers().getValueAt(row, 1));

            JLabel lblNewLabel = new JLabel(username1);
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setLabelFor(panel);

            JLabel lblInserireQuIl = new JLabel("");
            panel.add(lblInserireQuIl);
            lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 21));
            lblNewLabel.setBounds(172, 112, 375, 31);
            frmUntitledGaming.getContentPane().add(lblNewLabel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Utente 2

        String username2 = "";
        try {
            JLabel lbltitolo = null;
            if (row + 1 >= eventsListener.getUsers().getRowCount()) {
                lbltitolo = new JLabel("vuoto");
            } else {

                username2 = String.valueOf(eventsListener.getUsers().getValueAt(row + 1, 1));
                lbltitolo = new JLabel(username2);

                lbltitolo.setLabelFor(panel_1);
                lbltitolo.setFont(new Font("Georgia", Font.ITALIC, 21));
                lbltitolo.setHorizontalAlignment(SwingConstants.CENTER);
                lbltitolo.setBounds(172, 235, 375, 31);
                frmUntitledGaming.getContentPane().add(lbltitolo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //utente 3//

        String username3 = "";
        try {
            JLabel lbltitolo_1 = null;
            if (row + 2 >= eventsListener.getUsers().getRowCount()) {
                lbltitolo_1 = new JLabel("vuoto");
            } else {


                username3 = String.valueOf(String.valueOf(eventsListener.getUsers().getValueAt(row + 2, 1)));
                lbltitolo_1 = new JLabel(username3);
                lbltitolo_1.setLabelFor(panel_2);
                lbltitolo_1.setFont(new Font("Georgia", Font.ITALIC, 21));
                lbltitolo_1.setHorizontalAlignment(SwingConstants.CENTER);
                lbltitolo_1.setBounds(172, 350, 375, 31);
                frmUntitledGaming.getContentPane().add(lbltitolo_1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Utente 4
        String username4 = "";
        try {

            JLabel lbltitolo_2 = null;
            if (row + 3 >= eventsListener.getUsers().getRowCount()) {
                lbltitolo_2 = new JLabel("vuoto");
            } else {

                username4 = String.valueOf(String.valueOf(eventsListener.getUsers().getValueAt(row + 3, 1)));
                lbltitolo_2 = new JLabel(username4);
                lbltitolo_2.setLabelFor(panel_3);
                lbltitolo_2.setFont(new Font("Georgia", Font.ITALIC, 21));
                lbltitolo_2.setHorizontalAlignment(SwingConstants.CENTER);
                lbltitolo_2.setBounds(172, 469, 375, 31);
                frmUntitledGaming.getContentPane().add(lbltitolo_2);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton btnSuccessiva = new JButton("");
        btnSuccessiva.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_next.png")));
        btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
        btnSuccessiva.setToolTipText("Pagina Successiva");
        btnSuccessiva.setBounds(830, 581, 45, 45);
        frmUntitledGaming.getContentPane().add(btnSuccessiva);

        try {
            if (row + 4
                    >= eventsListener.getUsers().getRowCount()) {
                btnSuccessiva.setEnabled(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        frmUntitledGaming.getContentPane().add(btnSuccessiva);


        btnSuccessiva.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                new usersList(utente, row + 4);

            }
        });


        JButton button_4 = new JButton("");
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
                new usersList(utente, row - 4);


            }
        });

        String tipo1 = "";
        String tipo2 = "";
        String tipo3 = "";
        String tipo4 = "";

        try {
            tipo1 = eventsListener.getUserTipo(username1);
            tipo2 = eventsListener.getUserTipo(username2);
            tipo3 = eventsListener.getUserTipo(username3);
            tipo4 = eventsListener.getUserTipo(username4);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JButton btnPromuovi = new JButton("Promuovi");
        btnPromuovi.setBackground(new Color(143, 251, 143));
        btnPromuovi.setForeground(new Color(24, 160, 10));
        btnPromuovi.setToolTipText("Promuovi");
        btnPromuovi.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnPromuovi.setBounds(573, 114, 142, 30);
        frmUntitledGaming.getContentPane().add(btnPromuovi);
        if (tipo1.equals("administrator")) btnPromuovi.setEnabled(false);
        if (tipo1.equals("moderator")) btnPromuovi.setEnabled(false);

        String finalUsername = username1;
        btnPromuovi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToModerator(finalUsername);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button_1 = new JButton("Promuovi");
        button_1.setToolTipText("Promuovi");
        button_1.setForeground(new Color(24, 160, 10));
        button_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
        button_1.setBackground(new Color(143, 251, 143));
        button_1.setBounds(573, 237, 142, 30);
        frmUntitledGaming.getContentPane().add(button_1);
        if (tipo2.equals("administrator")) button_1.setEnabled(false);
        if (tipo2.equals("moderator")) button_1.setEnabled(false);

        String finalUsername2 = username2;
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToModerator(finalUsername2);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button_2 = new JButton("Promuovi");
        button_2.setToolTipText("Promuovi");
        button_2.setForeground(new Color(24, 160, 10));
        button_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
        button_2.setBackground(new Color(143, 251, 143));
        button_2.setBounds(573, 352, 142, 30);
        frmUntitledGaming.getContentPane().add(button_2);

        if (tipo3.equals("administrator")) button_2.setEnabled(false);
        if (tipo3.equals("moderator")) button_2.setEnabled(false);

        String finalUsername3 = username3;
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToModerator(finalUsername3);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button_3 = new JButton("Promuovi");
        button_3.setToolTipText("Promuovi");
        button_3.setForeground(new Color(24, 160, 10));
        button_3.setFont(new Font("MV Boli", Font.ITALIC, 17));
        button_3.setBackground(new Color(143, 251, 143));
        button_3.setBounds(573, 470, 142, 30);
        frmUntitledGaming.getContentPane().add(button_3);

        if (tipo4.equals("administrator")) button_3.setEnabled(false);
        if (tipo4.equals("moderator")) button_3.setEnabled(false);

        String finalUsername4 = username4;
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToModerator(finalUsername4);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton btnDclassa = new JButton("Declassa");
        btnDclassa.setBackground(new Color(240, 142, 126));
        btnDclassa.setForeground(new Color(155, 17, 0));
        btnDclassa.setToolTipText("Declassa");
        btnDclassa.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnDclassa.setBounds(743, 113, 142, 30);
        frmUntitledGaming.getContentPane().add(btnDclassa);

        if (tipo1.equals("user")) btnDclassa.setEnabled(false);
        if (tipo1.equals("administrator")) btnDclassa.setEnabled(false);

        btnDclassa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToUser(finalUsername);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button_5 = new JButton("Declassa");
        button_5.setToolTipText("Declassa");
        button_5.setForeground(new Color(155, 17, 0));
        button_5.setFont(new Font("MV Boli", Font.ITALIC, 17));
        button_5.setBackground(new Color(240, 142, 126));
        button_5.setBounds(743, 235, 142, 30);
        frmUntitledGaming.getContentPane().add(button_5);

        if (tipo2.equals("user")) button_5.setEnabled(false);
        if (tipo2.equals("administrator")) button_5.setEnabled(false);

        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToUser(finalUsername2);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button_6 = new JButton("Declassa");
        button_6.setToolTipText("Declassa");
        button_6.setForeground(new Color(155, 17, 0));
        button_6.setFont(new Font("MV Boli", Font.ITALIC, 17));
        button_6.setBackground(new Color(240, 142, 126));
        button_6.setBounds(743, 351, 142, 30);
        frmUntitledGaming.getContentPane().add(button_6);

        if (tipo3.equals("user")) button_6.setEnabled(false);
        if (tipo3.equals("administrator")) button_6.setEnabled(false);

        button_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToUser(finalUsername3);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton button_7 = new JButton("Declassa");
        button_7.setToolTipText("Declassa");
        button_7.setForeground(new Color(155, 17, 0));
        button_7.setFont(new Font("MV Boli", Font.ITALIC, 17));
        button_7.setBackground(new Color(240, 142, 126));
        button_7.setBounds(743, 469, 142, 30);
        frmUntitledGaming.getContentPane().add(button_7);

        if (tipo4.equals("user")) button_7.setEnabled(false);
        if (tipo4.equals("administrator")) button_7.setEnabled(false);

        button_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    eventsListener.setToUser(finalUsername4);
                    frmUntitledGaming.setVisible(false);
                    new usersList(utente, row);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}