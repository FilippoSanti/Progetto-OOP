package presentation.general;

import business.BusinessException;
import business.implementation.DBManager;
import business.model.Utente;
import controller.eventsListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


public class profile {

	private JFrame frmUntitledGaming;

	Utente utente = null;

	/* Create the application */
	public profile(Utente c) {

		this.utente = c;
		initialize();
	}

	/* Initialize the contents of the frame */
	private void initialize() {

		// File chooser settings
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setVisible(true);

		frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("logo_untitled_gaming.png"));
		frmUntitledGaming.setTitle("Untitled Gaming - Il Tuo Profilo");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setLocationRelativeTo(null);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);

		JLabel lblIlTuoProfilo = new JLabel("Il Tuo Profilo");
		lblIlTuoProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlTuoProfilo.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblIlTuoProfilo.setBounds(0, 38, 944, 61);
		frmUntitledGaming.getContentPane().add(lblIlTuoProfilo);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(487, 141, 185, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cognome :");
		lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(487, 171, 185, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data di Nascita :");
		lblNewLabel_2.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(487, 202, 185, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E-mail :");
		lblNewLabel_3.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(487, 232, 185, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(utente.getNome());
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(659, 141, 183, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(utente.getCognome());
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_5.setBounds(659, 172, 183, 30);
		frmUntitledGaming.getContentPane().add(lblNewLabel_5);

		String dateString = utente.getData().toString();
		String reverse = new StringBuffer(dateString).reverse().toString();

		String dataFinale = DBManager.formatSqlDateString(utente.getData().toString());

		JLabel lblNewLabel_6 = new JLabel(dataFinale);
		lblNewLabel_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_6.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_6.setBounds(659, 202, 183, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(utente.getEmail());
		lblNewLabel_7.setForeground(Color.DARK_GRAY);
		lblNewLabel_7.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel_7.setBounds(659, 232, 275, 31);
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

        int exp = 0;
        try {
            exp = eventsListener.getGameProfile(utente.getUserId()).getEsperienza();

            JProgressBar progressBar = new JProgressBar();

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 1){
                progressBar.setMinimum(0);
                progressBar.setMaximum(100);
            }

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 2){
                progressBar.setMinimum(100);
                progressBar.setMaximum(250);
            }

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 3){
                progressBar.setMinimum(250);
                progressBar.setMaximum(450);
            }

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 4){
                progressBar.setMinimum(450);
                progressBar.setMaximum(700);
            }

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 5){
                progressBar.setMinimum(700);
                progressBar.setMaximum(1100);
            }

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 6){
                progressBar.setMinimum(1100);
                progressBar.setMaximum(1500);
            }

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 7){
                progressBar.setMinimum(1500);
                progressBar.setMaximum(2000);
            }

            if (eventsListener.getGameProfile(utente.getUserId()).getLivello() == 8){
                progressBar.setMinimum(2000);
                progressBar.setMaximum(2800);
            }

            progressBar.setFont(new Font("Georgia", Font.ITALIC, 14));
            progressBar.setStringPainted(true);
            progressBar.setToolTipText("% XP");
            progressBar.setForeground(Color.BLUE);
            progressBar.setValue(exp);
            progressBar.setBackground(SystemColor.menu);
            progressBar.setBounds(247, 427, 273, 18);
            frmUntitledGaming.getContentPane().add(progressBar);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        JButton btnNewButton = new JButton("Cronologia di Gioco");
		btnNewButton.setToolTipText("I Tuoi Giochi");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 18));

		btnNewButton.setBounds(137, 576, 289, 37);
		frmUntitledGaming.getContentPane().add(btnNewButton);


		btnNewButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.setVisible(false);
				eventsListener.changePage("timelineView", utente);

			}
		});

		try {
			int livello = eventsListener.getGameProfile(utente.getUserId()).getLivello();
			String stringalv = Integer.toString(livello);
			JLabel lblNewLabel_12 = new JLabel(stringalv);
			lblNewLabel_12.setForeground(Color.DARK_GRAY);
			lblNewLabel_12.setFont(new Font("Georgia", Font.ITALIC, 17));
			lblNewLabel_12.setBounds(230, 367, 117, 30);
			frmUntitledGaming.getContentPane().add(lblNewLabel_12);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(275, 468, 50, 50);
		panel_2.setBorder(new LineBorder(Color.BLACK));

			int achievement = 0;
			achievement = eventsListener.getUserAchievementsList(utente.getUserId()).getRowCount();
			String b = String.valueOf(achievement);



				JLabel jlabel = new JLabel(b);
				jlabel.setFont(new Font("Verdana", 1, 30));
				panel_2.add(jlabel);
			frmUntitledGaming.getContentPane().add(panel_2);

		} catch (SQLException e) {
			e.printStackTrace();
		}


		
		JButton btnScegliImmagine = new JButton("Scegli Immagine");
		btnScegliImmagine.setToolTipText("Scegli Immagine");
		btnScegliImmagine.setFont(new Font("MV Boli", Font.PLAIN, 17));
		btnScegliImmagine.setBounds(94, 294, 175, 34);
		frmUntitledGaming.getContentPane().add(btnScegliImmagine);

		btnScegliImmagine.addActionListener(new ActionListener() {

			// Image chooser dialog
			public void actionPerformed(ActionEvent e) {
				int retVal = jfc.showOpenDialog(frmUntitledGaming);
				if (retVal == JFileChooser.APPROVE_OPTION) {
					File selectedfile = jfc.getSelectedFile();

					// Store the image into the DB
					if (business.implementation.DBManager.setImg(utente.getUserId(), selectedfile)) {
						JOptionPane.showMessageDialog(frmUntitledGaming, "Propic set successfully");
						frmUntitledGaming.dispose();
						controller.eventsListener.changePage("profile", utente);

					} else {
						throw new BusinessException("Error during the upload, try again");
					}
				}
			}
		});

		try {

			if (DBManager.checkImage(utente.getUserId())) {

				// Declare the panel
				Panel panel = new Panel();

				// Get the image and show it on the panel
				BufferedImage myPicture = null;
				try {
					business.implementation.DBManager.getImg(utente.getUserId());
					myPicture = ImageIO.read(new File("./src/presentation/propic.png"));

					// TODO: additional local file check

					JLabel picLabel = new JLabel(new ImageIcon(myPicture));
					panel.add(picLabel);

				} catch (IOException e) {
					e.printStackTrace();
				}

				// Propic panel with the user image
				panel.setBounds(94, 105, 175, 175);
				frmUntitledGaming.getContentPane().add(panel);

            } else {

				// Propic panel with no image
				Panel panel = new Panel();
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBounds(94, 105, 175, 175);
				//panel.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
				frmUntitledGaming.getContentPane().add(panel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
			label.setFont(new Font("Georgia", Font.ITALIC, 17));

			label.setBounds(561, 418, 124, 30);

			label.setBounds(561, 418, 124, 30);

			frmUntitledGaming.getContentPane().add(label);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Go back");
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
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
				frmUntitledGaming.setVisible(false);
				controller.eventsListener.changePage("achievementsList", utente);

			}
		});
	}
}
