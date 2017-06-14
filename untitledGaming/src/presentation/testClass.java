package presentation;

import business.implementation.DBManager;
import business.model.Achievement;
import controller.eventsListener;

import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;

public class testClass {

    public static void main(String[] args) throws SQLException {

        Date data = null;
        try {
            data = DBManager.stringToDate("11-11-1111");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(eventsListener.getGameFromId(6));
    }

}