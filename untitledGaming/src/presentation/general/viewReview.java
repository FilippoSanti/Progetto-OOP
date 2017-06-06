package presentation.general;

import business.model.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import com.jgoodies.forms.factories.DefaultComponentFactory;


// TODO: Add start rating
public class viewReview {

	private JFrame frmUntitledGaming;

	Utente utente = null;

	public viewReview(Utente c) {
		this.utente = c;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Visualizza Recensione");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);

		JLabel lblValutaQuestoGioco = new JLabel("La Tua Recensione:");
		lblValutaQuestoGioco.setForeground(SystemColor.textInactiveText);
		lblValutaQuestoGioco.setHorizontalAlignment(SwingConstants.CENTER);
		lblValutaQuestoGioco.setFont(new Font("Georgia", Font.ITALIC, 30));
		lblValutaQuestoGioco.setBounds(10, 77, 924, 40);
		frmUntitledGaming.getContentPane().add(lblValutaQuestoGioco);

		JLabel lblScriviUnCommento = new JLabel("Il Tuo Commento:");
		lblScriviUnCommento.setHorizontalAlignment(SwingConstants.LEFT);
		lblScriviUnCommento.setForeground(SystemColor.textInactiveText);
		lblScriviUnCommento.setFont(new Font("Georgia", Font.ITALIC, 25));
		lblScriviUnCommento.setBounds(43, 307, 232, 34);
		frmUntitledGaming.getContentPane().add(lblScriviUnCommento);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("back_icon.png"));
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

		JLabel lblValutazione = new JLabel("Valutazione:");
		lblValutazione.setHorizontalAlignment(SwingConstants.LEFT);
		lblValutazione.setForeground(SystemColor.textInactiveText);
		lblValutazione.setFont(new Font("Georgia", Font.ITALIC, 25));
		lblValutazione.setBounds(96, 188, 188, 29);
		frmUntitledGaming.getContentPane().add(lblValutazione);

		JPanel panel = new JPanel();
		panel.setBounds(279, 175, 564, 58);
		frmUntitledGaming.getContentPane().add(panel);

		JLabel lblCancellareLaLabel = new JLabel("cancellare la label e inserire qu\u00EC le stelle");
		panel.add(lblCancellareLaLabel);

		JTextPane txtpncommentoPrecedentementeInserito = new JTextPane();
		txtpncommentoPrecedentementeInserito.setText("-Commento precedentemente inserito dallo stesso utente-");
		txtpncommentoPrecedentementeInserito.setFont(new Font("Oregano", Font.ITALIC, 25));
		txtpncommentoPrecedentementeInserito.setEditable(false);
		txtpncommentoPrecedentementeInserito.setBackground(new Color(220, 220, 220));
		txtpncommentoPrecedentementeInserito.setBounds(62, 392, 818, 198);
		frmUntitledGaming.getContentPane().add(txtpncommentoPrecedentementeInserito);

		frmUntitledGaming.setVisible(true);



	}
}
