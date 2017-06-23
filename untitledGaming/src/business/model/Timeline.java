package business.model;

import java.util.Date;

/**
 * Created by Davide on 07/06/2017.
 */
public class Timeline {

    int timeline_id;
    int user_id;
    int gioco_id;
    java.sql.Date data_ultima_sessione;
    int esperienza_guadagnata;

    public Timeline (int timeline_id, int user_id, int gioco_id, java.sql.Date data_ultima_sessione, int esperienza_guadagnata)
    {
        this.timeline_id = timeline_id;
        this.data_ultima_sessione = data_ultima_sessione;
        this.esperienza_guadagnata = esperienza_guadagnata;
        this.gioco_id = gioco_id;
        this.user_id = user_id;

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public java.sql.Date getData_ultima_sessione() {
        return data_ultima_sessione;
    }

    public int getEsperienza_guadagnata() {
        return esperienza_guadagnata;
    }

    public int getGioco_id() {
        return gioco_id;
    }

    public int getTimeline_id() {
        return timeline_id;
    }

    public void setData_ultima_sessione(java.sql.Date data_ultima_sessione) {
        this.data_ultima_sessione = data_ultima_sessione;
    }

    public void setEsperienza_guadagnata(int esperienza_guadagnata) {
        this.esperienza_guadagnata = esperienza_guadagnata;
    }

    public void setGioco_id(int gioco_id) {
        this.gioco_id = gioco_id;
    }
}