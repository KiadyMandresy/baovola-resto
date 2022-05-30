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
public class ResteIngredient extends BdTable{
    int idIngredient;
    double reste;

    public ResteIngredient constructeur(ResultSet res) throws SQLException{
        ResteIngredient cp = new ResteIngredient(res.getInt(1),res.getDouble(2));
        return cp;
    }
    
    public ResteIngredient(int idIngredient, double reste) {
        this.idIngredient = idIngredient;
        this.reste = reste;
    }

    public ResteIngredient() {
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public double getReste() {
        return reste;
    }
    
    
    public double resteIngredient(int idIngredient) throws Exception{
        double rep = 0;
        Connex con = new Connex();
        String req = "select * from resteIngredient where idingredient="+idIngredient;
        Vector liste = this.findReq(req, this, con.getCon());
        rep = ((ResteIngredient)liste.get(0)).getReste();
        con.deco();
        return rep;
    }
    
    public Vector all() throws Exception{
        Connex con = new Connex();
        Vector liste = this.find(this,con.getCon());
        con.deco();
        return liste;
    }
}
