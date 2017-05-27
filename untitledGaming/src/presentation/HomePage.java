import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class HomePage {
	
	private JFrame frmUntitledGaming;
	private JTextField txtIndirizzoEmil;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmUntitledGaming.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Bar_Logo.png"));
		frmUntitledGaming.setTitle("   Untitled Gaming");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 750, 500);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Untitled Gaming");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 27, 734, 38);
		frmUntitledGaming.getContentPane().add(lblNewLabel);
		
		txtIndirizzoEmil = new JTextField();
		txtIndirizzoEmil.setToolTipText("Indirizzo E-m@il");
		txtIndirizzoEmil.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtIndirizzoEmil.setForeground(Color.GRAY);
		txtIndirizzoEmil.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndirizzoEmil.setText("Indirizzo E-m@il");
		txtIndirizzoEmil.setBounds(71, 157, 200, 38);
		frmUntitledGaming.getContentPane().add(txtIndirizzoEmil);
		txtIndirizzoEmil.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setToolTipText("Log In");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton.setBounds(116, 338, 110, 35);
		frmUntitledGaming.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.setToolTipText("Registrati");
		btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton_1.setBounds(503, 223, 110, 35);
		frmUntitledGaming.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Se non sei ancora");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(488, 284, 149, 14);
		frmUntitledGaming.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRegistratoPuoiFarlo = new JLabel("registrato puoi farlo");
		lblRegistratoPuoiFarlo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistratoPuoiFarlo.setFont(new Font("Georgia", Font.ITALIC, 11));
		lblRegistratoPuoiFarlo.setBounds(488, 304, 149, 14);
		frmUntitledGaming.getContentPane().add(lblRegistratoPuoiFarlo);
		
		JLabel lblQui = new JLabel("qui!");
		lblQui.setHorizontalAlignment(SwingConstants.CENTER);
		lblQui.setFont(new Font("Georgia", Font.ITALIC, 11));
		lblQui.setBounds(488, 324, 149, 14);
		frmUntitledGaming.getContentPane().add(lblQui);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setToolTipText("Password");
		passwordField.setFont(new Font("Georgia", Font.ITALIC, 15));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(71, 242, 200, 38);
		frmUntitledGaming.getContentPane().add(passwordField);
		//frmUntitledGaming.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmUntitledGaming.getContentPane(), lblNewLabel, txtIndirizzoEmil, btnNewButton, btnNewButton_1, lblNewLabel_1, lblRegistratoPuoiFarlo, lblQui, passwordField}));
	}
}
