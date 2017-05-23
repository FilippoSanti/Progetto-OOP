import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class Registrazione {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtNickname;
	private JTextField txtCognome;
	private JTextField txtEmil;
	private JTextField txtEt;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione window = new Registrazione();
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
	public Registrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrati Qui!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 27, 734, 37);
		frame.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtNome.setForeground(Color.GRAY);
		txtNome.setText("Nome");
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setBounds(54, 159, 133, 37);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Registarti");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton.setBounds(299, 377, 133, 37);
		frame.getContentPane().add(btnNewButton);
		
		txtNickname = new JTextField();
		txtNickname.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtNickname.setForeground(Color.GRAY);
		txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
		txtNickname.setText("Nickname");
		txtNickname.setBounds(54, 261, 133, 37);
		frame.getContentPane().add(txtNickname);
		txtNickname.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtCognome.setForeground(Color.GRAY);
		txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
		txtCognome.setText("Cognome");
		txtCognome.setBounds(299, 159, 133, 37);
		frame.getContentPane().add(txtCognome);
		txtCognome.setColumns(10);
		
		txtEmil = new JTextField();
		txtEmil.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtEmil.setForeground(Color.GRAY);
		txtEmil.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmil.setText("E-m@il");
		txtEmil.setBounds(299, 261, 133, 37);
		frame.getContentPane().add(txtEmil);
		txtEmil.setColumns(10);
		
		txtEt = new JTextField();
		txtEt.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtEt.setForeground(Color.GRAY);
		txtEt.setText("Et\u00E0");
		txtEt.setHorizontalAlignment(SwingConstants.CENTER);
		txtEt.setBounds(541, 159, 133, 37);
		frame.getContentPane().add(txtEt);
		txtEt.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setText("Password");
		txtPassword.setBounds(541, 261, 133, 37);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
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
}