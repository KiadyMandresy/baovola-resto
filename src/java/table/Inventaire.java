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
public class Inventaire extends BdTable {
    int id;
    int idIngredient;
    int qte;
    Timestamp date;

    public Inventaire constructeur(ResultSet res) throws SQLException{
        Inventaire cp = new Inventaire(res.getInt(1),res.getInt(2),res.getInt(3),res.getTimestamp(4));
        return cp;
    }

    public Inventaire(int id, int idIngredient, int qte, Timestamp date) {
        this.id = id;
        this.idIngredient = idIngredient;
        this.qte = qte;
        this.date = date;
    }

    public Inventaire() {
    }

    public int getId() {
        return id;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public double getQte() {
        return qte;
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

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
   
    public void insertInventaire(int idIngr, int qte) throws Exception{
        Connex con = new Connex();
        Inventaire inv = new Inventaire();
        inv.setQte(qte);
        inv.setIdIngredient(idIngr);
        inv.insertInto(con.getCon());
        con.deco();
    }
}
