package presentation.general;

import business.BusinessException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


import static controller.eventsListener.newUser;
import static controller.eventsListener.changePage;


public class registration {

    private JFrame frmUntitledGaming;
    private JPasswordField passwordField;
    private JTextField txtNome;
    private JTextField txtNickname;
    private JTextField txtCognome;
    private JTextField txtEmil;
    private JTextField txtDate;
    private JButton button;

    /* Create the application */
    public registration() {

        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/general/imgs/UG_silver_logo.png"));
        frmUntitledGaming.setVisible(true);
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setTitle("Untitled Gaming - Registrati");
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JLabel lblNewLabel = new JLabel("Registrati Qui!");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblNewLabel.setBounds(0, 48, 944, 61);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        txtNome = new JTextField();
        txtNome.setToolTipText("Nome ");

        // Listen for focus
		txtNome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

			    txtNome.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtNome.getText().isEmpty())
					txtNome.setText("Nome ");
			}
		});

        txtNome.setFont(new Font("Georgia", Font.ITALIC, 20));
        txtNome.setForeground(Color.GRAY);
        txtNome.setText("Nome ");
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        txtNome.setBounds(136, 170, 280, 60);
        frmUntitledGaming.getContentPane().add(txtNome);
        txtNome.setColumns(10);

        JButton btnNewButton = new JButton("Registrati");
        btnNewButton.setToolTipText("Registrati");
        btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 18));
        btnNewButton.setBounds(397, 566, 150, 45);
        frmUntitledGaming.getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String dateText  = txtDate.getText();
                    String passText  = new String(passwordField.getPassword());
                    int img_value    = 0;

                    // Check if every field id empty
                    if (txtNickname.getText().equals("Username ") || txtNome.getText().equals("Nome ") ||
                            txtCognome.getText().equals("Cognome ") || txtEmil.getText().equals("e-mail ") ||
                            txtDate.getText().equals("Data di Nascita ") || passText.equals("Password ")) {
                        throw new BusinessException("Assicurati di riempire tutti i campi!");
                    }

                    // Check for the dd/MM/yyyy format (with slashes) and replace the characters
                    if (dateText.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        dateText = dateText.replaceAll("/", "-");
                    }

                    // Check again if the date format is valid (dd-MM-yyyy)
                    if (!dateText.matches("\\d{2}-\\d{2}-\\d{4}")) {
                        throw new BusinessException("Il formato della data non è valido (formati accettati: gg-mm-yyyy oppure gg/mm/yyy)");
                    }

                    // Check if the password is at least 6 characters
                    if (passText.length() < 6) {
                        throw new BusinessException("La password deve contenere almeno 6 caratteri");
                    }

                    // Validate the email field
                    if (!business.implementation.DBManager.isValidEmailAddress(txtEmil.getText())) {
                        throw new BusinessException("Inserisci un indirizzo email valido");
                    }

                    frmUntitledGaming.dispose();
                    newUser(txtNickname.getText(), passText, txtNome.getText(), txtCognome.getText(),
                            txtEmil.getText(), dateText, img_value,"user");
                    changePage("startPage", null);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        txtNickname = new JTextField();
        txtNickname.setToolTipText("Username ");

        //listen for focus
        txtNickname.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			    txtNickname.setText("");
			}

			public void focusLost (FocusEvent e){
				if (txtNickname.getText().isEmpty())
					txtNickname.setText("Username ");
			}
		});
		
        txtNickname.setFont(new Font("Georgia", Font.ITALIC, 20));
        txtNickname.setForeground(Color.GRAY);
        txtNickname.setText("Username ");
        txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
        txtNickname.setBounds(526, 170, 280, 60);
        frmUntitledGaming.getContentPane().add(txtNickname);
        txtNickname.setColumns(10);

        txtCognome = new JTextField();
        txtCognome.setToolTipText("Cognome ");

        // Listen for focus
        txtCognome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

			    txtCognome.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtCognome.getText().isEmpty())
					txtCognome.setText("Cognome ");
			}
		});
		
        txtCognome.setFont(new Font("Georgia", Font.ITALIC, 20));
        txtCognome.setForeground(Color.GRAY);
        txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
        txtCognome.setText("Cognome ");
        txtCognome.setBounds(136, 304, 280, 60);
        frmUntitledGaming.getContentPane().add(txtCognome);
        txtCognome.setColumns(10);

        txtEmil = new JTextField();
        txtEmil.setToolTipText("E-mail ");

        //listen for focus
        txtEmil.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

			    txtEmil.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtEmil.getText().isEmpty())
					txtEmil.setText("E-mail ");
			}
		});
		
        txtEmil.setFont(new Font("Georgia", Font.ITALIC, 20));
        txtEmil.setForeground(Color.GRAY);
        txtEmil.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmil.setText("e-mail ");
        txtEmil.setBounds(526, 307, 280, 60);
        frmUntitledGaming.getContentPane().add(txtEmil);
        txtEmil.setColumns(10);

        txtDate = new JTextField();
        txtDate.setToolTipText("Formato data dd/mm/yyyy");

        //listen for focus
        txtDate.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtDate.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtDate.getText().isEmpty())
					txtDate.setText("Data di Nascita ");
			}
		});
		
        txtDate.setFont(new Font("Georgia", Font.ITALIC, 20));
        txtDate.setForeground(Color.GRAY);
        txtDate.setText("Data di Nascita ");
        txtDate.setHorizontalAlignment(SwingConstants.CENTER);
        txtDate.setBounds(136, 433, 280, 60);
        frmUntitledGaming.getContentPane().add(txtDate);
        txtDate.setColumns(10);

   		passwordField = new JPasswordField();
		char c = 0;
		
		
		passwordField.setText("Password ");
		passwordField.setEchoChar(c);

        passwordField.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
            	
            char c = '\u25CF';
                passwordField.setEchoChar(c);
                passwordField.setText("");
            }
            
            public void focusLost(FocusEvent e) {
            	if (passwordField.getPassword().length == 0){
            		  char c = 0;
                      passwordField.setEchoChar(c);
                      passwordField.setText("Password ");
            		}
                }


        });
		
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setToolTipText("La password deve contenere almeno 6 caratteri");
		
		passwordField.setFont(new Font("Georgia", Font.ITALIC, 20));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(526, 433, 280, 60);
		frmUntitledGaming.getContentPane().add(passwordField);
		

        button = new JButton("");
        button.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        button.setToolTipText("Torna indietro");
        button.setBounds(10, 11, 45, 45);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                changePage("startPage", null);
            }
        });

        frmUntitledGaming.getContentPane().add(button);
    }
}