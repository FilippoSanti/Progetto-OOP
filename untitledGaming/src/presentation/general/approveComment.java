package presentation.general;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class approveComment {

	private JFrame frmUntitledGaming;

	/**
	 * Create the application.
	 */
	public approveComment() {
		initialize();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					approveComment window = new approveComment();
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
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		frmUntitledGaming.setLocationRelativeTo(null);
		
		JButton btnApprovaCommento = new JButton("Approva Commento");
		btnApprovaCommento.setToolTipText("Invia Recensione");
		btnApprovaCommento.setFont(new Font("MV Boli", Font.ITALIC, 18));
		btnApprovaCommento.setBounds(124, 545, 260, 46);
		frmUntitledGaming.getContentPane().add(btnApprovaCommento);
		
		JButton btnEliminaCommento = new JButton("Elimina Commento");
		btnEliminaCommento.setToolTipText("Invia Recensione");
		btnEliminaCommento.setFont(new Font("MV Boli", Font.ITALIC, 18));
		btnEliminaCommento.setBounds(560, 545, 260, 46);
		frmUntitledGaming.getContentPane().add(btnEliminaCommento);
		
		JLabel lblHaScritto_1 = new JLabel("ha scritto:");
		lblHaScritto_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblHaScritto_1.setForeground(SystemColor.textInactiveText);
		lblHaScritto_1.setFont(new Font("Georgia", Font.ITALIC, 30));
		lblHaScritto_1.setBounds(417, 87, 190, 35);
		frmUntitledGaming.getContentPane().add(lblHaScritto_1);
		
		JLabel lblusername = new JLabel("-Username-");
		lblusername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblusername.setForeground(SystemColor.textInactiveText);
		lblusername.setFont(new Font("Georgia", Font.ITALIC, 30));
		lblusername.setBounds(177, 87, 226, 35);
		frmUntitledGaming.getContentPane().add(lblusername);
		
		JTextPane txtpncommentoPrecedentementeInserito = new JTextPane();
		txtpncommentoPrecedentementeInserito.setBackground(new Color(220, 220, 220));
		txtpncommentoPrecedentementeInserito.setFont(new Font("Oregano", Font.ITALIC, 25));
		txtpncommentoPrecedentementeInserito.setText("-Commento precedentemente inserito DA VALUTARE-");
		txtpncommentoPrecedentementeInserito.setEditable(false);
		txtpncommentoPrecedentementeInserito.setBounds(124, 206, 696, 223);
		frmUntitledGaming.getContentPane().add(txtpncommentoPrecedentementeInserito);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\back-icon.png"));
		button.setToolTipText("torna indietro");
		button.setBounds(10, 11, 45, 45);
		frmUntitledGaming.getContentPane().add(button);
	}
}
