package business.implementation;

import business.model.Utente;
import business.model.gameProfile;
import controller.eventsListener;
import net.proteanit.sql.DbUtils;
import sun.util.calendar.LocalGregorianCalendar;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
import java.util.zip.DataFormatException;

public class UserManagement {

    /* Insert the user data into the DB */
    public static boolean newUser(String user, String password, String nome, String cognome, String email, String dateString, String tipo) throws SQLException {

        // Convert the date string to a  java.sql.Date format
        java.sql.Date date = null;
        try {
            date = DBManager.stringToDate(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Check if one of the fields is empty
        if (user.isEmpty() || password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || dateString.isEmpty())
            return false;

        // Check if the username is already registered
        if (business.implementation.DBManager.checkUsername(user))
            return false;

        // Check if the email is already registered
        if (business.implementation.DBManager.checkEmail(email))
            return false;

        PreparedStatement preparedStatement = null;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Password hashing
        password = business.implementation.DBManager.hashPassword(password);

        String insertTableSQL = "INSERT INTO utente"
                + "(username, password, nome, cognome, email, data_di_nascita, tipo) VALUES"
                + "(?,?,?,?,?,?,?)";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, cognome);
            preparedStatement.setString(5, email);
            preparedStatement.setDate  (6, date);
            preparedStatement.setString(7, tipo);

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

    /* Get the user informations */
    public Utente getUtente(String username) throws SQLException {

        String nome, password, cognome, email, tipo; java.sql.Date data = null;
        nome = password = cognome = email = tipo = "";
        

        int userId = 0;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * \n" +
                "FROM   `utente` \n" +
                "WHERE  username = ? ");

        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            nome     = rs.getString("nome");
            email    = rs.getString("email");
            cognome  = rs.getString("cognome");
            tipo     = rs.getString("tipo");
            userId   = rs.getInt("user_id");
            password = rs.getString("password");
            data = rs.getDate("data_di_nascita");

        }

        return new Utente(userId, username, nome, cognome, password, email, tipo, data);
    }

    /* Get the user profile stats */
    public gameProfile getGameProfile(int userId) throws SQLException {

        int gameProfileId, livello, puntiXp;
        gameProfileId = livello = puntiXp = 0;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * \n" +
                "FROM   `game_profile` \n" +
                "WHERE  user_id = ? ");

        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            gameProfileId = rs.getInt("game_profile_id");
            livello = rs.getInt("livello");
            puntiXp = rs.getInt("punti_esperienza");

        }
        //c.close();
        return new gameProfile(gameProfileId, userId, livello, puntiXp);
    }


    /* Edit login info */
    public boolean setUtente(Utente utente, String nome, String cognome, String data, String email, String password, String newUsername) throws SQLException {

        DateFormat    formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date tempDate  = utente.getData();
        String        text      = formatter.format(tempDate);
        Date          myDate    = null;

        if (nome.isEmpty())          nome        = utente.getNome();
        if (cognome.isEmpty())       cognome     = utente.getCognome();
        if (data.isEmpty())          data        = text;
        if (email.isEmpty())         email       = utente.getEmail();
        if (password.isEmpty())      password    = utente.getPassword();
        if (newUsername.isEmpty())   newUsername = utente.getUsername();

        // Check if the fields are empty
        if (nome.isEmpty() && cognome.isEmpty() && data.isEmpty() && email.isEmpty() && password.isEmpty() && newUsername.isEmpty())
            return false;

        try {
            myDate = formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Query
        String approveReview = "UPDATE utente \n" +
                "SET nome = ?, \n" +
                " cognome = ?, \n" +
                " data_di_nascita = ?,\n" +
                "email = ?, \n " +
                "password = ?, \n " +
                "username = ? " +
                "WHERE user_id = ?";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, cognome);
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, newUsername);
            preparedStatement.setInt(7, utente.getUserId());

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

    /* Add xp to a user */
    public boolean addXp(Utente utente, int xP) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Query
        String addXP = "UPDATE game_profile SET `punti_esperienza` = game_profile.punti_esperienza + ? "
                + "WHERE `user_id` = ?";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(addXP);

            preparedStatement.setInt(1, xP);
            preparedStatement.setInt(2, utente.getUserId());

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

    public boolean addLivello (gameProfile gameProfile) throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Query
        String addLVL = "UPDATE game_profile SET `livello` = game_profile.livello + ? "
                + "WHERE `user_id` = ?";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(addLVL);

            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, gameProfile.getUserId());

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

    public void checkLivello (gameProfile gameProfile) throws SQLException {
        if (gameProfile.getEsperienza() >= 100 && gameProfile.getLivello() == 1) {
            addLivello(gameProfile); JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 2");}

        else if (gameProfile.getEsperienza() >= 250 && gameProfile.getLivello() == 2) {
            addLivello(gameProfile); JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 3");}

        else if (gameProfile.getEsperienza() >= 450 && gameProfile.getLivello() == 3) {
            addLivello(gameProfile); JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 4");}

        else if (gameProfile.getEsperienza() >= 700 && gameProfile.getLivello() == 1) {
            addLivello(gameProfile); JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 5");}
    }

    /*Get the list of games */
    public TableModel getGames() throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT gioco_id, \n" +
                        "       nome, \n" +

                        "FROM   gioco \n ");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);

        return tm;
    }

    public void tossTheCoin (Utente utente) throws SQLException
    {
        Random randomNum = new Random();
        int result = randomNum.nextInt(2);

        if (result == 0) {
            JOptionPane.showMessageDialog(null, "You flipped Head! Gain 30 xP");

            eventsListener.addXP(utente, 30);
            eventsListener.checkLivello(getGameProfile(utente.getUserId()));

        }

        if (result == 1) {
            JOptionPane.showMessageDialog(null, "you flipped Tail! Lose 20 xP");
            eventsListener.addXP(utente, -20);
        }



    }
}
