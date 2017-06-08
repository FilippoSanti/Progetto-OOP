package presentation.general;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class evalutateReview {

	private JFrame frmUntitledGaming;

	/**
	 * Create the application.
	 */
	public evalutateReview() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					evalutateReview window = new evalutateReview();
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
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Valuta Commenti");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		frmUntitledGaming.setLocationRelativeTo(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\back_icon.png"));
		button.setToolTipText("torna indietro");
		button.setBounds(10, 11, 45, 45);
		frmUntitledGaming.getContentPane().add(button);
		
		JLabel lblListaGiochi = new JLabel("Valuta Commenti");
		lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblListaGiochi.setBounds(0, 23, 944, 61);
		frmUntitledGaming.getContentPane().add(lblListaGiochi);
		
		JButton btnSuccessiva = new JButton("");
		btnSuccessiva.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Rounded_next.png"));
		btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
		btnSuccessiva.setToolTipText("Pagina Successiva");
		btnSuccessiva.setBounds(830, 581, 45, 45);
		frmUntitledGaming.getContentPane().add(btnSuccessiva);
		
		JButton btnRecensione = new JButton("Leggi Commento");
		btnRecensione.setToolTipText("Leggi Commento");
		btnRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnRecensione.setBounds(738, 148, 180, 30);
		frmUntitledGaming.getContentPane().add(btnRecensione);
		
		JButton btnGioca = new JButton("Leggi Commento");
		btnGioca.setToolTipText("Leggi Commento");
		btnGioca.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnGioca.setBounds(738, 271, 180, 30);
		frmUntitledGaming.getContentPane().add(btnGioca);
		
		JButton btnGioca_1 = new JButton("Leggi Commento");
		btnGioca_1.setToolTipText("Leggi Commento");
		btnGioca_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnGioca_1.setBounds(738, 386, 180, 30);
		frmUntitledGaming.getContentPane().add(btnGioca_1);
		
		JButton btnGioca_2 = new JButton("Leggi Commento");
		btnGioca_2.setToolTipText("Leggi Commento");
		btnGioca_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnGioca_2.setBounds(738, 504, 180, 30);
		frmUntitledGaming.getContentPane().add(btnGioca_2);
		
		JButton button_4 = new JButton("");
		button_4.setEnabled(false);
		button_4.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Rounded_back_1.png"));
		button_4.setToolTipText("Pagina Precedente");
		button_4.setFont(new Font("MV Boli", Font.ITALIC, 13));
		button_4.setBounds(68, 581, 45, 45);
		frmUntitledGaming.getContentPane().add(button_4);
		
		JLabel label = new JLabel("-Username Here!-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Oregano", Font.PLAIN, 21));
		label.setBounds(243, 148, 211, 30);
		frmUntitledGaming.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("-Username Here!-");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("Oregano", Font.PLAIN, 21));
		label_1.setBounds(243, 271, 211, 30);
		frmUntitledGaming.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("-Username Here!-");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Oregano", Font.PLAIN, 21));
		label_2.setBounds(243, 386, 211, 30);
		frmUntitledGaming.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("-Username Here!-");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Oregano", Font.PLAIN, 21));
		label_3.setBounds(243, 504, 211, 30);
		frmUntitledGaming.getContentPane().add(label_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("Valutazione");
		panel_4.setBounds(464, 141, 259, 45);
		frmUntitledGaming.getContentPane().add(panel_4);
		
		JLabel lblCancellareLaLabel = new JLabel("cancellare la label e inserire qu\u00EC le stelle");
		panel_4.add(lblCancellareLaLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setToolTipText("Valutazione");
		panel_5.setBounds(464, 265, 259, 45);
		frmUntitledGaming.getContentPane().add(panel_5);
		
		JLabel lblCancellareLaLabel_1 = new JLabel("cancellare la label e inserire qu\u00EC le stelle");
		panel_5.add(lblCancellareLaLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setToolTipText("Valutazione");
		panel_6.setBounds(464, 380, 259, 45);
		frmUntitledGaming.getContentPane().add(panel_6);
		
		JLabel lblCancellareLaLabel_2 = new JLabel("cancellare la label e inserire qu\u00EC le stelle");
		panel_6.add(lblCancellareLaLabel_2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setToolTipText("Valutazione");
		panel_7.setBounds(464, 497, 259, 45);
		frmUntitledGaming.getContentPane().add(panel_7);
		
		JLabel lblCancellareLaLabel_3 = new JLabel("cancellare la label e inserire qu\u00EC le stelle");
		panel_7.add(lblCancellareLaLabel_3);
		
		JLabel lblgamenameHere_2 = new JLabel("-Gamename Here!-");
		lblgamenameHere_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblgamenameHere_2.setForeground(Color.DARK_GRAY);
		lblgamenameHere_2.setFont(new Font("Oregano", Font.PLAIN, 21));
		lblgamenameHere_2.setBounds(22, 148, 211, 30);
		frmUntitledGaming.getContentPane().add(lblgamenameHere_2);
		
		JLabel lblgamenameHere_1 = new JLabel("-Gamename Here!-");
		lblgamenameHere_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblgamenameHere_1.setForeground(Color.DARK_GRAY);
		lblgamenameHere_1.setFont(new Font("Oregano", Font.PLAIN, 21));
		lblgamenameHere_1.setBounds(22, 271, 211, 30);
		frmUntitledGaming.getContentPane().add(lblgamenameHere_1);
		
		JLabel lblgamenameHere = new JLabel("-Gamename Here!-");
		lblgamenameHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblgamenameHere.setForeground(Color.DARK_GRAY);
		lblgamenameHere.setFont(new Font("Oregano", Font.PLAIN, 21));
		lblgamenameHere.setBounds(22, 386, 211, 30);
		frmUntitledGaming.getContentPane().add(lblgamenameHere);
		
		JLabel lblGamenameHere = new JLabel("-Gamename Here!-");
		lblGamenameHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamenameHere.setForeground(Color.DARK_GRAY);
		lblGamenameHere.setFont(new Font("Oregano", Font.PLAIN, 21));
		lblGamenameHere.setBounds(22, 504, 211, 30);
		frmUntitledGaming.getContentPane().add(lblGamenameHere);
		
		JLabel lblNomeDelGioco = new JLabel("Nome del gioco:");
		lblNomeDelGioco.setForeground(Color.LIGHT_GRAY);
		lblNomeDelGioco.setFont(new Font("Georgia", Font.ITALIC, 13));
		lblNomeDelGioco.setBounds(67, 94, 140, 21);
		frmUntitledGaming.getContentPane().add(lblNomeDelGioco);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Georgia", Font.ITALIC, 13));
		lblUsername.setBounds(283, 98, 140, 21);
		frmUntitledGaming.getContentPane().add(lblUsername);
		
		JLabel lblRecensione = new JLabel("Valutazione:");
		lblRecensione.setForeground(Color.LIGHT_GRAY);
		lblRecensione.setFont(new Font("Georgia", Font.ITALIC, 13));
		lblRecensione.setBounds(484, 98, 140, 21);
		frmUntitledGaming.getContentPane().add(lblRecensione);
	}
}