package business.implementation.Interfaces;

import business.model.gameProfile;

import javax.swing.table.TableModel;
import java.sql.SQLException;

public interface AchievementsManagerInterface {

    /* Check if achievements have been unlocked */
    void checkAchievement(gameProfile gameProfile) throws SQLException;

    /* Add an achievement to a profile */
    boolean insertAchievementToProfile(int user_id, int achievement_id) throws SQLException;

    /* Get the available achievements */
    TableModel getAchievement() throws SQLException;

    /* Get the achievements list of a user */
    TableModel getUserAchievementsList(int userId) throws SQLException;

    /* Check if an achievement has been found on the profile */
    boolean AchievementFoundOnProfile(int achievement_id, int user_id) throws SQLException;

}
