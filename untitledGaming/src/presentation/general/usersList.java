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

public class usersList {

	private JFrame frmUntitledGaming;
	Utente utente;

	/**
	 * Create the application.
	 */
	public usersList(Utente c) {
		this.utente=c;
		initialize();
	}

	/* 
	Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setVisible(true);
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Lista Utenti");
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
		
		JLabel lblListaGiochi = new JLabel("Lista Utenti");
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

		JLabel lblNewLabel = new JLabel("Username here");
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
		JLabel lbltitolo = new JLabel("Username here");
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
		JLabel lbltitolo_1 = new JLabel("Username here");
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
		JLabel lbltitolo_2 = new JLabel("Username here");
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
		
		JButton btnDclassa = new JButton("Declassa");
		btnDclassa.setBackground(new Color(240, 128, 128));
		btnDclassa.setForeground(new Color(255, 99, 71));
		btnDclassa.setToolTipText("Declassa");
		btnDclassa.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnDclassa.setBounds(743, 113, 142, 30);
		frmUntitledGaming.getContentPane().add(btnDclassa);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_4.setEnabled(false);
		button_4.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\Rounded_back_1.png"));
		button_4.setToolTipText("Pagina Precedente");
		button_4.setFont(new Font("MV Boli", Font.ITALIC, 13));
		button_4.setBounds(68, 581, 45, 45);
		frmUntitledGaming.getContentPane().add(button_4);
		
		JButton btnPromuovi = new JButton("Promuovi");
		btnPromuovi.setBackground(new Color(152, 251, 152));
		btnPromuovi.setForeground(new Color(50, 205, 50));
		btnPromuovi.setToolTipText("Promuovi");
		btnPromuovi.setFont(new Font("MV Boli", Font.ITALIC, 17));
		btnPromuovi.setBounds(573, 114, 142, 30);
		frmUntitledGaming.getContentPane().add(btnPromuovi);
		
		JButton button_1 = new JButton("Promuovi");
		button_1.setToolTipText("Promuovi");
		button_1.setForeground(new Color(50, 205, 50));
		button_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_1.setBackground(new Color(152, 251, 152));
		button_1.setBounds(573, 237, 142, 30);
		frmUntitledGaming.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Promuovi");
		button_2.setToolTipText("Promuovi");
		button_2.setForeground(new Color(50, 205, 50));
		button_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_2.setBackground(new Color(152, 251, 152));
		button_2.setBounds(573, 352, 142, 30);
		frmUntitledGaming.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Promuovi");
		button_3.setToolTipText("Promuovi");
		button_3.setForeground(new Color(50, 205, 50));
		button_3.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_3.setBackground(new Color(152, 251, 152));
		button_3.setBounds(573, 470, 142, 30);
		frmUntitledGaming.getContentPane().add(button_3);
		
		JButton button_5 = new JButton("Declassa");
		button_5.setToolTipText("Declassa");
		button_5.setForeground(new Color(255, 99, 71));
		button_5.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_5.setBackground(new Color(240, 128, 128));
		button_5.setBounds(743, 235, 142, 30);
		frmUntitledGaming.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("Declassa");
		button_6.setToolTipText("Declassa");
		button_6.setForeground(new Color(255, 99, 71));
		button_6.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_6.setBackground(new Color(240, 128, 128));
		button_6.setBounds(743, 351, 142, 30);
		frmUntitledGaming.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("Declassa");
		button_7.setToolTipText("Declassa");
		button_7.setForeground(new Color(255, 99, 71));
		button_7.setFont(new Font("MV Boli", Font.ITALIC, 17));
		button_7.setBackground(new Color(240, 128, 128));
		button_7.setBounds(743, 469, 142, 30);
		frmUntitledGaming.getContentPane().add(button_7);

	}
}