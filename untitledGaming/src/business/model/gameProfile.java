package business.model;

/**
 * Created by Davide on 04/06/2017.
 */
public class gameProfile {

    int gameProfileId;
    int userId;
    int livello;
    int esperienza;



    public gameProfile(int gameProfileId, int userId, int livello, int esperienza)
    {
        this.gameProfileId = gameProfileId;
        this.userId = userId;
        this.livello = livello;
        this.esperienza = esperienza;
    }

    public int getEsperienza() {
        return esperienza;
    }
     public int getGameProfileId() {
         return gameProfileId;
     }

    public int getLivello() {
        return livello;
    }

    public int getUserId() {
        return userId;
    }

    public void setEsperienza(int esperienza) {
        this.esperienza = esperienza;
    }

    public void setGameProfileId(int gameProfileId) {
        this.gameProfileId = gameProfileId;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
