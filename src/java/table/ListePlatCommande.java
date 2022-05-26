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
 * @author ravonirinafitahianarandriamanantena
 */
public class ListePlatCommande extends BdTable{
    String designation;
    Timestamp date;
    int id;
    int quantite;

    public ListePlatCommande constructeur(ResultSet res) throws SQLException{
        ListePlatCommande lpc = new ListePlatCommande(res.getString(1),res.getTimestamp(2),res.getInt(3),res.getInt(4));
        return lpc;
    }

    public ListePlatCommande(String designation, Timestamp date, int id, int quantite) {
        this.designation = designation;
        this.date = date;
        this.id = id;
        this.quantite = quantite;
    }

    public ListePlatCommande() {
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public Vector getListePlatCommande() throws Exception{
        ListePlatCommande lpc = new ListePlatCommande();
        Connex con = new Connex();
        String req = "select * from listePlatCommande";
        Vector val = this.findReq(req, lpc, con.getCon());
        return val;
    }
    
    public Vector getListePlatCommandeById(int id) throws Exception{
        ListePlatCommande lpc = new ListePlatCommande();
        Connex con = new Connex();
        String req = "select * from listePlatCommande where id="+id;
        Vector val = this.findReq(req, lpc, con.getCon());
        return val;
    }
    
}
