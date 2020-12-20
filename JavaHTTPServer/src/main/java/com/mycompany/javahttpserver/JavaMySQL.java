package com.mycompany.javahttpserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaMySQL {
    private ArrayList<Persona> ListaUtenti = new ArrayList();
  
    
    public void connessione()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/estpsit?user=root&password=YashAnmol.33&serverTimezone=Europe/Rome");
        Statement d = c.createStatement();
        ResultSet f = d.executeQuery("SELECT * FROM Utenti");
        while (f.next())
        {
           String Nome = f.getString("Nome");
           String Cognome = f.getString("Cognome");
           Persona p = new Persona(Nome, Cognome);
           ListaUtenti.add(p);
        }
        }catch(ClassNotFoundException ex)
        {
            ex.toString();
        } catch (SQLException ex) {
            ex.toString();
        }
    }

    public ArrayList<Persona> getListaUtenti() {
        return ListaUtenti;
    }

    public JavaMySQL() {
        connessione();
    }
    
}
