package presentation;

import business.implementation.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;

public class testClass {

    public static void main(String[] args) throws SQLException {
        testPath();
        System.out.println(business.implementation.DBManager.checkImage(7));
    }

<<<<<<< HEAD
        Date data = null;
        try {
            data = DBManager.stringToDate("11-11-1111");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(eventsListener.getGameFromId(6));
=======
    public static void testPath () {
        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());
>>>>>>> d099b845c914a1e57cd46c989cbfa1bc5ef3e457
    }

}