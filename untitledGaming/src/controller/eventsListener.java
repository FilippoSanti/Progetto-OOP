package controller;

import business.implementation.ReviewManagement;
import business.implementation.UserManagement;
import business.model.Review;
import business.model.Utente;
import business.model.gameProfile;
import presentation.general.*;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class eventsListener {

    /* Get a user id from a username */
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

    public static void newUser (String username, String nome, String cognome, String password, String email, String date, String tipo)throws SQLException{

        if (business.implementation.UserManagement.newUser(username, nome, cognome, password, email, date, tipo)) {
            JOptionPane.showMessageDialog(null, "Utente aggiunto correttamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error, try again");
        }

    }

    public static Utente getUtente (String username) throws SQLException {
        return new UserManagement().getUtente(username);
    }

    public static boolean setUtente(Utente utente, String nome, String cognome, String date, String email, String password, String newUsername)
             throws SQLException {


        return new UserManagement().setUtente(utente, nome, cognome, date, email, password, newUsername);
    }

    public static void addReview (Utente utente, String review, double vote) throws SQLException {
        if (new ReviewManagement().newReview(utente, review, vote)) {
            JOptionPane.showMessageDialog(null, "Review aggiunta correttamente.");
        }

    }

    public static Review getReview (int user_id) throws SQLException {
        return new ReviewManagement().getReview(user_id);
    }

    public static TableModel getPendingReviews() throws SQLException {
        return new ReviewManagement().getPendingReviews();
    }

    public static TableModel getApprovedReviews () throws SQLException {
        return new ReviewManagement().getApprovedReviews();
    }

    public static boolean approveReview (Review review) throws SQLException {
        return new business.implementation.ReviewManagement().approveReview(review);
    }

    public static boolean addXP(Utente utente, int xP) throws SQLException {
        return new business.implementation.UserManagement().addXp(utente, xP);
    }

    public static boolean addLivello (gameProfile gameProfile) throws SQLException {
        return new business.implementation.UserManagement().addLivello(gameProfile);
    }

    public static void checkLivello (gameProfile gameProfile) throws SQLException {
        new business.implementation.UserManagement().checkLivello(gameProfile);
    }

    public static TableModel getGames () throws SQLException {
        return new business.implementation.UserManagement().getGames();
    }

    public static gameProfile getGameProfile (int user_id) throws SQLException
    {
        return new business.implementation.UserManagement().getGameProfile(user_id);
    }

    /* User authentication */
    public static boolean userAuth(String username, String password) throws SQLException{

        // Get the user_id given the username
        int userID = getUserID(username);

        // DB Connection
        Connection conn = business.implementation.DBManager.Connect();

        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM utente WHERE user_id = ?");
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

    /* Get the game list */
    public static ArrayList<String> getGame () throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // List of strings that will be returned later
        ArrayList gameList = new ArrayList<String>();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT `nome` FROM `gioco`");
        ResultSet rs = stmt.executeQuery();

        // Fetch data from the result set
        int columnCount = rs.getMetaData().getColumnCount();

        while (rs.next()) {
            for (int i = 0; i < columnCount; i++) {
                gameList.add(rs.getString(i + 1));
            }
        }
        return gameList;
    }

    public static void tossTheCoin (Utente utente) throws SQLException {
        new business.implementation.UserManagement().tossTheCoin (utente);
    }

    /* Change the current JFrame */
    public static void changePage (String page, Utente utente) {
        switch (page){
            case "startPage":
                new startPage();
                break;

            case "registration":
                new registration();
                break;

            case "logged":
                new logged(utente);
                break;

            case "profile":
                new profile(utente);
                break;

            case "viewReview":
                new viewReview(utente);
                break;

            case "editData":
                new editData(utente);
                break;

            case "tossTheCoin":
                new tossTheCoin(utente);
                break;
        }
    }
}


