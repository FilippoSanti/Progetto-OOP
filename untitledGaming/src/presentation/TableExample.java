package presentation;

import business.implementation.ReviewManagement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.sql.SQLException;

public class TableExample extends JFrame {
    public TableExample() throws SQLException {

        JTable table = new JTable(new ReviewManagement().getPendingReviews());

        //Add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TableExample();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}