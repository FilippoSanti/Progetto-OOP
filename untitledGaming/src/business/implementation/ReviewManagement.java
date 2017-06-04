package business.implementation;


import business.model.*;
import net.proteanit.sql.DbUtils;

import javax.swing.table.TableModel;
import java.sql.*;

/**
 * Created by Davide on 04/06/2017.
 */
public class ReviewManagement {


    public  boolean newReview (Utente utente, String text, double vote) throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();



        String insertTableSQL = "INSERT INTO recensioni"+"(user_id, testo_recensione, voto, approvata) VALUES" +
                "(?, ?, ?, false)";

        PreparedStatement preparedStatement = null;

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, utente.getUserId());
            preparedStatement.setString(2, text);
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

    public  Review getReview (int user_id) throws SQLException {
        int reviewId = 0;
        String text = "";
        double vote = 0;
        boolean approvata = false;

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();


        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT * \n" +
                        "FROM   `recensione` \n" +
                        "WHERE  user_id = ? ");
        stmt.setInt(1, user_id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            reviewId = rs.getInt("recensione_id");
            text = rs.getString("testo_recensione");
            vote = rs.getDouble("voto");
            approvata = rs.getBoolean("approvata");

        }

        return new Review(reviewId, user_id, text, vote, approvata);



    }

    public TableModel getPendingReviews() throws SQLException{



        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();


        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT user_id, \n" +
                        "       testo_recensione, \n" +
                        "       voto \n" +
                        "FROM   recensione \n" +
                        "WHERE  approvata = '0'");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);

        return tm;


        }

    public TableModel getApprovedReviews () throws SQLException {

        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();


        // Execute the query and get the ResultSet
        PreparedStatement stmt = dbConnection.prepareStatement(
                "SELECT user_id, \n" +
                        "       testo_recensione, \n" +
                        "       voto \n" +
                        "FROM   recensione \n" +
                        "WHERE  approvata = '1'");

        ResultSet rs = stmt.executeQuery();
        TableModel tm = DbUtils.resultSetToTableModel(rs);

        return tm;

    }

    public boolean approveReview (Review review) throws SQLException {

        Connection dbConnection = business.implementation.DBManager.Connect();

        String approveReview = "UPDATE `recensione` SET `approvata` = '1' WHERE `recensione`.`recensione_id` = ?";
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




    }



