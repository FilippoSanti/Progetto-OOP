package presentation;

import controller.eventsListener;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class testClass {

    public static void main(String[] args) throws SQLException {





        controller.eventsListener.approveReview(eventsListener.getReview(17));

    }
}