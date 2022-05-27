/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import connex.Connex;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class VuePayement extends BdTable{
    String numeroTable;
    String typePayement;
    double montant;
    Timestamp daty;
    
    public VuePayement constructeur(ResultSet res)throws Exception
    {
        VuePayement vp=new VuePayement(res.getString(1),res.getString(2),res.getDouble(3),res.getTimestamp(4));
        return vp;
    }

    public VuePayement(String numeroTable, String typePayement, double montant, Timestamp daty) {
        this.numeroTable = numeroTable;
        this.typePayement = typePayement;
        this.montant = montant;
        this.daty = daty;
    }

    public VuePayement() {
    }

    public String getNumeroTable() {
        return numeroTable;
    }

    public void setNumeroTable(String numeroTable) {
        this.numeroTable = numeroTable;
    }

    public String getTypePayement() {
        return typePayement;
    }

    public void setTypePayement(String typePayement) {
        this.typePayement = typePayement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Timestamp getDaty() {
        return daty;
    }

    public void setDaty(Timestamp daty) {
        this.daty = daty;
    }
    
    public  Vector getListPayement(String date1 , String date2) throws Exception{
        VuePayement vp = new VuePayement();
        Connex con = new Connex();
        String req = "select * from vuePayement where date>='"+date1+"' and date<='"+date2+"'";
        Vector val = this.findReq(req, vp, con.getCon());
        return val;
    }
    public double total(Vector liste){
        double rep =0;
        for(int i=0; i<liste.size(); i++){
            rep += ((VuePayement)liste.get(i)).getMontant();
        }
        return rep;
    }
}
