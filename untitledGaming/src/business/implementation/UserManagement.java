package business.implementation;

import business.BusinessException;
import business.model.*;
import controller.eventsListener;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class UserManagement {

    /* Insert the user data into the DB */
    public boolean newUser(String user, String password, String nome, String cognome, String email, String dateString, int img_value, String tipo) throws SQLException {

        // Convert the date string to a  java.sql.Date format
        java.sql.Date date = null;
        try {
            date = Utils.stringToDate(dateString);
        } catch (ParseException e) {
            throw new BusinessException("Date format not valid");
        }

        PreparedStatement preparedStatement = null;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Password hashing
        password = business.implementation.DBManager.hashPassword(password);

        String insertTableSQL = "INSERT INTO utente"
                + "(username, password, nome, cognome, email, data_di_nascita, immagine_profilo, tipo) VALUES"
                + "(?,?,?,?,?,?,?,?)";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, cognome);
            preparedStatement.setString(5, email);
            preparedStatement.setDate(6, date);
            preparedStatement.setInt(7, img_value);
            preparedStatement.setString(8, tipo);

            // Insert SQL statement
            /* executeUpdate returns either the row count for SQL Data Manipulation Language (DML) statements or
               0 for SQL statements that return nothing
             */
            if (preparedStatement.executeUpdate() != 0 && eventsListener.setToNull(eventsListener.getUserID(user))
                    && (addTimeline(eventsListener.getUserID(user), 2, date, 0))) {

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

    /* Set to null the game profile attributes */
    public boolean setToNull(int userId) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Query
        String addXP = "INSERT INTO game_profile"
                + "(user_id, livello, punti_esperienza) VALUES"
                + "(?,1,0)";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(addXP);
            preparedStatement.setInt(1, userId);

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

        String nome, password, cognome, email, tipo;
        java.sql.Date data = null;
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
            nome = rs.getString("nome");
            email = rs.getString("email");
            cognome = rs.getString("cognome");
            tipo = rs.getString("tipo");
            userId = rs.getInt("user_id");
            password = rs.getString("password");
            data = rs.getDate("data_di_nascita");

        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String textDate = df.format(data);
        java.sql.Date DataFinale = null;

        try {
            DataFinale = Utils.stringToDate(textDate);

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }

        return new Utente(userId, username, nome, cognome, password, email, tipo, DataFinale);
    }

    /* Update the timeline informations */
    public boolean updateTimeline(int user_id, java.sql.Date dataUltima, int esperienzaGuadagnata, int gioco_id) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Query
        String addtimeline = "UPDATE timeline SET `data_ultima_sessione`= ?,`esperienza_guadagnata` = ? , `gioco_id` = ? WHERE user_id = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = dbConnection.prepareStatement(addtimeline);
            preparedStatement.setDate(1, dataUltima);
            preparedStatement.setInt(2, esperienzaGuadagnata);
            preparedStatement.setInt(4, user_id);
            preparedStatement.setInt(3, gioco_id);

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

    /* Add informations to the timeline */
    public boolean addTimeline(int user_id, int gioco_id, java.sql.Date dataUltima, int esperienzaGuadagnata) throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Query
        String addtimeline = "INSERT INTO timeline \n" +
                "            ( `user_id` , \n" +
                "             `gioco_id` , \n" +
                "             `data_ultima_sessione` , \n" +
                "             `esperienza_guadagnata` ) \n" +
                "VALUES      (?, \n" +
                "             ?, \n" +
                "             ?, \n" +
                "             ?) ";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = dbConnection.prepareStatement(addtimeline);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, gioco_id);
            preparedStatement.setDate(3, dataUltima);
            preparedStatement.setInt(4, esperienzaGuadagnata);

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
        dbConnection.close();
        return new gameProfile(gameProfileId, userId, livello, puntiXp);
    }

    /* Edit login info */
    public boolean setUtente(Utente utente, String nome, String cognome, String data, String email, String password, String newUsername) throws SQLException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        java.sql.Date tempDate = utente.getData();
        String text = formatter.format(tempDate);
        Date myDate = null;

        // If the password is not empty, we update it into the DB
        if (!password.isEmpty()) {
            eventsListener.updatePassword(utente.getUserId(), password);
        }

        // Check if the other fields are equal to the old ones or empty
        if (nome.isEmpty() || nome.equals(utente.getNome())) {
            nome = utente.getNome();
        }

        if (cognome.isEmpty() || cognome.equals(utente.getNome())) {
            cognome = utente.getCognome();
        }

        if (data.isEmpty() || data.equals(utente.getData())) {
            data = text;
        }

        if (email.isEmpty() || email.equals(utente.getEmail())) {
            email = utente.getEmail();
        }

        if (newUsername.isEmpty() || newUsername.equals(utente.getUsername())) {
            newUsername = utente.getUsername();
        }

        // Return false if every field is empty
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
            preparedStatement.setString(5, newUsername);
            preparedStatement.setInt(6, utente.getUserId());

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

    /* Adds a level to a user */
    public boolean addLivello(gameProfile gameProfile, int livello) throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Query
        String addLVL = "UPDATE game_profile SET `livello` =  ? "
                + "WHERE `user_id` = ?";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(addLVL);

            preparedStatement.setInt(1, livello);
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

    /* promote a user */
    public boolean setToModerator(String username) throws SQLException {

        Connection dbConnection = business.implementation.DBManager.Connect();

        String approveReview = "UPDATE `utente` SET `tipo` = 'moderator' WHERE `utente`.`username` = ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, username);

            // Insert SQL statement
            /* executeUpdate returns either the row count for SQL Data Manipulation Language (DML) statements or
               0 for SQL statements that return nothing
             */
            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Avvenuto con successo");
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

    public boolean setToUser(String username) throws SQLException {

        Connection dbConnection = business.implementation.DBManager.Connect();

        String approveReview = "UPDATE `utente` SET `tipo` = 'user' WHERE `utente`.`username` = ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, username);

            // Insert SQL statement
            /* executeUpdate returns either the row count for SQL Data Manipulation Language (DML) statements or
               0 for SQL statements that return nothing
             */
            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Avvenuto con successo");
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


    public boolean setToAdministrator(String username) throws SQLException {

        Connection dbConnection = business.implementation.DBManager.Connect();

        String approveReview = "UPDATE `utente` SET `tipo` = 'administrator' WHERE `utente`.`username` = ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setString(1, username);

            // Insert SQL statement
            /* executeUpdate returns either the row count for SQL Data Manipulation Language (DML) statements or
               0 for SQL statements that return nothing
             */
            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Avvenuto con successo");
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
    /* Determine the user level from the exp points */
    public void checkLivello(gameProfile gameProfile) throws SQLException {
        if (gameProfile.getEsperienza() >= 100 && gameProfile.getEsperienza()<250) {
            addLivello(gameProfile,2);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 2");
        } else if (gameProfile.getEsperienza() >= 250 && gameProfile.getEsperienza()<450) {
            addLivello(gameProfile,3);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 3");
        } else if (gameProfile.getEsperienza() >= 450 && gameProfile.getEsperienza()<700) {
            addLivello(gameProfile,4);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 4");
        } else if (gameProfile.getEsperienza() >= 700 && gameProfile.getEsperienza()<1100) {
            addLivello(gameProfile,5);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 5");
        } else if (gameProfile.getEsperienza() >= 1100 && gameProfile.getEsperienza()<1500) {
            addLivello(gameProfile,6);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 6");
        } else if (gameProfile.getEsperienza() >= 1500 && gameProfile.getEsperienza()<2000) {
            addLivello(gameProfile,7);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 7");
        } else if (gameProfile.getEsperienza() >= 2000 && gameProfile.getEsperienza()<2800) {
            addLivello(gameProfile,8);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 8");
        } else if (gameProfile.getEsperienza() >= 2800) {
            addLivello(gameProfile,9);
            JOptionPane.showMessageDialog(null, "Congratulazioni, hai raggiunto il livello 9");
        }
    }

    /* Check if achievements have been unlocked */
    public void checkAchievement(gameProfile gameProfile) throws SQLException {
        if ((gameProfile.getLivello() == 2) && (!eventsListener.AchievementFoundOnProfile(1, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Novizio !");
            eventsListener.insertAchievementToProfile(gameProfile.getUserId(), 1);
        }

        if ((gameProfile.getLivello() == 4) && (!eventsListener.AchievementFoundOnProfile(2, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Principiante !");
            eventsListener.insertAchievementToProfile(gameProfile.getUserId(), 2);
        }

        if ((gameProfile.getLivello() == 6) && (!eventsListener.AchievementFoundOnProfile(3, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Esperto !");
            eventsListener.insertAchievementToProfile(gameProfile.getUserId(), 3);
        }

        if ((gameProfile.getLivello() == 8) && (!eventsListener.AchievementFoundOnProfile(4, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Maestro !");
            eventsListener.insertAchievementToProfile(gameProfile.getUserId(), 4);
        }

        if ((eventsListener.getTimeline(gameProfile.getUserId()).getEsperienza_guadagnata() > 500) && (!eventsListener.AchievementFoundOnProfile(6, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Professionista !");
            eventsListener.insertAchievementToProfile(gameProfile.getUserId(), 6);
        }

        if ((eventsListener.getTimeline(gameProfile.getUserId()).getEsperienza_guadagnata() > 1000) && (!eventsListener.AchievementFoundOnProfile(5, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Flipper !");
            eventsListener.insertAchievementToProfile(gameProfile.getUserId(), 5);
        }

    }

    /* Check the timeline informations */
    public Timeline getTimeline(int userId) throws SQLException {

        int gioco_id = 0;
        int esperienza_guadagnata = 0;
        int timeline_id = 0;
        java.sql.Date data_ultima_sessione = null;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * \n" +
                "FROM   `timeline` \n" +
                "WHERE  user_id = ? ");

        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            timeline_id = rs.getInt("timeline_id");
            gioco_id = rs.getInt("gioco_id");
            esperienza_guadagnata = rs.getInt("esperienza_guadagnata");
            data_ultima_sessione = rs.getDate("" + "data_ultima_sessione");


        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String textDate = df.format(data_ultima_sessione);

        java.sql.Date DataFinale = null;
        try {

            DataFinale = Utils.stringToDate(textDate);

        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
        }
        return new Timeline(timeline_id, userId, gioco_id, DataFinale, esperienza_guadagnata);

    }

    /* Add an achievement to a profile */
    public boolean insertAchievementToProfile(int user_id, int achievement_id) throws SQLException {
        PreparedStatement preparedStatement = null;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        String insertTableSQL = "INSERT INTO achievement_ottenuti"
                + "(user_id, achievement_id) VALUES"
                + "(?,?)";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, achievement_id);


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

    /* Get the available achievements */
    public TableModel getAchievement() throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT achievement_id, \n" +
                        "       nome, \n" +
                        "descrizione, \n" +
                        "gioco_id" +

                        "FROM  achievement \n ");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();
        return tm;
    }

    /* Get the achievements list of a user */
    public TableModel getUserAchievementsList(int userId) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT\n" +
                "    achievement.nome, achievement.descrizione, achievement.gioco_id, achievement.achievement_id," +
                "achievement_ottenuti.user_id\n" +
                "FROM\n" +
                "    achievement_ottenuti INNER JOIN achievement\n" +
                "    ON achievement_ottenuti.achievement_id = achievement.achievement_id\n" +
                "WHERE\n" +
                "    achievement_ottenuti.user_id = ?");

        stmt.setInt(1, userId);

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();
        return tm;
    }

    /*Get the list of games */
    public TableModel getGames() throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT * FROM `gioco` ORDER BY `gioco`.`gioco_id` DESC");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();
        return tm;
    }

    /* Get the name of a game from its ID */
    public TableModel getGameNameByID(int gameId) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT nome FROM `gioco` WHERE gioco_id = ?");

        stmt.setInt(1, gameId);

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();
        return tm;

    }

    public boolean AchievementFoundOnProfile(int achievement_id, int user_id) throws SQLException {
        String achId = String.valueOf(achievement_id);
        for (int i = 0; i < eventsListener.getUserAchievementsList(user_id).getRowCount(); i++) {
            if (String.valueOf(eventsListener.getUserAchievementsList(user_id).getValueAt(i, 3)).equals(achId)) {

                return true;
            }
        }

        return false;

    }

    /*  tossTheCoin Minigame */
    public int tossTheCoin(Utente utente) throws SQLException {

        Random randomNum = new Random();
        int esperienza_sessione = 0;
        int result = randomNum.nextInt(2);

        if (result == 0) {
            JOptionPane.showMessageDialog(null, "You flipped Head! Gain 30 xP");
            eventsListener.addXP(utente, 30);
            esperienza_sessione = 30;
            eventsListener.checkLivello(getGameProfile(utente.getUserId()));
            eventsListener.checkAchievement(getGameProfile(utente.getUserId()));
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(null, "you flipped Tail! Gain 15 xP");
            esperienza_sessione = +15;
            eventsListener.addXP(utente, +15);
        }

        return esperienza_sessione;
    }


    /*  ShitOnCoin Minigame */
    public int ShitOnCoin(Utente utente) throws SQLException {

        Random randomNum = new Random();
        int esperienza_sessione = 0;
        int result = randomNum.nextInt(2);

        if (result == 0) {
            JOptionPane.showMessageDialog(null, "You Shitted Head! Gain 100 xP");
            eventsListener.addXP(utente, 100);
            esperienza_sessione = 100;
            eventsListener.checkLivello(getGameProfile(utente.getUserId()));
        }

        if (result == 1) {
            JOptionPane.showMessageDialog(null, "you shitted Tail! Gain 5 xP");
            esperienza_sessione = +5;
            eventsListener.addXP(utente, +5);
        }

        return esperienza_sessione;
    }

    public TableModel getUsers () throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT * FROM `utente` ");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }

    /* Get the user type */
    public String getUserType(int user_id) throws SQLException {

        String userType = null;

        // DB Connection
        Connection connection = DBManager.Connect();

        // Prepare and execute the query
        PreparedStatement st = connection.prepareStatement("select tipo from utente where user_id = ?");
        st.setInt(1, user_id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            userType = rs.getString("tipo");
        }

        return userType;
    }

    /* Update the password of a user */
    public boolean updatePassword(int userID, String password) throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Password hashing
        password = DBManager.hashPassword(password);

        // Declare the statement
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "UPDATE utente SET utente.password = ? WHERE user_id = ?";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, userID);

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

    /* Store a user image into the db */
    public boolean setImg (int userID, File imgfile) {
        try {

            // Open the connection
            Connection con  = business.implementation.DBManager.Connect();
            Statement  st   = con.createStatement();

            FileInputStream fin  = new FileInputStream(imgfile);

            // Prepare the query
            PreparedStatement pre =
                    con.prepareStatement("UPDATE utente\n" +
                            "SET immagine_profilo = ?\n" +
                            "WHERE utente.user_id = ?");

            pre.setInt   (2,userID);

            // Store the image into the db
            pre.setBinaryStream(1,(InputStream)fin,(int)imgfile.length());
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");

            // Close the connection
            pre.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    /* Get the user profile image */
    public boolean getImg(int userID, String filePathName) {
        try {

            File selectedfile;
            // Open the connection
            Connection con = DBManager.Connect();

            // Execute the query and get the ResultSet
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT `immagine_profilo` FROM `utente` WHERE user_id = ?");

            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            int i = 0;
            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File(filePathName));
                i++;
                int c = 0;
                while ((c = in.read()) > -1) {
                    f.write(c);
                }
                f.close();
                in.close();

                return true;
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /* Check if the profile pic of an user exists (true) */
    public boolean checkImage(int userID) throws SQLException {

        // DB Connection
        Connection connection = DBManager.Connect();

        int resultInt = 0;

        // Prepare and execute the query
        PreparedStatement st = null;

        st = connection.prepareStatement("select immagine_profilo from utente WHERE user_id = ?");

        st.setInt(1, userID);
        ResultSet rs = st.executeQuery();

        try {
            if (rs.next()) {
                resultInt = rs.getInt("immagine_profilo");
            }

        } catch (SQLException e) {
            return true;
        }

        if (resultInt == 0) return false;
        return true;
    }

    /* Get a user id from a username */
    public int getUserID(String user) throws SQLException {

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

    public String getUserTipo(String user) throws SQLException {

        // User id that will be returned
        String tipo = "";

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT tipo FROM utente WHERE username = ?");
        stmt.setString(1, user);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            tipo = rs.getString(1);
        }

        return tipo;
    }

    public String getUsername(int user_id) throws SQLException {
        String username = "";

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT username FROM utente WHERE user_id = ?");
        stmt.setInt(1, user_id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            username = rs.getString(1);
        }

        return username;
    }

    public String getGameFromId(int game_id) throws SQLException {
        String game = "";

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT nome FROM gioco WHERE gioco_id = ?");
        stmt.setInt(1, game_id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            game = rs.getString(1);
        }

        return game;
    }

    /* User authentication */
    public boolean userAuth(String username, String password) throws SQLException {

        // Get the user_id given the username
        int userID = eventsListener.getUserID(username);

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
    public ArrayList<String> getGame() throws SQLException {

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
}