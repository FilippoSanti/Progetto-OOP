import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.Button;
import javax.swing.JButton;

public class Recensione {

	private JFrame frmUntitledGaming;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recensione window = new Recensione();
					window.frmUntitledGaming.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Recensione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Scrivi Recensione");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 750, 500);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		
		JLabel lblValutaQuestoGioco = new JLabel("Valuta questo gioco:");
		lblValutaQuestoGioco.setForeground(SystemColor.textInactiveText);
		lblValutaQuestoGioco.setHorizontalAlignment(SwingConstants.CENTER);
		lblValutaQuestoGioco.setFont(new Font("Georgia", Font.ITALIC, 20));
		lblValutaQuestoGioco.setBounds(10, 60, 724, 25);
		frmUntitledGaming.getContentPane().add(lblValutaQuestoGioco);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("1");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(125, 125, 97, 23);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("2");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setBounds(224, 125, 97, 23);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("3");
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_2.setBounds(323, 125, 97, 23);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("4");
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_3.setBounds(422, 125, 97, 23);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("5");
		chckbxNewCheckBox_4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_4.setBounds(521, 125, 97, 23);
		frmUntitledGaming.getContentPane().add(chckbxNewCheckBox_4);
		
		JLabel lblScriviUnCommento = new JLabel("Scrivi un commento:");
		lblScriviUnCommento.setHorizontalAlignment(SwingConstants.CENTER);
		lblScriviUnCommento.setForeground(SystemColor.textInactiveText);
		lblScriviUnCommento.setFont(new Font("Georgia", Font.ITALIC, 20));
		lblScriviUnCommento.setBounds(10, 198, 724, 25);
		frmUntitledGaming.getContentPane().add(lblScriviUnCommento);
		
		JEditorPane dtrpnLasciaQuIl = new JEditorPane();
		dtrpnLasciaQuIl.setToolTipText("Scrivi un commento...");
		dtrpnLasciaQuIl.setText("   Lascia qu\u00EC il tuo commento...");
		dtrpnLasciaQuIl.setFont(new Font("Oregano", Font.ITALIC, 17));
		dtrpnLasciaQuIl.setBackground(new Color(220, 220, 220));
		dtrpnLasciaQuIl.setBounds(89, 243, 567, 130);
		frmUntitledGaming.getContentPane().add(dtrpnLasciaQuIl);
		
		JButton btnInviaRecensione = new JButton("Invia Recensione");
		btnInviaRecensione.setToolTipText("Invia Recensione");
		btnInviaRecensione.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnInviaRecensione.setBounds(302, 401, 141, 37);
		frmUntitledGaming.getContentPane().add(btnInviaRecensione);
	}
}
