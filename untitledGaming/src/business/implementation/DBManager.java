package business.implementation;

import business.BusinessException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

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
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

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

        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

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

    public static String getUserType(int user_id) throws SQLException {

        String userType = null;

        // DB Connection
        Connection connection = Connect();

        // Prepare and execute the query
        PreparedStatement st = connection.prepareStatement("select tipo from utente where user_id = ?");
        st.setInt(1, user_id);
        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            userType = rs.getString("tipo");
        }

        return userType;
    }

    public static boolean updatePassword(int userID, String password) throws SQLException {
        // DB Connection
        Connection dbConnection = business.implementation.DBManager.Connect();

        // Password hashing
        password = hashPassword(password);

        // Declare the statement
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "UPDATE utente SET utente.password = ? WHERE user_id = ?";

        // Insert the values into the DB
        try {
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, userID);

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

    public static boolean setImg (int userID, File imgfile) {
        try {

            // Open the connection
            Connection con  = business.implementation.DBManager.Connect();
            Statement  st   = con.createStatement();

            FileInputStream fin  = new FileInputStream(imgfile);

            // Prepare the query
            PreparedStatement pre =
                    con.prepareStatement("UPDATE utente\n" +
                            "SET immagine_profilo = ?\n" +
                            "WHERE utente.user_id = ?");

            pre.setInt   (2,userID);

            // Store the image into the db
            pre.setBinaryStream(1,(InputStream)fin,(int)imgfile.length());
            pre.executeUpdate();
            System.out.println("Successfully inserted the file into the database!");

            // Close the connection
            pre.close();
            con.close();

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean getImg(int userID, String filePathName) {
        try {

            File selectedfile;
            // Open the connection
            Connection con = DBManager.Connect();

            // Execute the query and get the ResultSet
            PreparedStatement stmt = con.prepareStatement(
                    "SELECT `immagine_profilo` FROM `utente` WHERE user_id = ?");

            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            int i = 0;
            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File(filePathName));
                i++;
                int c = 0;
                while ((c = in.read()) > -1) {
                    f.write(c);
                }
                f.close();
                in.close();

                return true;
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /* Convert a string to a java.sql.date format */
    public static java.sql.Date stringToDate(String dateString) throws ParseException {

        // Date format
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = formatter.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
    }

    /* Check if the profile pic of an user exists (true) */
    public static boolean checkImage(int userID) throws SQLException {

        // DB Connection
        Connection connection = Connect();

        int resultInt = 0;

        // Prepare and execute the query
        PreparedStatement st = null;

        st = connection.prepareStatement("select immagine_profilo from utente WHERE user_id = ?");

        st.setInt(1, userID);
        ResultSet rs = st.executeQuery();

        try {
        if (rs.next()) {
            resultInt = rs.getInt("immagine_profilo");
        }

        } catch (SQLException e) {
            return true;
        }

        if (resultInt == 0) return false;
        return true;
    }

    /* Reformat a text date */
    public static String formatSqlDateString(String dataSql) {

        String newData = "";
        String yearDate = dataSql.substring(0, 4);

        String monthDate = dataSql.substring(5, 7);
        String dayDate = dataSql.substring(8, 10);
        newData = dayDate + "-" + monthDate + "-" + yearDate;

        return newData;
    }

    /* Check if the email id valid using a regex */
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    /* Get the current date */
    public static java.sql.Date getCurrentData() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calobj = Calendar.getInstance();

        java.sql.Date sqlDate = new java.sql.Date(calobj.getTime().getTime());
        return sqlDate;
    }

    /* Convert a date into a string */
    public static String dateToString(java.sql.Date date ) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String text = df.format(date);

        return text;
    }

    /**
     * Scale an image
     *
     * @param imageString image to scale
     * @param imageType type of image
     * @param dWidth width of destination image
     * @param dHeight height of destination image
     * @param fWidth x-factor for transformation / scaling
     * @param fHeight y-factor for transformation / scaling
     * @return scaled image
     */
    public static BufferedImage scaleImage(String imageString, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {

        BufferedImage img = null;
        BufferedImage dbi = null;

        try {
            img = ImageIO.read(new File(imageString));
        } catch (IOException e) {
        }

        if(img != null) {
            dbi = new BufferedImage(dWidth, dHeight, imageType);
            Graphics2D g = dbi.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
            g.drawRenderedImage(img, at);
        }
        return dbi;
    }

    /* Returns the format of an image if successful, null otherwise*/
    public static String getImageType(File file) throws IOException {
        String imageType = null;

        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);

        // Read the image type
        while (imageReaders.hasNext()) {
            ImageReader reader = (ImageReader) imageReaders.next();
            imageType = reader.getFormatName();
        }

        if (imageType == null) {
            throw new BusinessException("Errore durante la lettura del file");
        }
        return imageType;
    }

    /* Delete an image after it's been downloaded */
    public static boolean deleteFilesForPathByPrefix(final String path, final String prefix) {
        boolean success = true;
        try (DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(Paths.get(path), prefix + "*")) {
            for (final Path newDirectoryStreamItem : newDirectoryStream) {
                Files.delete(newDirectoryStreamItem);
            }
        } catch (final Exception e) {
            success = false;
            e.printStackTrace();
        }
        return success;
    }
}