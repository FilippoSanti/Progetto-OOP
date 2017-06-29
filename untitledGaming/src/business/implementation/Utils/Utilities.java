package business.implementation.Utils;

import business.BusinessException;
import business.implementation.UserManagement;
import business.model.Utente;
import games.SlotMachine.SlotMachineGUI;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

public class Utilities {

    /* Convert a string to a java.sql.date format */
    public static java.sql.Date stringToDate(String dateString) throws ParseException {

        // Date format
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = formatter.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        return sqlDate;
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
    public static String dateToString(java.sql.Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String text = df.format(date);

        return text;
    }

    /* Resize an image */
    public static BufferedImage resizeImg(BufferedImage originalImage, int type, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, width, null);
        g.dispose();

        return resizedImage;
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
                new games.snake.view.startSnake(utente);
                break;

            case "SlotMachineGUI":
                try {
                    if (new UserManagement().getGameProfile(utente.getUserId()).getEsperienza() < 15) {
                        JOptionPane.showMessageDialog(null, "Aggiunti 100 crediti");
                        new SlotMachineGUI(utente, new UserManagement().getGameProfile(utente.getUserId()).getEsperienza() + 100, 100, 15, 25, 5, 7, 7, 7);
                    } else {
                        new SlotMachineGUI(utente, new UserManagement().getGameProfile(utente.getUserId()).getEsperienza(), 100, 15, 25, 5, 7, 7, 7);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}