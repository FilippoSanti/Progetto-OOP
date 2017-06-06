package presentation.general;

import business.model.Utente;
import controller.eventsListener;
import presentation.general.logged;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static javax.swing.text.html.HTML.Tag.HEAD;


public class profile {

	Utente utente = null;
	private JFrame frmUntitledGaming;

	/* Create the application */
	public profile(Utente c) {

		this.utente = c;
		initialize();
	}

	/* Initialize the contents of the frame */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setVisible(true);

		frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("logo_untitled_gaming.png"));
		frmUntitledGaming.setTitle("Untitled Gaming - Your Profile");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		frmUntitledGaming.setLocationRelativeTo(null);

		JLabel lblIlTuoProfilo = new JLabel("Il Tuo Profilo");
		lblIlTuoProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlTuoProfilo.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblIlTuoProfilo.setBounds(0, 38, 944, 61);
		frmUntitledGaming.getContentPane().add(lblIlTuoProfilo);

		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(94, 116, 175, 175);
		frmUntitledGaming.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(488, 141, 131, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cognome :");
		lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(488, 171, 131, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data di nascita :");
		lblNewLabel_2.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(488, 202, 131, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E-mail :");
		lblNewLabel_3.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(488, 232, 131, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(utente.getNome());
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(636, 141, 183, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(utente.getCognome());
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_5.setBounds(636, 172, 183, 30);
		frmUntitledGaming.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(utente.getData().toString());
		lblNewLabel_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_6.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_6.setBounds(636, 202, 183, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(utente.getEmail());
		lblNewLabel_7.setForeground(Color.DARK_GRAY);
		lblNewLabel_7.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_7.setBounds(636, 232, 183, 31);;
		frmUntitledGaming.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Il Tuo Livello :");
		lblNewLabel_8.setForeground(Color.GRAY);
		lblNewLabel_8.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblNewLabel_8.setBounds(55, 367, 165, 30);
		frmUntitledGaming.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("I Tuoi Punti XP :");
		lblNewLabel_9.setForeground(Color.GRAY);
		lblNewLabel_9.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblNewLabel_9.setBounds(55, 418, 165, 30);
		frmUntitledGaming.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Achievements Sbloccati :");
		lblNewLabel_10.setForeground(Color.GRAY);
		lblNewLabel_10.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblNewLabel_10.setBounds(55, 478, 210, 30);
		frmUntitledGaming.getContentPane().add(lblNewLabel_10);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Georgia", Font.ITALIC, 14));
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("% XP");
		progressBar.setForeground(Color.BLUE);
		progressBar.setValue(75);
		progressBar.setBackground(SystemColor.menu);
		progressBar.setBounds(247, 427, 273, 18);
		frmUntitledGaming.getContentPane().add(progressBar);

		JButton btnNewButton = new JButton("I Tuoi Giochi");
		btnNewButton.setToolTipText("I Tuoi Giochi");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 18));

		btnNewButton.setBounds(162, 576, 185, 37);
		frmUntitledGaming.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.dispose();
				controller.eventsListener.changePage("allGames", utente);

			}
		});




<<<<<<< HEAD
		try {
			int livello = eventsListener.getGameProfile(utente.getUserId()).getLivello();
            String stringalv = Integer.toString(livello);
			JLabel lblNewLabel_12 = new JLabel(stringalv);
			lblNewLabel_12.setForeground(Color.DARK_GRAY);
			lblNewLabel_12.setFont(new Font("Georgia", Font.ITALIC, 17));
			lblNewLabel_12.setBounds(230, 367, 60, 30);
			frmUntitledGaming.getContentPane().add(lblNewLabel_12);
=======

		JLabel lblNewLabel_11 = new JLabel("999");
		lblNewLabel_11.setForeground(Color.DARK_GRAY);
		lblNewLabel_11.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblNewLabel_11.setBounds(230, 367, 60, 30);
		frmUntitledGaming.getContentPane().add(lblNewLabel_11);

		try {
			int livello = eventsListener.getGameProfile(utente.getUserId()).getLivello();
            String stringalv = Integer.toString(livello);
			lblNewLabel_11 = new JLabel(stringalv);
			lblNewLabel_11.setForeground(Color.DARK_GRAY);
			lblNewLabel_11.setFont(new Font("Georgia", Font.ITALIC, 17));
			lblNewLabel_11.setBounds(230, 367, 60, 30);
			frmUntitledGaming.getContentPane().add(lblNewLabel_11);
>>>>>>> dcfa929a1bc351b8480c6253cb56c3187c1883b0

		} catch (SQLException e) {
			e.printStackTrace();
		}

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(275, 468, 50, 50);
		frmUntitledGaming.getContentPane().add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(365, 468, 50, 50);
		frmUntitledGaming.getContentPane().add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.PINK);
		panel_5.setBounds(455, 468, 50, 50);
		frmUntitledGaming.getContentPane().add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.ORANGE);
		panel_6.setBounds(545, 468, 50, 50);
		frmUntitledGaming.getContentPane().add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(635, 468, 50, 50);
		frmUntitledGaming.getContentPane().add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.BLUE);
		panel_8.setBounds(725, 468, 50, 50);
		frmUntitledGaming.getContentPane().add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.MAGENTA);
		panel_9.setBounds(815, 468, 50, 50);
		frmUntitledGaming.getContentPane().add(panel_9);

		JButton btnScegliImmagine = new JButton("Scegli Immagine");
		btnScegliImmagine.setToolTipText("Scegli Immagine");
		btnScegliImmagine.setFont(new Font("MV Boli", Font.PLAIN, 17));
		btnScegliImmagine.setBounds(94, 309, 175, 34);
		frmUntitledGaming.getContentPane().add(btnScegliImmagine);

		JButton btnModifica = new JButton("Modifica");
		btnModifica.setToolTipText("Modifica");
		btnModifica.setFont(new Font("MV Boli", Font.PLAIN, 17));
		btnModifica.setBounds(591, 294, 110, 34);
		frmUntitledGaming.getContentPane().add(btnModifica);

		btnModifica.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.dispose();
				eventsListener.changePage("editData", utente);

			}
		});
		


		try {
			int xp = eventsListener.getGameProfile(utente.getUserId()).getEsperienza();
			String stringaxp = Integer.toString(xp);

			JLabel label = new JLabel(stringaxp);
			label.setToolTipText("XP point");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.DARK_GRAY);
			label.setFont(new Font("Georgia", Font.ITALIC, 11));
			label.setBounds(369, 297, 57, 16);
			frmUntitledGaming.getContentPane().add(label);
		} catch (SQLException e) {
			e.printStackTrace();
		}


		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Go back");
		btnNewButton_1.setIcon(new ImageIcon("img/back_icon.png"));
		btnNewButton_1.setBounds(10, 11, 45, 45);

        // Go to the presentation page
        btnNewButton_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                controller.eventsListener.changePage("logged", utente);
            }
        });

		frmUntitledGaming.getContentPane().add(btnNewButton_1);

		JButton btnVisualizzaAchievements = new JButton("Visualizza Achievements");
		btnVisualizzaAchievements.setToolTipText("Visualizza Achievements");
		btnVisualizzaAchievements.setFont(new Font("MV Boli", Font.ITALIC, 18));
		btnVisualizzaAchievements.setBounds(513, 576, 289, 37);
		frmUntitledGaming.getContentPane().add(btnVisualizzaAchievements);

		btnVisualizzaAchievements.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.dispose();
				controller.eventsListener.changePage("achievementsList", utente);

			}
		});
	}
}
