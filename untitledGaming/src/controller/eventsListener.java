package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class eventsListener {

    /* Get a user id given a username */
    public static int getUserID (String user) throws SQLException {

        // User id that will be returned
        int userID = 0;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT user_id FROM utente WHERE username = ?");
        stmt.setString(1, user);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            userID = rs.getInt(1);
        }

        return userID;
    }

    /* Insert the user data into the DB */
    public static boolean insertUser(String user, String password, String nome, String cognome, String email, String tipo) throws SQLException {

        PreparedStatement preparedStatement  = null;
        PreparedStatement preparedStatement1 = null;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Password hashing
        password = business.implementation.DBManager.hashPassword(password);

        String insertTableSQL = "INSERT INTO utente"
                + "(username, password, nome, cognome, email, tipo) VALUES"
                + "(?,?,?,?,?,?)";

        // Insert the values into the DB
        try {
            preparedStatement  = dbConnection.prepareStatement(insertTableSQL);
           // preparedStatement1 = dbConnection.prepareStatement(insertGameProfileSQL);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
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
    public static boolean userAuth(String username, String password) throws SQLException{

        int userID = getUserID(username);

        // DB Connection
        Connection conn = business.implementation.DBManager.Connect();

        try {
            PreparedStatement pst = conn.prepareStatement("Select * from utente where user_id=?");
            pst.setInt(1, userID);
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
        for (int i = 0; i < columnCount ; i++)
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
                "SELECT game_profile.livello, \n" +
                        "       game_profile.punti_esperienza, \n" +
                        "       achievement.nome, \n" +
                        "       achievement.descrizione \n" +
                        "FROM   achievement \n" +
                        "       INNER JOIN game_profile \n" +
                        "               ON game_profile.user_id = achievement.user_id \n" +
                        "       INNER JOIN utente \n" +
                        "               ON game_profile.user_id = utente.user_id \n" +
                        "WHERE  utente.username = ? ");

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

        int userID = getUserID(user);

        String insertTableSQL = "INSERT INTO recensioni"+"(user_id, testo_recensione, voto, approvata) VALUES" +
                "(?, ?, ?, false)";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, userID);
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

    /* Edit login info */
    public static boolean editLogin (String oldUsername, String newUsername, String nome, String cognome, String password, String email) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        int userID = getUserID(oldUsername);
        // Query
        String approveReview = "UPDATE utente \n" +
                "SET nome = ?, \n" +
                " cognome = ?, \n" +
                " password = ?, \n" +
                " email = ?, \n" +
                " username = ?\n" +
                "WHERE user_id = ?";

        PreparedStatement preparedStatement = null;

        String hashedPass = business.implementation.DBManager.hashPassword(password);

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cognome);
            preparedStatement.setString(3, hashedPass);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, newUsername);
            preparedStatement.setInt(6, userID);

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

    public static boolean addXP() {return false;}
}


