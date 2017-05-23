package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class eventsListener {

    /* Insert the user data into the DB */
    public static boolean insertUser(Connection dbConnection, String user, String password, String nome, String cognome, String email, String tipo) throws SQLException {

        PreparedStatement preparedStatement = null;

        // Password hashing
        String hashedPass = business.implementation.DBManager.hashPassword(password);

        String insertTableSQL = "INSERT INTO utente"
                + "(username, password, nome, cognome, email, tipo) VALUES"
                + "(?,?,?,?,?,?)";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, hashedPass);
            preparedStatement.setString(3, nome);
            preparedStatement.setString(4, cognome);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, tipo);

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

    /* User authentication */
    public static boolean userAuth(Connection conn, String username, String password) {
        try {
            PreparedStatement pst = conn.prepareStatement("Select * from utente where username=?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String hashedPass = rs.getString("password");

                //Check if the provided password and the hashed one are equals
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

}
