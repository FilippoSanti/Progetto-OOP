package testing_snake;

import business.model.Utente;

import javax.swing.JFrame;
import java.awt.*;

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
        f1.setSize(300, 300);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
