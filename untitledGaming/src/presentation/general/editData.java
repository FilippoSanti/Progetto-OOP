package presentation.general;

import business.implementation.DBManager;
import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class editData {

    Utente utente = null;
    private JFrame         frmUntitledGaming;
    private JButton        button;
    private JTextField     textField;
    private JTextField     textField_1;
    private JTextField     textField_2;
    private JPasswordField passwordField;
    private JTextField     textField_3;
    private JTextField     textField_4;
    private JLabel         lblModificaITuoi;
    public editData(Utente c) {

        this.utente = c;
        initialize();
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Modifica Dati");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        lblModificaITuoi = new JLabel("Modifica i Tuoi Dati:");
        lblModificaITuoi.setHorizontalAlignment(SwingConstants.CENTER);
        lblModificaITuoi.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblModificaITuoi.setBounds(0, 48, 944, 61);
        frmUntitledGaming.getContentPane().add(lblModificaITuoi);



        button = new JButton("");
        button.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\back-icon.png"));
        button.setToolTipText("torna indietro");
        button.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(button);

        button.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                eventsListener.changePage("profile", utente);

            }
        });

       textField = new JTextField();
       textField.setToolTipText("Nome");
        
        //listen for focus
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                textField.setText("");
            }
            public void focusLost (FocusEvent e){
                if (textField.getText().isEmpty())
                    textField.setText("Nome");
            }
        });
        
       textField.setText(utente.getNome());
       textField.setHorizontalAlignment(SwingConstants.CENTER);
       textField.setForeground(Color.GRAY);
       textField.setFont(new Font("Georgia", Font.ITALIC, 20));
       textField.setColumns(10);
       textField.setBounds(136, 170, 280, 60);
       frmUntitledGaming.getContentPane().add(textField);

       textField_1 = new JTextField();
       textField_1.setToolTipText("Cognome");
        
        //listen for focus
        textField_1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                textField_1.setText("");
            }
            public void focusLost (FocusEvent e){
                if (textField_1.getText().isEmpty())
                    textField_1.setText("Cognome");
            }
       });
        
        textField_1.setText(utente.getCognome());
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setForeground(Color.GRAY);
        textField_1.setFont(new Font("Georgia", Font.ITALIC, 20));
        textField_1.setColumns(10);
        textField_1.setBounds(136, 304, 280, 60);
        frmUntitledGaming.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setToolTipText("Data di Nascita");
        
        //listen for focus
        textField_2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                textField_2.setText("");
            }
            public void focusLost (FocusEvent e){
                if (textField_2.getText().isEmpty())
                    textField_2.setText("Data di Nascita");
            }
        });

        String dataFinale = DBManager.formatSqlDateString(utente.getData().toString());

        textField_2.setText(dataFinale);
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setForeground(Color.GRAY);
        textField_2.setFont(new Font("Georgia", Font.ITALIC, 20));
        textField_2.setColumns(10);
        textField_2.setBounds(136, 433, 280, 60);
        frmUntitledGaming.getContentPane().add(textField_2);
        
        passwordField = new JPasswordField();
        char c = 0;
        
        passwordField.setText("Password");
        passwordField.setEchoChar(c);
        
        //listen for focus
        passwordField.addFocusListener(new FocusListener(){
            
            public void focusGained(FocusEvent e){
                char c = '\u25CF';
                passwordField.setEchoChar(c);
                passwordField.setText("");
            }
            
            public void focusLost(FocusEvent e) {
                if(passwordField.getPassword().length == 0){
                    char c= 0;
                    passwordField.setEchoChar(c);
                    passwordField.setText("Password");
                }
                
            }
            
        });
        
        passwordField.setToolTipText("Password");
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("Georgia", Font.ITALIC, 20));
        passwordField.setBackground(Color.WHITE);
        passwordField.setBounds(526, 433, 280, 60);
        frmUntitledGaming.getContentPane().add(passwordField);
        
        textField_3 = new JTextField();
        textField_3.setToolTipText("E-m@il");
        
        //listen for focus
        textField_3.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                textField_3.setText("");
            }
            public void focusLost (FocusEvent e){
                if (textField_3.getText().isEmpty())
                    textField_3.setText("E-m@il");
            }
        });
                
        textField_3.setText(utente.getEmail());
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setForeground(Color.GRAY);
        textField_3.setFont(new Font("Georgia", Font.ITALIC, 20));
        textField_3.setColumns(10);
        textField_3.setBounds(526, 304, 280, 60);
        frmUntitledGaming.getContentPane().add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setToolTipText("Username");
        
        //listen for focus
        textField_4.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                textField_4.setText("");
            }
            public void focusLost (FocusEvent e){
                if (textField_4.getText().isEmpty())
                    textField_4.setText("Username");
            }
        });
        
        textField_4.setText(utente.getUsername());
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setForeground(Color.GRAY);
        textField_4.setFont(new Font("Georgia", Font.ITALIC, 20));
        textField_4.setColumns(10);
        textField_4.setBounds(526, 170, 280, 60);
        frmUntitledGaming.getContentPane().add(textField_4);
        

        JButton button_1 = new JButton("Applica Modifiche");
        button_1.setToolTipText("Applica Modifiche");
        button_1.setFont(new Font("MV Boli", Font.ITALIC, 18));
        button_1.setBounds(342, 566, 260, 46);
        frmUntitledGaming.getContentPane().add(button_1);

        button_1.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                try {

                    String passText = new String(passwordField.getPassword());
                    eventsListener.setUtente(eventsListener.getUtente(utente.getUsername()), textField.getText(), textField_1.getText(), textField_2.getText(),
                            textField_3.getText(), passText, textField_4.getText());

                    eventsListener.changePage("profile", utente);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

        frmUntitledGaming.setVisible(true);
    }
}
