package presentation;

import java.sql.Connection;
import java.sql.SQLException;

public class testClass {

    public static void main(String[] args) throws SQLException {

        // Registrazione
        System.out.println("Registration = " + controller.eventsListener.insertUser("test_userx", "pass312", "stefano",
                "de ciantis", "m@a.il","user"));

        // Login
        System.out.println("Login = " + controller.eventsListener.userAuth("test_userx","pass312"));

        // Get user info
        System.out.println(controller.eventsListener.getUserInfo("test_userx"));
    }

}
