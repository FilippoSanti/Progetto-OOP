package presentation.general;

/**
 * Created by Davide on 04/06/2017.
 */

import controller.eventsListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.sql.SQLException;

public class TableExample extends JFrame {
    public TableExample() throws SQLException {

        //CLASSE DI ESEMPIO PER VISUALIZZARE I TABLEMODEL

        //inserire tablemodel qui
        JTable table = new JTable(eventsListener.getUserAchievementsList(33));
        System.out.println(table.getValueAt(0,1));
        //add the table to the frame
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