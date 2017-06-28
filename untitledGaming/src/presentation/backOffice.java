package presentation;

import business.model.Utente;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class backOffice {

	Utente utente;
	private JFrame frmUntitledGaming;
	int row, nPages;
	private JTextField txtaddgame;

	/* Create the application */
	public backOffice(Utente c, int r) {
		this.utente = c;
		this.row = r;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("./src/presentation/imgs/UG_silver_logo.png"));
		frmUntitledGaming.setTitle("Untitled Gaming - BackOffice");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);

		JButton back_btn = new JButton("");
		back_btn.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
		back_btn.setToolTipText("torna indietro");
		back_btn.setFont(new Font("MV Boli", Font.ITALIC, 13));
		back_btn.setBounds(10, 11, 45, 45);
		
		JLabel lblBackoffice = new JLabel("BackOffice");
		lblBackoffice.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackoffice.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblBackoffice.setBounds(0, 37, 944, 61);
		frmUntitledGaming.getContentPane().add(lblBackoffice);

		//button to add game to DB
		JButton btnAggiungiGioco = new JButton("Aggiungi Gioco");
		btnAggiungiGioco.setToolTipText("Aggiungi Gioco");
		btnAggiungiGioco.setFont(new Font("MV Boli", Font.ITALIC, 18));
		btnAggiungiGioco.setBounds(350, 575, 260, 46);
		frmUntitledGaming.getContentPane().add(btnAggiungiGioco);
		
		JLabel lblNomeGioco = new JLabel("Nome Gioco :");
		lblNomeGioco.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeGioco.setForeground(Color.GRAY);
		lblNomeGioco.setFont(new Font("Georgia", Font.ITALIC, 25));
		lblNomeGioco.setBounds(36, 302, 202, 37);
		frmUntitledGaming.getContentPane().add(lblNomeGioco);

		//add the name of the game
		txtaddgame = new JTextField();
		txtaddgame.setHorizontalAlignment(SwingConstants.CENTER);
		txtaddgame.setToolTipText("inserisci qu\u00EC il nome del gioco da inserire");

		//Listen for focus
		txtaddgame.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				txtaddgame.setText("");
			}

			public void focusLost(FocusEvent e) {
				if (txtaddgame.getText().isEmpty())
					txtaddgame.setText("- Nome Gioco da  Inserire -");
			}
		});

		txtaddgame.setText("- Nome Gioco da  Inserire -");
		txtaddgame.setForeground(Color.DARK_GRAY);
		txtaddgame.setFont(new Font("Oregano", Font.PLAIN, 25));
		txtaddgame.setBounds(260, 302, 387, 37);
		frmUntitledGaming.getContentPane().add(txtaddgame);
		txtaddgame.setColumns(10);
	}
}
