package presentation.general;

import javax.swing.*;
import java.awt.*;

// import com.jgoodies.forms.factories.DefaultComponentFactory;


// TODO: Add start rating
public class viewReview {

	private JFrame frmUntitledGaming;

	/**
	 * Create the application.
	 */

	public viewReview() {
		initialize();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewReview window = new viewReview();
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
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Visualizza Recensione");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 750, 500);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);

		JLabel lblValutaQuestoGioco = new JLabel("La Tua Recensione:");
		lblValutaQuestoGioco.setForeground(SystemColor.textInactiveText);
		lblValutaQuestoGioco.setHorizontalAlignment(SwingConstants.CENTER);
		lblValutaQuestoGioco.setFont(new Font("Georgia", Font.ITALIC, 20));
		lblValutaQuestoGioco.setBounds(10, 50, 724, 25);
		frmUntitledGaming.getContentPane().add(lblValutaQuestoGioco);

		JCheckBox chckbxNewCheckBox = new JCheckBox("1");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(196, 120, 97, 25);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("2");
		chckbxNewCheckBox_1.setSelected(true);
		chckbxNewCheckBox_1.setEnabled(false);
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setBounds(295, 120, 97, 25);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("3");
		chckbxNewCheckBox_2.setSelected(true);
		chckbxNewCheckBox_2.setEnabled(false);
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_2.setBounds(394, 120, 97, 25);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("4");
		chckbxNewCheckBox_3.setSelected(true);
		chckbxNewCheckBox_3.setEnabled(false);
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_3.setBounds(493, 120, 97, 25);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("5");
		chckbxNewCheckBox_4.setSelected(true);
		chckbxNewCheckBox_4.setEnabled(false);
		chckbxNewCheckBox_4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_4.setBounds(592, 120, 97, 25);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_4);

		JLabel lblScriviUnCommento = new JLabel("Il Tuo Commento:");
		lblScriviUnCommento.setHorizontalAlignment(SwingConstants.LEFT);
		lblScriviUnCommento.setForeground(SystemColor.textInactiveText);
		lblScriviUnCommento.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblScriviUnCommento.setBounds(41, 185, 188, 25);
		frmUntitledGaming.getContentPane().add(lblScriviUnCommento);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("black_icon.png"));
		button.setToolTipText("torna indietro");
		button.setBounds(10, 11, 37, 31);
		frmUntitledGaming.getContentPane().add(button);

		JLabel lblValutazione = new JLabel("Valutazione:");
		lblValutazione.setHorizontalAlignment(SwingConstants.LEFT);
		lblValutazione.setForeground(SystemColor.textInactiveText);
		lblValutazione.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblValutazione.setBounds(41, 120, 188, 25);
		frmUntitledGaming.getContentPane().add(lblValutazione);

		JTextPane txtpncommentoPrecedentementeInserito = new JTextPane();
		txtpncommentoPrecedentementeInserito.setText("-Commento precedentemente inserito dallo stesso utente-");
		txtpncommentoPrecedentementeInserito.setFont(new Font("Oregano", Font.ITALIC, 17));
		txtpncommentoPrecedentementeInserito.setEditable(false);
		txtpncommentoPrecedentementeInserito.setBackground(new Color(220, 220, 220));
		txtpncommentoPrecedentementeInserito.setBounds(81, 230, 577, 137);
		frmUntitledGaming.getContentPane().add(txtpncommentoPrecedentementeInserito);
	}
}
