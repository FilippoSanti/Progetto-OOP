package presentation.general;

import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import static java.sql.Types.NULL;


public class startPage {
    Utente utente = null;
    private JFrame frmUntitledGaming;
    private JTextField txtUsername;
    private JPasswordField passwordField;
    /* Create the application */
    public startPage() {


        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {

        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
        frmUntitledGaming.setTitle("Untitled Gaming");
        frmUntitledGaming.setResizable(false);

        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Untitled Gaming");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblNewLabel.setBounds(0, 60, 944, 61);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        txtUsername = new JTextField();
        txtUsername.setToolTipText("E-mail");

        //listen for focus
        txtUsername.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                txtUsername.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().isEmpty())
                    txtUsername.setText("E-mail");
            }
        });

        txtUsername.setText("E-mail");
        txtUsername.setFont(new Font("Georgia", Font.ITALIC, 20));
        txtUsername.setForeground(Color.GRAY);
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        txtUsername.setBounds(94, 222, 280, 60);
        txtUsername.setColumns(10);
        frmUntitledGaming.getContentPane().add(txtUsername);

        JButton btnNewButton = new JButton("Log In");
        btnNewButton.setToolTipText("Log In");
        btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 19));
        btnNewButton.setBounds(179, 492, 110, 35);

        // Rquest the focus to unfocus the text
        btnNewButton.requestFocusInWindow();

        // Login
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String passText = new String(passwordField.getPassword());

                    // Check if the login was successful
                    if (eventsListener.userAuth(txtUsername.getText(), passText)) {
                        Utente utente = eventsListener.getUtente(txtUsername.getText());
                        eventsListener.changePage("logged", utente);
                        frmUntitledGaming.dispose();
                    } else JOptionPane.showMessageDialog(frmUntitledGaming, "Login failed");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frmUntitledGaming.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Registrati");
        btnNewButton_1.setToolTipText("Registrati");
        btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 22));
        btnNewButton_1.setBounds(596, 293, 216, 50);

        // Go to the registration page
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                eventsListener.changePage("registration", null);
            }
        });

        frmUntitledGaming.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("Se non sei ancora");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 15));
        lblNewLabel_1.setBounds(596, 376, 216, 24);
        frmUntitledGaming.getContentPane().add(lblNewLabel_1);

        JLabel lblRegistratoPuoiFarlo = new JLabel("registrato puoi farlo");
        lblRegistratoPuoiFarlo.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistratoPuoiFarlo.setFont(new Font("Georgia", Font.ITALIC, 15));
        lblRegistratoPuoiFarlo.setBounds(596, 411, 216, 24);
        frmUntitledGaming.getContentPane().add(lblRegistratoPuoiFarlo);

        JLabel lblQui = new JLabel("qui!");
        lblQui.setHorizontalAlignment(SwingConstants.CENTER);
        lblQui.setFont(new Font("Georgia", Font.ITALIC, 15));
        lblQui.setBounds(596, 446, 216, 24);
        frmUntitledGaming.getContentPane().add(lblQui);

        passwordField = new JPasswordField();
        char c = 0;

        passwordField.setText("Password");
        passwordField.setEchoChar(c);

        //listen for focus
        passwordField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                char c ='\u25CF';
                passwordField.setEchoChar(c);
                passwordField.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0){
                    char c = 0;
                    passwordField.setEchoChar(c);
                    passwordField.setText("Password");
                }
            }
        });

        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("Georgia", Font.ITALIC, 20));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setForeground(Color.GRAY);
        passwordField.setBounds(94, 365, 280, 60);
        frmUntitledGaming.getContentPane().add(passwordField);

        frmUntitledGaming.setVisible(true);

        // frmUntitledGaming.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmUntitledGaming.getContentPane(), lblNewLabel, txtIndirizzoEmil, btnNewButton, btnNewButton_1, lblNewLabel_1, lblRegistratoPuoiFarlo, lblQui, passwordField}));
    }

}





