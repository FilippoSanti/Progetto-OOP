package presentation;

import java.sql.Connection;
import java.sql.SQLException;

public class testClass {

    public static void main(String[] args) throws SQLException {

        // Registration
        System.out.println("Registration = " + controller.eventsListener.insertUser("mikesh", "password", "stefano",
                "de ciantis", "m@a.il","user"));

        // Login
        System.out.println("Login = " + controller.eventsListener.userAuth("test_userx","password"));

        // User info
        System.out.println(controller.eventsListener.getUserInfo("mikesh"));

        // User stats
        System.out.println(controller.eventsListener.getUserStats("mikesh"));
    }

}
