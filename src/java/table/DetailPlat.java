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
public class DetailPlat extends BdTable {
    int id;
    int idPlat;
    int idIngredient;
    double qte;
    String unite;
    
    public DetailPlat constructeur(ResultSet res) throws SQLException{
        DetailPlat cp = new DetailPlat(res.getInt(1),res.getInt(2),res.getInt(3),res.getDouble(4),res.getString(5));
        return cp;
    }
    
    public DetailPlat(int id, int idPlat, int idIngredient, double qte, String unite) {
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

    public double getQte() {
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

    public void setQte(double qte) {
        this.qte = qte;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    public Vector getDetailPlatByPlat(int idplat) throws Exception{
        Vector liste = new Vector();
        Connex con = new Connex();
        String req = "select * from detailPlat where idPlat="+idplat;
        liste = this.findReq(req, this, con.getCon());
        con.deco();
        return liste;
    }
    
    public void insertDetailPlat(int idplat, int idIngredient, double qte, String unite ) throws Exception{
        DetailPlat dp = new DetailPlat();
        Connex con =new Connex();
        dp.setIdPlat(idplat);
        dp.setIdIngredient(idIngredient);
        dp.setQte(qte);
        dp.setUnite(unite);
        dp.insertInto(con.getCon());
        con.deco();
    }
    public void supprimerDetailPlat(int id) throws Exception{
        DetailPlat dp = new DetailPlat();
        Connex con = new Connex();
        dp.setId(id);
        dp.deleteInto(con.getCon());
        con.deco();
    }
}
