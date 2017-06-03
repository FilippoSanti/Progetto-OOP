package presentation.user;

import presentation.general.logged;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class profile {

	private JFrame frmUntitledGaming;

	/* Create the application */
	public profile() {
		initialize();
	}

	/* Initialize the contents of the frame */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setVisible(true);

		frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("logo_untitled_gaming.png"));
		frmUntitledGaming.setTitle("Untitled Gaming - Your Profile");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 750, 500);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);

		JLabel lblIlTuoProfilo = new JLabel("Il Tuo Profilo");
		lblIlTuoProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlTuoProfilo.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblIlTuoProfilo.setBounds(0, 26, 734, 37);
		frmUntitledGaming.getContentPane().add(lblIlTuoProfilo);

		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(94, 73, 146, 143);
		frmUntitledGaming.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Nome :");
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(387, 95, 84, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cognome :");
		lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(387, 125, 84, 19);
		frmUntitledGaming.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Et\u00E0 :");
		lblNewLabel_2.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setBounds(387, 150, 84, 24);
		frmUntitledGaming.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("E-m@il :");
		lblNewLabel_3.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(387, 180, 84, 19);
		frmUntitledGaming.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Abcdefghijklmno");
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_4.setBounds(493, 95, 133, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Abcdefghijklmno");
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_5.setBounds(493, 126, 133, 16);
		frmUntitledGaming.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Abcdefghijklmno");
		lblNewLabel_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_6.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_6.setBounds(493, 150, 133, 24);
		frmUntitledGaming.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Abcdefghijklmno");
		lblNewLabel_7.setForeground(Color.DARK_GRAY);
		lblNewLabel_7.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_7.setBounds(493, 180, 133, 19);
		frmUntitledGaming.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Il Tuo Livello :");
		lblNewLabel_8.setForeground(Color.GRAY);
		lblNewLabel_8.setFont(new Font("Georgia", Font.ITALIC, 11));
		lblNewLabel_8.setBounds(60, 264, 124, 14);
		frmUntitledGaming.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("I Tuoi Punti XP :");
		lblNewLabel_9.setForeground(Color.GRAY);
		lblNewLabel_9.setFont(new Font("Georgia", Font.ITALIC, 11));
		lblNewLabel_9.setBounds(60, 299, 124, 14);
		frmUntitledGaming.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Achievements Sbloccati :");
		lblNewLabel_10.setForeground(Color.GRAY);
		lblNewLabel_10.setFont(new Font("Georgia", Font.ITALIC, 11));
		lblNewLabel_10.setBounds(60, 335, 164, 14);
		frmUntitledGaming.getContentPane().add(lblNewLabel_10);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Georgia", Font.ITALIC, 11));
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("% XP");
		progressBar.setForeground(Color.BLUE);
		progressBar.setValue(75);
		progressBar.setBackground(SystemColor.menu);
		progressBar.setBounds(194, 299, 146, 14);
		frmUntitledGaming.getContentPane().add(progressBar);

		JButton btnNewButton = new JButton("I Tuoi Giochi");
		btnNewButton.setToolTipText("I Tuoi Giochi");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(144, 402, 145, 37);
		frmUntitledGaming.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_11 = new JLabel("999");
		lblNewLabel_11.setForeground(Color.DARK_GRAY);
		lblNewLabel_11.setFont(new Font("Georgia", Font.ITALIC, 11));
		lblNewLabel_11.setBounds(194, 264, 46, 14);
		frmUntitledGaming.getContentPane().add(lblNewLabel_11);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(234, 330, 30, 30);
		frmUntitledGaming.getContentPane().add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(294, 330, 30, 30);
		frmUntitledGaming.getContentPane().add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.PINK);
		panel_5.setBounds(354, 330, 30, 30);
		frmUntitledGaming.getContentPane().add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.ORANGE);
		panel_6.setBounds(414, 330, 30, 30);
		frmUntitledGaming.getContentPane().add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(474, 330, 30, 30);
		frmUntitledGaming.getContentPane().add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.BLUE);
		panel_8.setBounds(534, 330, 30, 30);
		frmUntitledGaming.getContentPane().add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.MAGENTA);
		panel_9.setBounds(594, 330, 30, 30);
		frmUntitledGaming.getContentPane().add(panel_9);

		JButton btnModifica = new JButton("Modifica");
		btnModifica.setToolTipText("Modifica");
		btnModifica.setFont(new Font("MV Boli", Font.PLAIN, 12));
		btnModifica.setBounds(451, 216, 89, 23);
		frmUntitledGaming.getContentPane().add(btnModifica);

		JLabel label = new JLabel("999999");
		label.setToolTipText("XP point");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Georgia", Font.ITALIC, 11));
		label.setBounds(369, 297, 57, 16);
		frmUntitledGaming.getContentPane().add(label);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Go back");
		btnNewButton_1.setIcon(new ImageIcon("img/back_icon.png"));
		btnNewButton_1.setBounds(10, 10, 37, 31);

        // Go to the presentation page
        btnNewButton_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                new logged();
            }
        });

		frmUntitledGaming.getContentPane().add(btnNewButton_1);

		JButton btnVisualizzaAchievements = new JButton("Visualizza Achievements");
		btnVisualizzaAchievements.setToolTipText("Visualizza Achievements");
		btnVisualizzaAchievements.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnVisualizzaAchievements.setBounds(400, 402, 202, 37);
		frmUntitledGaming.getContentPane().add(btnVisualizzaAchievements);
	}
}
