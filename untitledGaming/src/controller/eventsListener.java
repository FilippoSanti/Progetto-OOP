package controller;

import business.implementation.ReviewManagement;
import business.implementation.UserManagement;
import business.model.*;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class eventsListener {

    public static void newUser(String username, String password, String nome, String cognome, String email, String dateString, int img_value, String tipo) throws SQLException {

        if (new UserManagement().newUser(username, password, nome, cognome, email, dateString, img_value, tipo)) {
            JOptionPane.showMessageDialog(null, "Registrazione avvenuta correttamente");
        } else {
            JOptionPane.showMessageDialog(null, "Errore, riprova");
        }
    }

    public static boolean setToNull(int userId) throws SQLException {
        return new business.implementation.UserManagement().setToNull(userId);
    }

    public static Utente getUtente(String username) throws SQLException {
        return new UserManagement().getUtente(username);
    }

    public static boolean setUtente(Utente utente, String nome, String cognome, String date, String email, String password, String newUsername)
            throws SQLException {

        return new UserManagement().setUtente(utente, nome, cognome, date, email, password, newUsername);
    }

    public static void newReview(Utente utente, String review, int giocoId, double vote, boolean approved) throws SQLException {
        if (new ReviewManagement().newReview(utente, review, giocoId, vote, approved)) {
            if (approved) {
                JOptionPane.showMessageDialog(null, "Review aggiunta correttamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Review aggiunta correttamente. In attesa di approvazione");
            }
        }
    }

    public static Timeline getTimeline(int userId) throws SQLException {
        return new business.implementation.UserManagement().getTimeline(userId);
    }

    public static boolean addTimeline(int user_id, int gioco_id, java.sql.Date dataUltima, int esperienzaGuadagnata) throws SQLException {
        return new UserManagement().addTimeline(user_id, gioco_id, dataUltima, esperienzaGuadagnata);
    }

    public static Review getReview(int user_id, int game_id) throws SQLException {
        return new ReviewManagement().getReview(user_id, game_id);
    }

    public static TableModel getPendingReviews() throws SQLException {
        return new ReviewManagement().getPendingReviews();
    }

    public static TableModel getApprovedReviews() throws SQLException {
        return new ReviewManagement().getApprovedReviews();
    }

    public static boolean approveReview(Review review) throws SQLException {
        return new business.implementation.ReviewManagement().approveReview(review);
    }

    public static boolean addXP(Utente utente, int xP) throws SQLException {
        return new business.implementation.UserManagement().addXp(utente, xP);
    }

    public static boolean addLivello(gameProfile gameProfile, int livello) throws SQLException {
        return new business.implementation.UserManagement().addLivello(gameProfile, livello);
    }

    public static void checkLivello(gameProfile gameProfile) throws SQLException {
        new business.implementation.UserManagement().checkLivello(gameProfile);
    }

    public static TableModel getGames() throws SQLException {
        return new business.implementation.UserManagement().getGames();
    }

    public static gameProfile getGameProfile(int user_id) throws SQLException {
        return new business.implementation.UserManagement().getGameProfile(user_id);
    }

    public static boolean updateTimeline(int user_id, java.sql.Date dataUltima, int esperienzaGuadagnata, int gioco_id) throws SQLException {
        return new business.implementation.UserManagement().updateTimeline(user_id, dataUltima, esperienzaGuadagnata, gioco_id);
    }

    public static void checkAchievement(gameProfile gameProfile) throws SQLException {
        new business.implementation.UserManagement().checkAchievement(gameProfile);
    }

    public static boolean AchievementFoundOnProfile(int achievement_id, int user_id) throws SQLException {
        return new business.implementation.UserManagement().AchievementFoundOnProfile(achievement_id, user_id);
    }

    public static TableModel getAllReviews() throws SQLException {
        return new business.implementation.ReviewManagement().getAllReviews();
    }

    public static boolean reviewFoundOnProfile(int user_id, int game_id) throws SQLException {
        return new business.implementation.ReviewManagement().reviewFoundOnProfile(user_id, game_id);
    }


    public static boolean insertAchievementToProfile(int user_id, int achievement_id) throws SQLException {
        return new business.implementation.UserManagement().insertAchievementToProfile(user_id, achievement_id);
    }

    public static boolean deleteReview(Review review) throws SQLException {
        return new business.implementation.ReviewManagement().deleteReview(review);
    }

    public static TableModel getUserAchievementsList(int userId) throws SQLException {
        return new business.implementation.UserManagement().getUserAchievementsList(userId);
    }

    public static boolean setToModerator(String username) throws SQLException {
        return new business.implementation.UserManagement().setToModerator(username);
    }

    public static boolean setToUser(String username) throws SQLException {
        return new business.implementation.UserManagement().setToUser(username);
    }

    public static boolean setToAdministrator(String username) throws SQLException {
        return new business.implementation.UserManagement().setToAdministrator(username);
    }

    public static TableModel getGameNameByID(int gameId) throws SQLException {
        return new business.implementation.UserManagement().getGameNameByID(gameId);
    }

    public static String getUserType(int user_id) throws SQLException {
        return new business.implementation.UserManagement().getUserType(user_id);
    }

    public static boolean updatePassword(int userID, String password) throws SQLException {
        return new business.implementation.UserManagement().updatePassword(userID, password);
    }

    public static boolean setImg (int userID, File imgfile) {
        return new business.implementation.UserManagement().setImg(userID, imgfile);
    }

    public static boolean getImg(int userID, String filePathName) {
        return new business.implementation.UserManagement().getImg(userID, filePathName);
    }

    public static boolean checkImage(int userID) throws SQLException {
        return new business.implementation.UserManagement().checkImage(userID);
    }

    public static int getUserID(String user) throws SQLException {
        return new business.implementation.UserManagement().getUserID(user);
    }

    public static String getUserTipo(String user) throws SQLException {
        return new business.implementation.UserManagement().getUserTipo(user);
    }

    public static String getUsername(int user_id) throws SQLException {
        return new business.implementation.UserManagement().getUsername(user_id);
    }

    public static String getGameFromId(int game_id) throws SQLException {
        return new business.implementation.UserManagement().getGameFromId(game_id);
    }

    public static boolean userAuth(String username, String password) throws SQLException {
        return new business.implementation.UserManagement().userAuth(username, password);
    }

    public static ArrayList<String> getGame() throws SQLException {
        return new business.implementation.UserManagement().getGame();
    }

    public static TableModel getUsers() throws SQLException {
        return new business.implementation.UserManagement().getUsers();
    }

    public static int getGameIDFromName(String gameName) throws SQLException {
        return new business.implementation.ReviewManagement().getGameIDFromName(gameName);
    }

    public static TableModel getReviewsByID(int gameID) throws SQLException {
        return new business.implementation.ReviewManagement().getReviewsByID(gameID);
    }

    /* Change the current JFrame page */
    public static void changePage(String page, Utente utente) {
        switch (page) {
            case "startPage":
                new presentation.startPage();
                break;

            case "registration":
                new presentation.registration();
                break;

            case "logged":
                new presentation.logged(utente);
                break;

            case "profile":
                new presentation.profile(utente);
                break;

            case "editData":
                new presentation.editData(utente);
                break;

            case "evalutateReview":
                new presentation.evalutateReview(utente, 0);
                break;

            case "achievementsList":
                new presentation.achievementsList(utente, 0);
                break;

            case "allGames":
                new presentation.allGames(utente, 0);
                break;

            case "reviewList":
                new presentation.reviewList(utente, 0, 0);
                break;

            case "viewRievew":
                new presentation.viewReview(utente, 0, 0, 0);
                break;

            case "review":
                new presentation.review(utente, 0);
                break;

            case "timelineView":
                new presentation.timelineView(utente);
                break;

            case "userList":
                new presentation.usersList(utente, 0);
                break;

            case "approveComment":
                new presentation.approveComment(utente, null);
                break;

            case "Snake":
                new presentation.snake.view.startSnake(utente);
                break;

            case "SlotMachineGUI":
                try {
                    if (eventsListener.getGameProfile(utente.getUserId()).getEsperienza() < 15) {
                        JOptionPane.showMessageDialog(null, "Aggiunti 100 crediti");
                        new presentation.SlotMachineGUI(utente, eventsListener.getGameProfile(utente.getUserId()).getEsperienza() + 100, 100, 15, 25, 5, 7, 7, 7);
                    } else {
                        new presentation.SlotMachineGUI(utente, eventsListener.getGameProfile(utente.getUserId()).getEsperienza(), 100, 15, 25, 5, 7, 7, 7);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}