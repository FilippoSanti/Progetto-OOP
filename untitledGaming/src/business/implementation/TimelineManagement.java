package business.implementation;

import business.implementation.Interfaces.TimelineManagementInterface;
import business.model.Timeline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimelineManagement implements TimelineManagementInterface {

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

            DataFinale = business.implementation.Utils.Utilities.stringToDate(textDate);

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

}
