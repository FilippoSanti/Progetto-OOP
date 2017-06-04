package presentation.general;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class editData {

    private JFrame         frmUntitledGaming;
    private JButton        button;
    private JTextField     textField;
    private JTextField     textField_1;
    private JTextField     textField_2;
    private JPasswordField passwordField;
    private JTextField     textField_3;
    private JTextField     textField_4;

    /**
     * Create the application.
     */
    public editData() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    editData window = new editData();
                    window.frmUntitledGaming.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Modifica Dati");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 750, 500);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Modifica i Tuoi Dati:");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 30));
        lblNewLabel.setBounds(0, 27, 734, 37);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("Applica Modifiche");
        btnNewButton.setToolTipText("Applica Modifiche");
        btnNewButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                System.out.println("Sei Registrato!");
            }
        });
        btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
        btnNewButton.setBounds(74, 385, 190, 46);
        frmUntitledGaming.getContentPane().add(btnNewButton);

        button = new JButton("");
        button.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\back_icon.png"));
        button.setToolTipText("torna indietro");
        button.setBounds(10, 10, 37, 31);
        frmUntitledGaming.getContentPane().add(button);

        textField = new JTextField();
        textField.setToolTipText("Nome");
        textField.setText("Nome");
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("Georgia", Font.ITALIC, 15));
        textField.setColumns(10);
        textField.setBounds(74, 105, 190, 40);
        frmUntitledGaming.getContentPane().add(textField);

        textField_1 = new JTextField();
        textField_1.setToolTipText("Cognome");
        textField_1.setText("Cognome");
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setForeground(Color.GRAY);
        textField_1.setFont(new Font("Georgia", Font.ITALIC, 15));
        textField_1.setColumns(10);
        textField_1.setBounds(74, 194, 190, 40);
        frmUntitledGaming.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setToolTipText("Et\u00E0");
        textField_2.setText("Et\u00E0");
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setForeground(Color.GRAY);
        textField_2.setFont(new Font("Georgia", Font.ITALIC, 15));
        textField_2.setColumns(10);
        textField_2.setBounds(74, 288, 190, 40);
        frmUntitledGaming.getContentPane().add(textField_2);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("Password");
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setForeground(Color.GRAY);
        passwordField.setFont(new Font("Georgia", Font.ITALIC, 15));
        passwordField.setBackground(Color.WHITE);
        passwordField.setBounds(464, 288, 190, 40);
        frmUntitledGaming.getContentPane().add(passwordField);

        textField_3 = new JTextField();
        textField_3.setToolTipText("E-m@il");
        textField_3.setText("E-m@il");
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setForeground(Color.GRAY);
        textField_3.setFont(new Font("Georgia", Font.ITALIC, 15));
        textField_3.setColumns(10);
        textField_3.setBounds(464, 194, 190, 40);
        frmUntitledGaming.getContentPane().add(textField_3);

        textField_4 = new JTextField();
        textField_4.setToolTipText("Username");
        textField_4.setText("Username");
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setForeground(Color.GRAY);
        textField_4.setFont(new Font("Georgia", Font.ITALIC, 15));
        textField_4.setColumns(10);
        textField_4.setBounds(464, 105, 190, 40);
        frmUntitledGaming.getContentPane().add(textField_4);

        JButton button_1 = new JButton("Applica Modifiche");
        button_1.setToolTipText("Applica Modifiche");
        button_1.setFont(new Font("MV Boli", Font.ITALIC, 14));
        button_1.setBounds(464, 385, 190, 46);
        frmUntitledGaming.getContentPane().add(button_1);
    }
}
