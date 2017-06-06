package presentation.general;

import controller.eventsListener;

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

        // Listen for focus
		txtNome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtNome.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtNome.getText().isEmpty())
					txtNome.setText("Nome");
			}
		});

        txtNome.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtNome.setForeground(Color.GRAY);
        txtNome.setText("Nome");
        txtNome.setHorizontalAlignment(SwingConstants.CENTER);
        txtNome.setBounds(91, 102, 190, 40);
        frmUntitledGaming.getContentPane().add(txtNome);
        txtNome.setColumns(10);

        // Listen for focus
        txtNome.addFocusListener(new FocusListener() {

            @Override
            // Empty the text field when it receives focus
            public void focusGained(FocusEvent e) {
                txtNome.setText(null);
            }

            @Override
            // Do something when the focus id lost
            public void focusLost(FocusEvent e) {
            }
        });

        JButton btnNewButton = new JButton("Registrati");
        btnNewButton.setToolTipText("Registrati");

        btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
        btnNewButton.setBounds(299, 377, 133, 37);
        frmUntitledGaming.getContentPane().add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                try {
                    String passText = new String(passwordField.getPassword());
                    newUser(txtNickname.getText(), txtNome.getText(), txtCognome.getText(), passText,
                            txtEmil.getText(), txtDate.getText(),"user");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        txtNickname = new JTextField();
        txtNickname.setToolTipText("Username");

        //listen for focus
        txtNickname.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtNickname.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtNickname.getText().isEmpty())
					txtNickname.setText("Username");
			}
		});
		
        txtNickname.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtNickname.setForeground(Color.GRAY);
        txtNickname.setText("username");
        txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
        txtNickname.setBounds(481, 102, 190, 40);
        frmUntitledGaming.getContentPane().add(txtNickname);
        txtNickname.setColumns(10);

        // Listen for focus
        txtNickname.addFocusListener(new FocusListener() {

            @Override
            // Empty the text field when it receives focus
            public void focusGained(FocusEvent e) {
                txtNickname.setText(null);
            }

            @Override
            // Do something when the focus id lost
            public void focusLost(FocusEvent e) {
            }
        });

        txtCognome = new JTextField();
        txtCognome.setToolTipText("Cognome");

        //listen for focus
        txtCognome.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtCognome.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtCognome.getText().isEmpty())
					txtCognome.setText("Cognome");
			}
		});
		
        txtCognome.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtCognome.setForeground(Color.GRAY);
        txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
        txtCognome.setText("Cognome");
        txtCognome.setBounds(91, 191, 190, 40);
        frmUntitledGaming.getContentPane().add(txtCognome);
        txtCognome.setColumns(10);

        // Listen for focus
        txtCognome.addFocusListener(new FocusListener() {

            @Override
            // Empty the text field when it receives focus
            public void focusGained(FocusEvent e) {
                txtCognome.setText(null);
            }

            @Override
            // Do something when the focus id lost
            public void focusLost(FocusEvent e) {
            }
        });

        txtEmil = new JTextField();
        txtEmil.setToolTipText("E-mail");

        //listen for focus
        txtEmil.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtEmil.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtEmil.getText().isEmpty())
					txtEmil.setText("E-m@il");
			}
		});
		
        txtEmil.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtEmil.setForeground(Color.GRAY);
        txtEmil.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmil.setText("e-mail");
        txtEmil.setBounds(481, 191, 190, 40);
        frmUntitledGaming.getContentPane().add(txtEmil);
        txtEmil.setColumns(10);

        // Listen for focus
        txtEmil.addFocusListener(new FocusListener() {

            @Override
            // Empty the text field when it receives focus
            public void focusGained(FocusEvent e) {
                txtEmil.setText(null);
            }

            @Override
            // Do something when the focus id lost
            public void focusLost(FocusEvent e) {
            }
        });

        txtDate = new JTextField();
        txtDate.setToolTipText("Data di nascita");

        //listen for focus
        txtDate.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtDate.setText("");
			}
			public void focusLost (FocusEvent e){
				if (txtDate.getText().isEmpty())
					txtDate.setText("Data di nascita");
			}
		});
		
        txtDate.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtDate.setForeground(Color.GRAY);
        txtDate.setText("Data di nascita");
        txtDate.setHorizontalAlignment(SwingConstants.CENTER);
        txtDate.setBounds(91, 285, 190, 40);
        frmUntitledGaming.getContentPane().add(txtDate);
        txtDate.setColumns(10);

        // Listen for focus
        txtDate.addFocusListener(new FocusListener() {

            @Override
            // Empty the text field when it receives focus
            public void focusGained(FocusEvent e) {
                txtDate.setText(null);
            }

            @Override
            // Do something when the focus id lost
            public void focusLost(FocusEvent e) {
            }
        });

   		passwordField = new JPasswordField();
		char c = 0;
		
		
		passwordField.setText("Password");
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
                      passwordField.setText("Password");
            		}
                }


        });
		
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

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                changePage("startPage", null);
            }
        });

        frmUntitledGaming.getContentPane().add(button);
    }
}
