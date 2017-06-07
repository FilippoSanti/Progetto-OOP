package presentation;

import business.implementation.DBManager;
import controller.eventsListener;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testClass {

    public static void main(String[] args) throws SQLException {

        try {
            Date data = DBManager.stringToDate("26-11-1990");

        System.out.println(eventsListener.updateTimeline(20, data , 155500));
    } catch (ParseException e) {
        e.printStackTrace();
        }
} }