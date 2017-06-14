package presentation;

import business.implementation.DBManager;
import controller.eventsListener;

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




    public static void testPath () {
        File directory = new File("./");
        System.out.println(directory.getAbsolutePath());

    }

}