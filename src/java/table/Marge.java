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
import java.util.Vector;

/**
 *
 * @author Dawood
 */
public class Marge extends BdTable {
    int id;
    double prixMin;
    double prixMax;
    double pourcentage;
    
    public Marge constructeur(ResultSet res)throws Exception
    {
        Marge j=new Marge(res.getInt(1),res.getDouble(2),res.getDouble(3),res.getDouble(4));
        return j;
    } 
    
    public Marge(int id, double prixMin, double prixMax, double pourcentage) {
        this.id = id;
        this.prixMin = prixMin;
        this.prixMax = prixMax;
        this.pourcentage = pourcentage;
    }

    public Marge() {
    }

    public int getId() {
        return id;
    }

    public double getPrixMin() {
        return prixMin;
    }

    public double getPrixMax() {
        return prixMax;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrixMin(double prixMin) {
        this.prixMin = prixMin;
    }

    public void setPrixMax(double prixMax) {
        this.prixMax = prixMax;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }
    
     public Vector getMarge() throws Exception{
        Connex con = new Connex();
        Vector liste = this.find(this, con.getCon());
        con.deco();
        return liste;
    }
}
