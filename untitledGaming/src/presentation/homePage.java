package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class homePage {

	private JFrame frame;
	private JTextField txtIndirizzoEmil;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homePage window = new homePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public homePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Untitled Gaming");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 27, 734, 38);
		frame.getContentPane().add(lblNewLabel);
		
		txtIndirizzoEmil = new JTextField();
		txtIndirizzoEmil.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtIndirizzoEmil.setForeground(Color.GRAY);
		txtIndirizzoEmil.setHorizontalAlignment(SwingConstants.CENTER);
		txtIndirizzoEmil.setText("Indirizzo E-m@il");
		txtIndirizzoEmil.setBounds(71, 157, 200, 38);
		frame.getContentPane().add(txtIndirizzoEmil);
		txtIndirizzoEmil.setColumns(10);

		JButton btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton_1.setBounds(503, 223, 110, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Se non sei ancora");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(503, 284, 110, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblRegistratoPuoiFarlo = new JLabel("registrato puoi farlo");
		lblRegistratoPuoiFarlo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistratoPuoiFarlo.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblRegistratoPuoiFarlo.setBounds(503, 304, 110, 14);
		frame.getContentPane().add(lblRegistratoPuoiFarlo);
		
		JLabel lblQui = new JLabel("qui!");
		lblQui.setHorizontalAlignment(SwingConstants.CENTER);
		lblQui.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblQui.setBounds(503, 324, 110, 14);
		frame.getContentPane().add(lblQui);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setToolTipText("Password");
		passwordField.setFont(new Font("Georgia", Font.ITALIC, 15));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(71, 242, 200, 38);
		frame.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton.setBounds(116, 338, 110, 35);
		frame.getContentPane().add(btnNewButton);


	}
}


