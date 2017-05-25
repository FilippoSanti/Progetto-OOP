package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class eventsListener {

    /* Insert the user data into the DB */
    public static boolean insertUser(String user, String password, String nome, String cognome, String email, String tipo) throws SQLException {

        PreparedStatement preparedStatement = null;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Password hashing
        String hashedPass = business.implementation.DBManager.hashPassword(password);

        String insertTableSQL = "INSERT INTO utente"
                + "(username, password, nome, cognome, email, tipo) VALUES"
                + "(?,?,?,?,?,?)";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, hashedPass);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, cognome);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, tipo);

            // Insert SQL statement
            /* executeUpdate returns either the row count for SQL Data Manipulation Language (DML) statements or
               0 for SQL statements that return nothing
             */
            if (preparedStatement.executeUpdate() != 0) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return false;
    }

    /* User authentication */
    public static boolean userAuth(String username, String password) {

        // DB Connection
        Connection conn = business.implementation.DBManager.Connect();

        try {
            PreparedStatement pst = conn.prepareStatement("Select * from utente where username=?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String hashedPass = rs.getString("password");

                //Check if the provided password and the hashed one are equal
                if (business.implementation.DBManager.checkPassword(password, hashedPass))
                    return true;
                else return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /* Get the user information */
    public static ArrayList<String> getUserInfo (String username) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // List of strings that will be returned later
        ArrayList userInfo = new ArrayList<String>();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT `username`, `nome`, `cognome`, `email` FROM `utente` WHERE `username` = ?");
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        // Fetch data from the result set
        int columnCount = rs.getMetaData().getColumnCount();
        rs.next();
        for (int i = 0; i <columnCount ; i++)
        {
            userInfo.add( rs.getString(i + 1) );
        }

        return userInfo;
    }

}
