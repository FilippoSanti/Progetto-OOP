package model;

import java.sql.ResultSet;
import java.sql.SQLException;

class User {

    private int tipo;
    private String nome;
    private String cognome;
    private String email;
    private String username;


    public User(ResultSet rs) throws SQLException {

        // TODO Get the user value from a list (not a ResultSet)
        this.tipo     = rs.getInt("tipo");
        this.nome     = rs.getString("nome");
        this.cognome  = rs.getString("cognome");
        this.email    = rs.getString("email");
        this.username = rs.getString ("username");
    }

    public User(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
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


}
