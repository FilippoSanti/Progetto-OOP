package presentation;

import business.implementation.DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class testClass {

    public static boolean storeImg () {
        try {

            // Open the connection
            Connection con       = business.implementation.DBManager.Connect();
            Statement  st        = con.createStatement();
            File       imgfile   = new File("pic.jpg");

            FileInputStream fin  = new FileInputStream(imgfile);

            // Prepare the query
            PreparedStatement pre =
                    con.prepareStatement("insert into Image values(?,?,?)");

            pre.setString(1,"test");
            pre.setInt   (2,3);

            // Store the image into the db
            pre.setBinaryStream(3,(InputStream)fin,(int)imgfile.length());
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

    public static boolean getImg() {
        try {

            // Open the connection
            Connection con = DBManager.Connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select image from image");

            int i = 0;
            while (rs.next()) {
                InputStream in = rs.getBinaryStream(1);
                OutputStream f = new FileOutputStream(new File("test"+i+".jpg"));
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

}
