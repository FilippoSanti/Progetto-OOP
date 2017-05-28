package presentation.moderator;

import javax.swing.*;
import java.awt.*;

public class approveReview {

	private JFrame frmUntitledGaming;

	/**
	 * Create the application.
	 */
	public approveReview() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					approveReview window = new approveReview();
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
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Leggi Commento");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 750, 500);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);

		JButton btnApprovaCommento = new JButton("Approva Commento");
		btnApprovaCommento.setToolTipText("Invia Recensione");
		btnApprovaCommento.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnApprovaCommento.setBounds(117, 376, 168, 37);
		frmUntitledGaming.getContentPane().add(btnApprovaCommento);

		JButton btnEliminaCommento = new JButton("Elimina Commento");
		btnEliminaCommento.setToolTipText("Invia Recensione");
		btnEliminaCommento.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnEliminaCommento.setBounds(457, 376, 168, 37);
		frmUntitledGaming.getContentPane().add(btnEliminaCommento);

		JLabel lblHaScritto_1 = new JLabel("ha scritto:");
		lblHaScritto_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHaScritto_1.setForeground(SystemColor.textInactiveText);
		lblHaScritto_1.setFont(new Font("Georgia", Font.ITALIC, 20));
		lblHaScritto_1.setBounds(361, 62, 151, 25);
		frmUntitledGaming.getContentPane().add(lblHaScritto_1);

		JLabel lblusername = new JLabel("-Username-");
		lblusername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblusername.setForeground(SystemColor.textInactiveText);
		lblusername.setFont(new Font("Georgia", Font.ITALIC, 20));
		lblusername.setBounds(145, 62, 206, 25);
		frmUntitledGaming.getContentPane().add(lblusername);

		JTextPane txtpncommentoPrecedentementeInserito = new JTextPane();
		txtpncommentoPrecedentementeInserito.setBackground(new Color(220, 220, 220));
		txtpncommentoPrecedentementeInserito.setFont(new Font("Oregano", Font.ITALIC, 17));
		txtpncommentoPrecedentementeInserito.setText("-Commento precedentemente inserito DA VALUTARE-");
		txtpncommentoPrecedentementeInserito.setEditable(false);
		txtpncommentoPrecedentementeInserito.setBounds(69, 131, 577, 163);
		frmUntitledGaming.getContentPane().add(txtpncommentoPrecedentementeInserito);
	}
}
