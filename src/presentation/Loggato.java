import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Loggato {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loggato window = new Loggato();
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
	public Loggato() {
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
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Hello,");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Oregano", Font.PLAIN, 15));
		lblNewLabel.setBounds(573, 22, 38, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("__________");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("Oregano", Font.PLAIN, 15));
		label_1.setBounds(609, 25, 115, 19);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("Untitled Gaming");
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 68, 734, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Il Tuo Profilo");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnNewButton.setBounds(82, 232, 174, 64);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gioca Ora");
		btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnNewButton_1.setBounds(471, 232, 174, 64);
		frame.getContentPane().add(btnNewButton_1);
	}
}
