package business.implementation.Interfaces;

import business.model.Review;
import business.model.Utente;

import javax.swing.table.TableModel;
import java.sql.SQLException;

public interface ReviewInterface {

    /* Adds a new review */
    boolean newReview(Utente utente, String text, int giocoId, double vote, boolean approved) throws SQLException;

    /* Get a review from a user id and game review*/
    Review getReview(int user_id, int game_id) throws SQLException;

    /* Get pending reviews */
    TableModel getPendingReviews() throws SQLException;

    /* Get approved reviews */
    TableModel getApprovedReviews() throws SQLException;

    /* Get every review in the db */
    TableModel getAllReviews() throws SQLException;

    /* Approve a review */
    boolean approveReview(Review review) throws SQLException;

    /* Delete a review */
    boolean deleteReview(Review review) throws SQLException;

    /* Find a review on a profile */
    boolean reviewFoundOnProfile(int user_id, int game_id) throws SQLException;

    /* Get a game id from name (used for reviews) */
    int getGameIDFromName(String gameName) throws SQLException;

    /* Get the list of APPROVED reviews for a specific game */
    TableModel getReviewsByID(int gameID) throws SQLException;

}
