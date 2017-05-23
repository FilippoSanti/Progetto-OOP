package presentation;

import java.sql.Connection;
import java.sql.SQLException;

public class testClass {

    public static void main(String[] args) throws SQLException {

        // Registrazione
        Connection conn = business.implementation.DBManager.Connect();
        System.out.println("Registration = " + controller.eventsListener.insertUser(conn, "test_userx", "pass312", "stefano",
                "de ciantis", "m@a.il","user"));

        // Login
        Connection conn_2 = business.implementation.DBManager.Connect();
        System.out.println("Login = " + controller.eventsListener.userAuth(conn_2, "test_userx","pass312"));

    }

}
