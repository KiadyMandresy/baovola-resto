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
 * @author Dawood
 */
public class DetailPlat extends BdTable {
    int id;
    int idPlat;
    int idIngredient;
    int qte;
    String unite;
    
    public DetailPlat constructeur(ResultSet res) throws SQLException{
        DetailPlat cp = new DetailPlat(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getString(5));
        return cp;
    }
    
    public DetailPlat(int id, int idPlat, int idIngredient, int qte, String unite) {
        this.id = id;
        this.idPlat = idPlat;
        this.idIngredient = idIngredient;
        this.qte = qte;
        this.unite = unite;
    }

    public DetailPlat() {
    }

    public int getId() {
        return id;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public int getIdIngredient() {
        return idIngredient;
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

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    
}
