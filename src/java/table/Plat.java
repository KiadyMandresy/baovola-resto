/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mac
 */
public class Plat extends BdTable{
    int id ;
    String designation ;
    double prix ;
    int idCategorie ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Plat(int id, String designation, double prix, int idCategorie) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.idCategorie = idCategorie;
    }

    public Plat() {
    }
    
    public Plat constructeur(ResultSet res) throws SQLException{
        Plat p = new Plat(res.getInt(1),res.getString(2),res.getDouble(3),res.getInt(4));
        return p;
    }
}
