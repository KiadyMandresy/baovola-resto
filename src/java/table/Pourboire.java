/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import connex.Connex;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Dawood
 */
public class Pourboire extends BdTable{
    String nom;
    double pourboire;
    
    public Pourboire constructeur(ResultSet res)throws Exception
    {
        Pourboire vp=new Pourboire(res.getString(1),res.getDouble(2));
        return vp;
    }

    public Pourboire(String nom, double pourboire) {
        this.nom = nom;
        this.pourboire = pourboire;
    }

    public Pourboire() {
    }

    public String getNom() {
        return nom;
    }

    public double getPourboire() {
        return pourboire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPourboire(double pourboire) {
        this.pourboire = pourboire;
    }
    
    public Vector pourboire(String d1, String d2) throws Exception{
        Vector liste = new Vector();
        Connex con = new Connex();
        String req = "select  serveur, sum(prixtotal * margeServeur) as pourboire from pourboireCommande where date>='"+d1+"' and date<'"+d2+"' group by idserveur,serveur;";
        liste = this.findReq(req, this, con.getCon());
        con.deco();
        return liste;
    }
    
}
