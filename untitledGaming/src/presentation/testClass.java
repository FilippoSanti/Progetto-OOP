package presentation;

import controller.eventsListener;

import java.sql.SQLException;

public class testClass {

    public static void main(String[] args) throws SQLException {

        System.out.println(controller.eventsListener.setUtente(controller.eventsListener.getUtente("davideu"), "dAAA",
                "gasdonsse", "giasdnone", "gasdone", "gasde"));

        controller.eventsListener.approveReview(eventsListener.getReview(17));

    }
}