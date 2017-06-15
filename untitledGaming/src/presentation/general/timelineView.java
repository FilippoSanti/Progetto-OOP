package presentation.general;

import business.model.Utente;
import controller.eventsListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class timelineView {

	private JFrame frmUntitledGaming;
Utente utente;
	/**
	 * Create the application.
	 */
	public timelineView(Utente c) {
		this.utente = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Cronologia di Gioco");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
		button.setToolTipText("torna indietro");
		button.setBounds(10, 11, 45, 45);
		frmUntitledGaming.getContentPane().add(button);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				frmUntitledGaming.setVisible(false);
				eventsListener.changePage("profile", utente);

			}
		});

		
		JLabel lblCronologiaDiGioco = new JLabel("Cronologia di Gioco");
		lblCronologiaDiGioco.setHorizontalAlignment(SwingConstants.CENTER);
		lblCronologiaDiGioco.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblCronologiaDiGioco.setBounds(0, 51, 944, 61);
		frmUntitledGaming.getContentPane().add(lblCronologiaDiGioco);
		
		JLabel lblUltimogiocoGiocato = new JLabel("Ultimo Gioco Giocato :");
		lblUltimogiocoGiocato.setForeground(Color.GRAY);
		lblUltimogiocoGiocato.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblUltimogiocoGiocato.setBounds(61, 210, 240, 30);
		frmUntitledGaming.getContentPane().add(lblUltimogiocoGiocato);
		
		JLabel lblUltimasessione = new JLabel("Data Ultima Sessione :");
		lblUltimasessione.setForeground(Color.GRAY);
		lblUltimasessione.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblUltimasessione.setBounds(61, 354, 240, 30);
		frmUntitledGaming.getContentPane().add(lblUltimasessione);
		
		JLabel lblPuntiXpGuadagnati = new JLabel("Punti XP Guadagnati nell'Ultima Sessione :");
		lblPuntiXpGuadagnati.setForeground(Color.GRAY);
		lblPuntiXpGuadagnati.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblPuntiXpGuadagnati.setBounds(61, 508, 387, 30);
		frmUntitledGaming.getContentPane().add(lblPuntiXpGuadagnati);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		panel.setBackground(Color.CYAN);
		panel.setBounds(311, 178, 90, 90);
		frmUntitledGaming.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		panel.add(label);


		JLabel lblNewLabel = null;
		try {


			lblNewLabel = new JLabel(eventsListener.getGameFromId(eventsListener.getTimeline(utente.getUserId()).getGioco_id()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel.setBounds(450, 202, 306, 45);
		frmUntitledGaming.getContentPane().add(lblNewLabel);

		JLabel lblInserireQui = null;
		try {

			lblInserireQui = new JLabel(eventsListener.getTimeline(utente.getUserId()).getData_ultima_sessione().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lblInserireQui.setForeground(Color.DARK_GRAY);
		lblInserireQui.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblInserireQui.setBounds(311, 346, 306, 45);
		frmUntitledGaming.getContentPane().add(lblInserireQui);

		JLabel lblInserireQui_1 = null;
		try {

			lblInserireQui_1 = new JLabel( Integer.toString(eventsListener.getTimeline(utente.getUserId()).getEsperienza_guadagnata()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lblInserireQui_1.setForeground(Color.DARK_GRAY);
		lblInserireQui_1.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblInserireQui_1.setBounds(436, 500, 402, 45);
		frmUntitledGaming.getContentPane().add(lblInserireQui_1);

		frmUntitledGaming.setVisible(true);
	}
}
