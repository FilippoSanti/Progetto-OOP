package business.model;


import java.sql.Date;

/**
 * Created by Davide on 04/06/2017.
 */
public class Utente {

    String username;
    String nome;
    String cognome;
    int userId;
    String password;
    String email;
    String tipo;
    Date data;


    public Utente ()
    {
        this.username = "";
        this.nome = "";
        this.cognome = "";
        this.userId = 0;
        this.password = "";
        this.email = "";
        this.tipo = "";
        this.data = null;
    }


    public Utente (int userId, String username, String nome, String cognome, String password, String email, String tipo, Date data)
    {

        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.tipo = tipo;
        this.data = data;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public int getUserId() {return userId; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getData() {
        return data;
    }




}
