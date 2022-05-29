/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import connex.Connex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Dawood
 */
public class StockIngredient extends BdTable{
    int id;
    int idIngredient;
    double entree;
    double sortie;
    Timestamp date;

    public StockIngredient constructeur(ResultSet res) throws SQLException{
        StockIngredient cp = new StockIngredient(res.getInt(1),res.getInt(2),res.getDouble(3),res.getDouble(4),res.getTimestamp(5));
        return cp;
    }
    
    public StockIngredient(int id, int idIngredient, double entree, double sortie, Timestamp date) {
        this.id = id;
        this.idIngredient = idIngredient;
        this.entree = entree;
        this.sortie = sortie;
        this.date = date;
    }

    public StockIngredient() {
    }

    
    
    public int getId() {
        return id;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public double getEntree() {
        return entree;
    }

    public double getSortie() {
        return sortie;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public void setEntree(double entree) {
        this.entree = entree;
    }

    public void setSortie(double sortie) {
        this.sortie = sortie;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    public void entree(int ingredient, double qte) throws Exception{
        StockIngredient si = new StockIngredient();
        Connex con = new Connex();
        si.setSortie(0);
        si.setEntree(qte);
        si.setIdIngredient(ingredient);
        si.insertInto(con.getCon());
        con.deco();
    }
    
    public void sortie(int id, double qte) throws Exception{
        StockIngredient si = new StockIngredient();
        Connex con  = new Connex();
        si.setSortie(qte);
        si.setEntree(0);
        si.setIdIngredient(id);
        si.insertInto(con.getCon());
        con.deco();
    }
    
}
