import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Profilo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profilo window = new Profilo();
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
	public Profilo() {
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
		
		JLabel lblIlTuoProfilo = new JLabel("Il Tuo Profilo");
		lblIlTuoProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlTuoProfilo.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblIlTuoProfilo.setBounds(0, 26, 734, 37);
		frame.getContentPane().add(lblIlTuoProfilo);
		
		Panel panel = new Panel();
		panel.setBounds(121, 82, 124, 121);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(387, 95, 84, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome :");
		lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(387, 125, 84, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Et\u00E0 :");
		lblNewLabel_2.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(387, 155, 84, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-m@il :");
		lblNewLabel_3.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(387, 180, 84, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Abcdefghijklmno");
		lblNewLabel_4.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_4.setBounds(493, 95, 133, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Abcdefghijklmno");
		lblNewLabel_5.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_5.setBounds(493, 125, 133, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Abcdefghijklmno");
		lblNewLabel_6.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(493, 155, 133, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Abcdefghijklmno");
		lblNewLabel_7.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_7.setBounds(493, 180, 133, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Il Tuo Livello :");
		lblNewLabel_8.setBounds(60, 264, 124, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("I Tuoi Punti XP :");
		lblNewLabel_9.setBounds(60, 299, 124, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Achievements Sbloccati :");
		lblNewLabel_10.setBounds(60, 335, 124, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(194, 299, 146, 14);
		frame.getContentPane().add(progressBar);
		
		JButton btnNewButton = new JButton("I Tuoi Giochi");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(299, 377, 133, 37);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_11 = new JLabel("999");
		lblNewLabel_11.setBounds(194, 264, 46, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(194, 335, 15, 14);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(219, 335, 15, 14);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(249, 335, 15, 14);
		frame.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(274, 335, 15, 14);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(299, 335, 15, 14);
		frame.getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(325, 335, 15, 14);
		frame.getContentPane().add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(350, 335, 15, 14);
		frame.getContentPane().add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(375, 335, 15, 14);
		frame.getContentPane().add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(400, 335, 15, 14);
		frame.getContentPane().add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(425, 335, 15, 14);
		frame.getContentPane().add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(450, 335, 15, 14);
		frame.getContentPane().add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(475, 335, 15, 14);
		frame.getContentPane().add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(500, 335, 15, 14);
		frame.getContentPane().add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(525, 335, 15, 14);
		frame.getContentPane().add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(550, 335, 15, 14);
		frame.getContentPane().add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(575, 335, 15, 14);
		frame.getContentPane().add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(600, 335, 15, 14);
		frame.getContentPane().add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(625, 335, 15, 14);
		frame.getContentPane().add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(650, 335, 15, 14);
		frame.getContentPane().add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(675, 335, 15, 14);
		frame.getContentPane().add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(700, 335, 15, 14);
		frame.getContentPane().add(panel_21);
	}
}
