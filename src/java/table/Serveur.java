/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;

/**
 *
 * @author Dawood
 */
public class Serveur extends BdTable {
    int id;
    String nom;

    public Serveur constructeur(ResultSet res)throws Exception
    {
        Serveur vp=new Serveur(res.getInt(1),res.getString(2));
        return vp;
    }
    
    public Serveur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Serveur() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
