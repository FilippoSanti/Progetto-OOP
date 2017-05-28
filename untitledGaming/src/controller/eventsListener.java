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

    /* Get the user stats */
    public static ArrayList<String> getUserStats (String username) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // List of strings that will be returned later
        ArrayList userStats = new ArrayList<String>();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT game_profile.livello,\n" +
                        "       game_profile.punti_esperienza,\n" +
                        "       achievement.nome,\n" +
                        "       achievement.descrizione,\n" +
                        "       achievement.username\n" +
                        "FROM achievement\n" +
                        "INNER JOIN game_profile ON game_profile.username = game_profile.username\n" +
                        "WHERE achievement.username = ?");

        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        // Fetch data from the result set
        int columnCount = rs.getMetaData().getColumnCount();
        rs.next();
        for (int i = 0; i <columnCount ; i++)
        {
            userStats.add( rs.getString(i + 1) );
        }

        return userStats;
    }
    
     /* Adds a review */
    public static boolean addReview(String user, String review, double vote) throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        String insertTableSQL = "INSERT INTO recensioni"+"(username, testo_recensione, voto, approvata) VALUES" +
                "(?, ?, ?, false)";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, review);
            preparedStatement.setDouble(3, vote);



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

    /* Returns pending reviews */
    public static ArrayList<String> getPendingReview() throws SQLException
    {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // List of strings that will be returned later
        ArrayList<String> pendingReview = new ArrayList<String>();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT * FROM `recensioni` where recensioni.approvata = 0");

        ResultSet rs = stmt.executeQuery();

        // Fetch data from the result set
        int columnCount = rs.getMetaData().getColumnCount();





        while (rs.next()) {
            for (int i = 0; i < columnCount; i++) {

                pendingReview.add(rs.getString(i + 1));

            }
        }
        return pendingReview;
    }

    /* Returns approved reviews */
    public static ArrayList<String> getApprovedReview() throws SQLException
    {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // List of strings that will be returned later
        ArrayList<String> approvedReviews = new ArrayList<String>();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT * FROM `recensioni` where recensioni.approvata = 1");

        ResultSet rs = stmt.executeQuery();

        // Fetch data from the result set
        int columnCount = rs.getMetaData().getColumnCount();





        while (rs.next()) {
            for (int i = 0; i < columnCount; i++) {

               approvedReviews.add(rs.getString(i + 1));

            }
        }
        return approvedReviews;
    }

    /* Approve a review */
    public static boolean approveReview (String user) throws SQLException {

        Connection dbConnection = business.implementation.DBManager.Connect();

        String approveReview = "UPDATE `recensioni` SET `approvata` = '1' WHERE `recensioni`.`username` = ?";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, user);




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
}
