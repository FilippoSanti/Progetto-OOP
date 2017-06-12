import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class gameList {

	private JFrame frmUntitledGaming;

	/**
	 * Create the application.
	 */
	public gameList() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameList window = new gameList();
					window.frmUntitledGaming.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Lista Giochi");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		frmUntitledGaming.setLocationRelativeTo(null);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("imgs/back-icon.png"));
		button.setToolTipText("torna indietro");
		button.setBounds(10, 11, 45, 45);
		frmUntitledGaming.getContentPane().add(button);

		JLabel lblListaGiochi = new JLabel("Lista Giochi");
		lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblListaGiochi.setBounds(0, 23, 944, 61);
		frmUntitledGaming.getContentPane().add(lblListaGiochi);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(98, 87, 90, 90);
		frmUntitledGaming.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(98, 207, 90, 90);
		frmUntitledGaming.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(98, 325, 90, 90);
		frmUntitledGaming.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		panel_3.setBounds(98, 444, 90, 90);
		frmUntitledGaming.getContentPane().add(panel_3);

		JLabel lblNewLabel = new JLabel("-Titolo 1-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(panel);
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 21));
		lblNewLabel.setBounds(235, 117, 406, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel);

		JLabel lbltitolo = new JLabel("-Titolo 2-");
		lbltitolo.setLabelFor(panel_1);
		lbltitolo.setFont(new Font("Georgia", Font.ITALIC, 21));
		lbltitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitolo.setBounds(235, 240, 406, 31);
		frmUntitledGaming.getContentPane().add(lbltitolo);

		JLabel lbltitolo_1 = new JLabel("-Titolo 3-");
		lbltitolo_1.setLabelFor(panel_2);
		lbltitolo_1.setFont(new Font("Georgia", Font.ITALIC, 21));
		lbltitolo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitolo_1.setBounds(235, 355, 406, 31);
		frmUntitledGaming.getContentPane().add(lbltitolo_1);

		JLabel lbltitolo_2 = new JLabel("-Titolo 4-");
		lbltitolo_2.setLabelFor(panel_3);
		lbltitolo_2.setFont(new Font("Georgia", Font.ITALIC, 21));
		lbltitolo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitolo_2.setBounds(235, 473, 406, 31);
		frmUntitledGaming.getContentPane().add(lbltitolo_2);

		JButton btnTornaAllaHome = new JButton("Torna alla Home");
		btnTornaAllaHome.setToolTipText("Torna alla Home");
		btnTornaAllaHome.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnTornaAllaHome.setBounds(378, 581, 180, 35);
		frmUntitledGaming.getContentPane().add(btnTornaAllaHome);

		JButton btnSuccessiva = new JButton("");
		btnSuccessiva.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Rounded_next.png"));
		btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
		btnSuccessiva.setToolTipText("Pagina Successiva");
		btnSuccessiva.setBounds(830, 581, 45, 45);
		frmUntitledGaming.getContentPane().add(btnSuccessiva);

		JButton btnRecensione = new JButton("Recensione");
		btnRecensione.setToolTipText("Recensione");
		btnRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnRecensione.setBounds(706, 118, 142, 30);
		frmUntitledGaming.getContentPane().add(btnRecensione);

		JButton button_1 = new JButton("Recensione");
		button_1.setToolTipText("Recensione");
		button_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_1.setBounds(706, 241, 142, 30);
		frmUntitledGaming.getContentPane().add(button_1);

		JButton button_2 = new JButton("Recensione");
		button_2.setToolTipText("Recensione");
		button_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_2.setBounds(706, 356, 142, 30);
		frmUntitledGaming.getContentPane().add(button_2);

		JButton button_3 = new JButton("Recensione");
		button_3.setToolTipText("Recensione");
		button_3.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_3.setBounds(706, 474, 142, 30);
		frmUntitledGaming.getContentPane().add(button_3);

		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Rounded_back_1.png"));
		button_4.setToolTipText("Pagina Precedente");
		button_4.setFont(new Font("MV Boli", Font.ITALIC, 13));
		button_4.setBounds(68, 581, 45, 45);
		frmUntitledGaming.getContentPane().add(button_4);
	}
}
