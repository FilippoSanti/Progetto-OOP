package presentation;

import java.sql.Connection;
import java.sql.SQLException;

public class testClass {

    public static void main(String[] args) throws SQLException {

        // Registration
        System.out.println("Registration = " + controller.eventsListener.insertUser("davideu", "abcd", "davide",
                "ubaldi", "ca@a.il","user"));

        // Login
        System.out.println("Login = " + controller.eventsListener.userAuth("davideu","abcd"));

        // User info
        System.out.println(controller.eventsListener.getUserInfo("davideu"));

        // User stats
        System.out.println(controller.eventsListener.getUserStats("davideu"));

        // Add review
        System.out.println ("Review aggiunta = "+ controller.eventsListener.addReview("davideu", "Bene ma non benissimo", 3.5 ));

        // See pending reviews
        System.out.println(controller.eventsListener.getPendingReview());

        // Approve review
        System.out.println(controller.eventsListener.approveReview("davideu"));

        //check approved reviews
        System.out.println(controller.eventsListener.getApprovedReview());

        //edit login info
        System.out.println(controller.eventsListener.editLogin("u", "Genoveffo", "Pantalone",
                "Tiffany", "gubi@hotmail.it"));

    }

}
