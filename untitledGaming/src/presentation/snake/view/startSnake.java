package presentation.snake.view;

import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class startSnake {

    Utente utente;

    public startSnake(Utente u) {
        this.utente = u;
        init();
    }

    private void init() {

        //Creating the window with all its awesome snaky features

        Window f1 = new Window(utente);

        //Setting up the window settings
        f1.setTitle("Snake");
        f1.setSize(700, 700);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Window finalF = f1;
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                        null, "Vuoi davvero chiudere l' applicazione?",
                        "Conferma Uscita", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    finalF.setVisible(false);
                    business.implementation.Utils.Utilities.changePage("allGames", utente);
                }
            }
        };
        f1.addWindowListener(exitListener);
        f1.setLocationRelativeTo(null);

    }
}
