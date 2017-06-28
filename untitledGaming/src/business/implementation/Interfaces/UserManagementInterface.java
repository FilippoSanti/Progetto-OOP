package business.implementation.Interfaces;

import business.model.Utente;
import business.model.gameProfile;

import javax.swing.table.TableModel;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserManagementInterface {

    /* Insert the user data into the DB */
    boolean newUser(String user, String password, String nome, String cognome, String email, String dateString, int img_value, String tipo) throws SQLException;

    /* Add User informations to the timeline */
    boolean addUserToTimeline(int user_id, int gioco_id, java.sql.Date dataUltima, int esperienzaGuadagnata) throws SQLException;

    /* Set to null the game profile attributes */
    boolean setToNull(int userId) throws SQLException;

    /* Get the user informations */
    Utente getUtente(String username) throws SQLException;

    /* Get the user profile stats */
    gameProfile getGameProfile(int userId) throws SQLException;

    /* Edit login info */
    boolean setUtente(Utente utente, String nome, String cognome, String data, String email, String password, String newUsername) throws SQLException;

    /* Add xp to a user */
    boolean addXp(Utente utente, int xP) throws SQLException;

    /* Adds a level to a user */
    boolean addLivello(gameProfile gameProfile, int livello) throws SQLException;

    /* promote a user */
    boolean setToModerator(String username) throws SQLException;

    boolean setToUser(String username) throws SQLException;

    boolean setToAdministrator(String username) throws SQLException;

    /* Determine the user level from the exp points */
    void checkLivello(gameProfile gameProfile) throws SQLException;

    /*Get the list of games */
    TableModel getGames() throws SQLException;

    /* Get the name of a game from its ID */
    TableModel getGameNameByID(int gameId) throws SQLException;

    TableModel getUsers () throws SQLException;

    /* Get the user type */
    String getUserType(int user_id) throws SQLException;

    /* Update the password of a user */
    boolean updatePassword(int userID, String password) throws SQLException;

    /* Store a user image into the db */
    boolean setImg (int userID, File imgfile);

    /* Get the user profile image */
    boolean getImg(int userID, String filePathName);

    /* Check if the profile pic of an user exists (true) */
    boolean checkImage(int userID) throws SQLException;

    /* Get a user id from a username */
    int getUserID(String user) throws SQLException;

    String getUserTipo(String user) throws SQLException;

    String getUsername(int user_id) throws SQLException;

    String getGameFromId(int game_id) throws SQLException;

    /* User authentication */
    boolean userAuth(String username, String password) throws SQLException;

    /* Get the game list */
    ArrayList<String> getGame() throws SQLException;

}
