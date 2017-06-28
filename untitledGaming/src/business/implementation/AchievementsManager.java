package business.implementation;

import business.implementation.Interfaces.AchievementsManagerInterface;
import business.model.gameProfile;
import controller.eventsListener;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AchievementsManager implements AchievementsManagerInterface {

    /* Check if achievements have been unlocked */
    public void checkAchievement(gameProfile gameProfile) throws SQLException {
        if ((gameProfile.getLivello() == 2) && (!AchievementFoundOnProfile(1, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Novizio !");
            insertAchievementToProfile(gameProfile.getUserId(), 1);
        }

        if ((gameProfile.getLivello() == 4) && (!AchievementFoundOnProfile(2, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Principiante !");
            insertAchievementToProfile(gameProfile.getUserId(), 2);
        }

        if ((gameProfile.getLivello() == 6) && (!AchievementFoundOnProfile(3, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Esperto !");
            insertAchievementToProfile(gameProfile.getUserId(), 3);
        }

        if ((gameProfile.getLivello() == 8) && (!AchievementFoundOnProfile(4, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Maestro !");
            insertAchievementToProfile(gameProfile.getUserId(), 4);
        }

        if ((new TimelineManagement().getTimeline(gameProfile.getUserId()).getEsperienza_guadagnata() > 500) && (!AchievementFoundOnProfile(6, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Professionista !");
            insertAchievementToProfile(gameProfile.getUserId(), 6);
        }

        if ((new TimelineManagement().getTimeline(gameProfile.getUserId()).getEsperienza_guadagnata() > 1000) && (!AchievementFoundOnProfile(5, gameProfile.getUserId()))) {
            JOptionPane.showMessageDialog(null, "Hai sbloccato l achievement : Flipper !");
            insertAchievementToProfile(gameProfile.getUserId(), 5);
        }
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

    /* Check if an achievement has been found on the profile */
    public boolean AchievementFoundOnProfile(int achievement_id, int user_id) throws SQLException {
        String achId = String.valueOf(achievement_id);
        for (int i = 0; i < getUserAchievementsList(user_id).getRowCount(); i++) {
            if (String.valueOf(getUserAchievementsList(user_id).getValueAt(i, 3)).equals(achId)) {

                return true;
            }
        }
        return false;
    }
}
