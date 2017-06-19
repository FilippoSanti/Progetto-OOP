package presentation.general;

import business.model.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logged {

    Utente utente = null;
	private JFrame frmUntitledGaming;

	/* Create the application */
	public logged(Utente c) {
		this.utente = c;
		initialize();
	}

	/* Initialize the contents of the frame*/
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setVisible(true);

		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setTitle("Untitled Gaming - " + utente.getUsername());
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		frmUntitledGaming.setLocationRelativeTo(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 46, 14);
		frmUntitledGaming.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("Hello, ");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Oregano", Font.PLAIN, 21));
		lblNewLabel.setBounds(662, 31, 70, 31);
		frmUntitledGaming.getContentPane().add(lblNewLabel);

		JLabel lblusernameHere = new JLabel(" " + utente.getUsername());
		lblusernameHere.setForeground(Color.DARK_GRAY);
		lblusernameHere.setFont(new Font("Oregano", Font.PLAIN, 21));
		lblusernameHere.setBounds(720, 32, 193, 30);
		frmUntitledGaming.getContentPane().add(lblusernameHere);

		JLabel lblNewLabel_1 = new JLabel("Untitled Gaming");
		lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 84, 944, 61);
		frmUntitledGaming.getContentPane().add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Il Tuo Profilo");
		btnNewButton.setToolTipText("Il Tuo Profilo");
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 21));
		btnNewButton.setBounds(123, 261, 250, 65);

        // Go to the user profile
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                controller.eventsListener.changePage("profile", utente);
            }
        });

		frmUntitledGaming.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Valuta Commenti");
		btnNewButton_1.setToolTipText("Valuta Commenti");
		if (utente.getTipo().equals("user")) btnNewButton_1.setEnabled(false);
		else btnNewButton_1.setEnabled(true);
		btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 21));
		btnNewButton_1.setBounds(564, 261, 250, 65);
		frmUntitledGaming.getContentPane().add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.dispose();
				controller.eventsListener.changePage("evalutateReview", utente);
			}
		});

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setToolTipText("Log Out");
		btnLogOut.setFont(new Font("MV Boli", Font.PLAIN, 17));
		btnLogOut.setBounds(704, 75, 115, 30);
		frmUntitledGaming.getContentPane().add(btnLogOut);

		btnLogOut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.dispose();
				controller.eventsListener.changePage("startPage", utente);
			}
		});

		JButton btnListaUtenti = new JButton("Lista Utenti");
		if (utente.getTipo().equals("user")) btnListaUtenti.setEnabled(false);
		else btnListaUtenti.setEnabled(true);
		btnListaUtenti.setToolTipText("Lista Utenti");
		btnListaUtenti.setFont(new Font("MV Boli", Font.ITALIC, 21));
		btnListaUtenti.setBounds(123, 454, 250, 65);

		frmUntitledGaming.getContentPane().add(btnListaUtenti);
		btnListaUtenti.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.setVisible(false);
				controller.eventsListener.changePage("userList", utente);
			}
		});

		JButton btnGiocaOra = new JButton("Gioca Ora");
		btnGiocaOra.setToolTipText("Gioca Ora");
		btnGiocaOra.setFont(new Font("MV Boli", Font.ITALIC, 21));
		btnGiocaOra.setBounds(564, 454, 250, 65);
		frmUntitledGaming.getContentPane().add(btnGiocaOra);

		btnGiocaOra.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.setVisible(false);
				controller.eventsListener.changePage("allGames", utente);
			}
		});
	}
}
