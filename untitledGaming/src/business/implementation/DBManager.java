package business.implementation;

import business.BusinessException;
import business.implementation.Utils.BCrypt;

import java.sql.*;

public class DBManager {

    /* DB Connection */
    public static Connection Connect() {

        // DB Config
        String dbAddress = "jdbc:mysql://localhost:3306/untitled_gaming";
        String dbUser = "root";
        String dbPassword = "";
        Connection dbConnection = null;

        // Check if JDBC driver exists
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return dbConnection;
        }

        // Connects to the DB
        try {
            dbConnection = DriverManager
                    .getConnection(dbAddress, dbUser, dbPassword);

        } catch (SQLException e) {
            throw new BusinessException("Can't connect to the db server");
        }
        return dbConnection;
    }

    /**
     * This method can be used to generate a string representing an account password
     * suitable for storing in a database. It will be an OpenBSD-style crypt(3) formatted
     * hash string of length=60
     * The bcrypt workload is specified in the above static variable, a value from 10 to 31.
     * A workload of 12 is a very reasonable safe default as of 2013.
     * This automatically handles secure 128-bit salt generation and storage within the hash.
     *
     * @param password_plaintext The account's plaintext password as provided during account creation,
     *                           or when changing an account's password.
     * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
     */
    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(12);
        String hashed_password = business.implementation.Utils.BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

    /**
     * This method can be used to verify a computed hash from a plaintext (e.g. during a login
     * request) with that of a stored hash from a database. The password hash from the database
     * must be passed as the second variable.
     *
     * @param password_plaintext The account's plaintext password, as provided during a login request
     * @param stored_hash        The account's stored password hash, retrieved from the authorization database
     * @return boolean - true if the password matches the password of the stored hash, false otherwise
     */

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;

        if (null == stored_hash || !stored_hash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        password_verified = business.implementation.Utils.BCrypt.checkpw(password_plaintext, stored_hash);

        return (password_verified);
    }

    /* Check if the username exists */
    public static boolean checkUsername(String username) throws SQLException {

        // DB Connection
        Connection connection = Connect();

        // Prepare and execute the query
        PreparedStatement st = connection.prepareStatement("select * from utente where username = ?");
        st.setString(1, username);
        ResultSet rs = st.executeQuery();

        if (rs.next()) return true;
        return false;

    }

    /* Check if the email exists */
    public static boolean checkEmail(String email) throws SQLException {

        // DB Connection
        Connection connection = Connect();

        // Prepare and execute the query
        PreparedStatement st = connection.prepareStatement("select * from utente where email = ?");
        st.setString(1, email);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;
    }

    /* Check if the timeline of a user exists */
    public static boolean checkTimeline(int user_id) throws SQLException {

        // DB Connection
        Connection connection = Connect();

        // Prepare and execute the query
        PreparedStatement st = connection.prepareStatement("select * from timeline where user_id = ?");
        st.setInt(1, user_id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            return true;
        }
        return false;
    }
}