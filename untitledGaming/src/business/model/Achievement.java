package business.model;

public class Achievement {
    int achievement_id, gioco_id;
    String nome, descrizione;

    public Achievement(int achievement_id, String nome, String descrizione, int gioco_id) {

        this.achievement_id = achievement_id;
        this.descrizione = descrizione;
        this.gioco_id = gioco_id;
        this.nome = nome;
    }

    public void setGioco_id(int gioco_id) {
        this.gioco_id = gioco_id;
    }

    public int getGioco_id() {
        return gioco_id;
    }

    public int getAchievement_id() {
        return achievement_id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getNome() {
        return nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}