package business.implementation;

import business.implementation.Interfaces.ReviewInterface;
import business.model.Review;
import business.model.Utente;
import net.proteanit.sql.DbUtils;

import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewManagement implements ReviewInterface {

    /* Adds a new review */
    public boolean newReview(Utente utente, String text, int giocoId, double vote, boolean approved) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();
        String insertTableSQL = null;

        if (!approved) {
            insertTableSQL = "INSERT INTO recensione" + "(user_id, testo_recensione, voto, gioco_id, approvata) VALUES" +
                    "(?, ?, ?, ?, false)";
        } else {
            insertTableSQL = "INSERT INTO recensione" + "(user_id, testo_recensione, voto, gioco_id, approvata) VALUES" +
                    "(?, ?, ?, ?, true)";
        }
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, utente.getUserId());
            preparedStatement.setString(2, text);
            preparedStatement.setDouble(3, vote);
            preparedStatement.setInt(4, giocoId);

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

    /* Get a review from a user id and game review*/
    public Review getReview(int user_id, int game_id) throws SQLException {

        int reviewId = 0;
        double vote = 0;
        boolean approvata = false;
        String text = "";
        int game_text = 0;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT *\n" +
                "FROM recensione\n" +
                "INNER JOIN gioco ON recensione.gioco_id = gioco.gioco_id\n" +
                "WHERE recensione.user_id = ? AND recensione.gioco_id = ?");

        stmt.setInt(1, user_id);
        stmt.setInt(2, game_id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            reviewId = rs.getInt("recensione_id");
            text = rs.getString("testo_recensione");
            game_text = rs.getInt("gioco_id");
            vote = rs.getDouble("voto");
            approvata = rs.getBoolean("approvata");

        }
        dbConnection.close();
        return new Review(reviewId, user_id, text, vote, approvata, game_text);
    }

    /* Get pending reviews */
    public TableModel getPendingReviews() throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT user_id, \n" +
                        "       testo_recensione, \n" +
                        "       voto, \n" +
                        "       gioco_id \n" +
                        "FROM   recensione \n" +
                        "WHERE  approvata = '0'");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }

    /* Get approved reviews */
    public TableModel getApprovedReviews() throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT user_id, \n" +
                        "       testo_recensione, \n" +
                        "       voto, \n" +
                        "       gioco_id \n" +
                        "FROM   recensione \n" +
                        "WHERE  approvata = '1'");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }

    /* Get every review in the db */
    public TableModel getAllReviews() throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT user_id, \n" +
                        "       testo_recensione, \n" +
                        "       voto, \n" +
                        "       gioco_id \n" +
                        "FROM   recensione \n"
        );

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }

    /* Approve a review */
    public boolean approveReview(Review review) throws SQLException {

        Connection dbConnection = business.implementation.DBManager.Connect();
        String approveReview = "UPDATE `recensione` SET `approvata` = '1' WHERE `recensione`.`recensione_id`= ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setInt(1, review.getReviewId());

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

    /* Delete a review */
    public boolean deleteReview(Review review) throws SQLException {

        Connection dbConnection = business.implementation.DBManager.Connect();

        String approveReview = "DELETE FROM `recensione` WHERE `recensione`.`recensione_id` = ?";
        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(approveReview);

            preparedStatement.setInt(1, review.getReviewId());

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

    /* Find a review on a profile */
    public boolean reviewFoundOnProfile(int user_id, int game_id) throws SQLException {

        for (int i = 0; i < new ReviewManagement().getAllReviews().getRowCount(); i++) {
            if (String.valueOf(new ReviewManagement().getAllReviews().getValueAt(i, 0)).equals(String.valueOf(user_id)) &&
                    (String.valueOf(new ReviewManagement().getAllReviews().getValueAt(i, 3)).equals(String.valueOf(game_id)))) {
                return true;
            }
        }
        return false;
    }

    /* Get a game id from name (used for reviews) */
    public int getGameIDFromName(String gameName) throws SQLException {

        int gameID = 0;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT gioco_id FROM gioco WHERE nome = ?");
        stmt.setString(1, gameName);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            gameID = rs.getInt("gioco_id");
        }
        dbConnection.close();

        return gameID;
    }

    /* Get the list of APPROVED reviews for a specific game */
    public TableModel getReviewsByID(int gameID) throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM `recensione` WHERE gioco_id = ? AND approvata = '1'");
        stmt.setInt(1, gameID);

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);
        dbConnection.close();

        return tm;
    }
}