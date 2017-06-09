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

public class testClass {

    public static void main(String[] args) throws SQLException {

        System.out.println(eventsListener.AchievementFoundOnProfile(2, 33));
    }

}