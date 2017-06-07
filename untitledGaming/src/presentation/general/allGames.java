package presentation.general;

import business.model.Utente;
import controller.eventsListener;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class allGames {

	private JFrame frmUntitledGaming;



	Utente utente;

	/**
	 * Create the application.
	 */
	public allGames(Utente c) {

		this.utente=c;
		initialize();
	}


	/* 
	Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setVisible(true);
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Scelta Giochi");
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

		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.dispose();
				controller.eventsListener.changePage("logged", utente);

			}
		});
		
		JLabel lblListaGiochi = new JLabel("Scelta Giochi");
		lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblListaGiochi.setBounds(0, 23, 944, 61);
		frmUntitledGaming.getContentPane().add(lblListaGiochi);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(65, 83, 90, 90);
		frmUntitledGaming.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(65, 203, 90, 90);
		frmUntitledGaming.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(65, 321, 90, 90);
		frmUntitledGaming.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		panel_3.setBounds(65, 440, 90, 90);
		frmUntitledGaming.getContentPane().add(panel_3);

		try {
			JTable table = new JTable(eventsListener.getGames());
			String titolo1 = String.valueOf(table.getValueAt(0, 1));

		JLabel lblNewLabel = new JLabel(titolo1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(panel);

		JLabel lblInserireQuIl = new JLabel("");
		panel.add(lblInserireQuIl);
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 21));
		lblNewLabel.setBounds(172, 112, 375, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel);
	} catch (SQLException e) {
		e.printStackTrace();
	}

		try {
			JTable table = new JTable(eventsListener.getGames());
			String titolo2 = String.valueOf(table.getValueAt(1, 1));
		JLabel lbltitolo = new JLabel(titolo2);
		lbltitolo.setLabelFor(panel_1);
		lbltitolo.setFont(new Font("Georgia", Font.ITALIC, 21));
		lbltitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitolo.setBounds(172, 235, 375, 31);
		frmUntitledGaming.getContentPane().add(lbltitolo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			JTable table = new JTable(eventsListener.getGames());
			String titolo3 = String.valueOf(table.getValueAt(2, 1));
		JLabel lbltitolo_1 = new JLabel(titolo3);
		lbltitolo_1.setLabelFor(panel_2);
		lbltitolo_1.setFont(new Font("Georgia", Font.ITALIC, 21));
		lbltitolo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitolo_1.setBounds(172, 350, 375, 31);
		frmUntitledGaming.getContentPane().add(lbltitolo_1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			JTable table = new JTable(eventsListener.getGames());
			String titolo4 = String.valueOf(table.getValueAt(3, 1));
		JLabel lbltitolo_2 = new JLabel(titolo4);
		lbltitolo_2.setLabelFor(panel_3);
		lbltitolo_2.setFont(new Font("Georgia", Font.ITALIC, 21));
		lbltitolo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitolo_2.setBounds(172, 469, 375, 31);
		frmUntitledGaming.getContentPane().add(lbltitolo_2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JButton btnSuccessiva = new JButton("");
		btnSuccessiva.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Rounded_next.png"));
		btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
		btnSuccessiva.setToolTipText("Pagina Successiva");
		btnSuccessiva.setBounds(830, 581, 45, 45);
		frmUntitledGaming.getContentPane().add(btnSuccessiva);
		
		JButton btnRecensione = new JButton("Gioca!");
		btnRecensione.setToolTipText("Gioca!");
		btnRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnRecensione.setBounds(743, 113, 142, 30);
		frmUntitledGaming.getContentPane().add(btnRecensione);


		btnRecensione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.dispose();
				eventsListener.changePage("tossTheCoin", utente);
			}
		});
		
		JButton btnGioca = new JButton("Gioca!");
		btnGioca.setToolTipText("Gioca!");
		btnGioca.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnGioca.setBounds(743, 236, 142, 30);
		frmUntitledGaming.getContentPane().add(btnGioca);
		
		JButton btnGioca_1 = new JButton("Gioca!");
		btnGioca_1.setToolTipText("Gioca!");
		btnGioca_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnGioca_1.setBounds(743, 351, 142, 30);
		frmUntitledGaming.getContentPane().add(btnGioca_1);
		
		JButton btnGioca_2 = new JButton("Gioca!");
		btnGioca_2.setToolTipText("Gioca!");
		btnGioca_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnGioca_2.setBounds(743, 470, 142, 30);
		frmUntitledGaming.getContentPane().add(btnGioca_2);
		
		JButton button_4 = new JButton("");
		button_4.setEnabled(false);
		button_4.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Rounded_back_1.png"));
		button_4.setToolTipText("Pagina Precedente");
		button_4.setFont(new Font("MV Boli", Font.ITALIC, 13));
		button_4.setBounds(68, 581, 45, 45);
		frmUntitledGaming.getContentPane().add(button_4);
		
		JButton btnRecensioni = new JButton("Recensioni");
		btnRecensioni.setToolTipText("Recensioni");
		btnRecensioni.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnRecensioni.setBounds(573, 471, 142, 31);
		frmUntitledGaming.getContentPane().add(btnRecensioni);
		
		JButton button_1 = new JButton("Recensioni");
		button_1.setToolTipText("Recensioni");
		button_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_1.setBounds(573, 352, 142, 30);
		frmUntitledGaming.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Recensioni");
		button_2.setToolTipText("Recensioni");
		button_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_2.setBounds(573, 237, 142, 30);
		frmUntitledGaming.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Recensioni");
		button_3.setToolTipText("Recensioni");
		button_3.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_3.setBounds(573, 114, 142, 30);
		frmUntitledGaming.getContentPane().add(button_3);

	}
}
