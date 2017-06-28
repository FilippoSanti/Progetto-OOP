package business.implementation.Interfaces;

import business.model.Timeline;

import java.sql.SQLException;

public interface TimelineManagementInterface {

    /* Update the timeline informations */
    boolean updateTimeline(int user_id, java.sql.Date dataUltima, int esperienzaGuadagnata, int gioco_id) throws SQLException;

    /* Check the timeline informations */
    Timeline getTimeline(int userId) throws SQLException;

}
