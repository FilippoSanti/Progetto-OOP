package presentation.general;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.jar.JarException;

import static controller.eventsListener.addUtente;
import static controller.eventsListener.changePage;

public class registration {

    private JFrame         frmUntitledGaming;
    private JPasswordField passwordField;
    private JTextField     txtNome;
    private JTextField     txtNickname;
    private JTextField     txtCognome;
    private JTextField     txtEmil;
    private JTextField     txtEta;
    private JButton        button;

    /* Create the application */
    public registration() {
        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setVisible(true);

        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setTitle("Untitled Gaming - Register");
        frmUntitledGaming.setBounds(100, 100, 750, 500);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Registrati Qui!");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 30));
        lblNewLabel.setBounds(0, 27, 734, 37);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        txtNome = new JTextField();
        txtNome.setToolTipText("Nome");
        txtNome.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                System.out.println("Enter Name");
            }
        });
        txtNome.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtNome.setForeground(Color.GRAY);
        txtNome.setText("Nome");
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        txtNome.setBounds(91, 102, 190, 40);
        frmUntitledGaming.getContentPane().add(txtNome);
        txtNome.setColumns(10);

        JButton btnNewButton = new JButton("Registarti");
        btnNewButton.setToolTipText("Registrati");
        btnNewButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                btnNewButton.addActionListener(new ActionListener()
                {
                    String passText = new String(passwordField.getPassword());

                    public void actionPerformed(ActionEvent e)  {
                        frmUntitledGaming.dispose();
                        try {
                            addUtente(txtNickname.getText(), txtNome.getText(), txtCognome.getText(), passText,
                                    txtEmil.getText(), "user");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                });;
            }
        });
        btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
        btnNewButton.setBounds(299, 377, 133, 37);
        frmUntitledGaming.getContentPane().add(btnNewButton);

        txtNickname = new JTextField();
        txtNickname.setToolTipText("Username");
        txtNickname.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtNickname.setForeground(Color.GRAY);
        txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
        txtNickname.setText("Username");
        txtNickname.setBounds(481, 102, 190, 40);
        frmUntitledGaming.getContentPane().add(txtNickname);
        txtNickname.setColumns(10);

        txtCognome = new JTextField();
        txtCognome.setToolTipText("Cognome");
        txtCognome.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtCognome.setForeground(Color.GRAY);
        txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
        txtCognome.setText("Cognome");
        txtCognome.setBounds(91, 191, 190, 40);
        frmUntitledGaming.getContentPane().add(txtCognome);
        txtCognome.setColumns(10);

        txtEmil = new JTextField();
        txtEmil.setToolTipText("E-m@il");
        txtEmil.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtEmil.setForeground(Color.GRAY);
        txtEmil.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmil.setText("e-mail");
        txtEmil.setBounds(481, 191, 190, 40);
        frmUntitledGaming.getContentPane().add(txtEmil);
        txtEmil.setColumns(10);

        txtEta = new JTextField();
        txtEta.setToolTipText("Et\u00E0");
        txtEta.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtEta.setForeground(Color.GRAY);
        txtEta.setText("Et\u00E0");
        txtEta.setHorizontalAlignment(SwingConstants.CENTER);
        txtEta.setBounds(91, 285, 190, 40);
        frmUntitledGaming.getContentPane().add(txtEta);
        txtEta.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("Georgia", Font.ITALIC, 15));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setForeground(Color.GRAY);
        passwordField.setBounds(481, 285, 190, 40);
        frmUntitledGaming.getContentPane().add(passwordField);

        button = new JButton("");
        button.setIcon(new ImageIcon("/img/back_icon.png"));
        button.setToolTipText("Go back");
        button.setBounds(10, 10, 37, 31);

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                changePage("startPage");
            }
        });

        frmUntitledGaming.getContentPane().add(button);
    }
}
