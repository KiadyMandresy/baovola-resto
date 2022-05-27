/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import connex.Connex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Dawood
 */
public class Ingredient extends BdTable{
    int id;
    String nom;
    double prix;
    int qte;
    String unite;
    
    public Ingredient constructeur(ResultSet res) throws SQLException{
        Ingredient cp = new Ingredient(res.getInt(1),res.getString(2),res.getDouble(3),res.getInt(4),res.getString(5));
        return cp;
    }

    public Ingredient(int id, String nom, double prix, int qte, String unite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.qte = qte;
        this.unite = unite;
    }

    public Ingredient() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQte() {
        return qte;
    }

    public String getUnite() {
        return unite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    
}
