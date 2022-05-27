/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import connex.Connex;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class DetailCommande extends BdTable{
    int id;
    int idCommande;
    int idPlat;
    int idServeur;
    int qte;
    
    public DetailCommande constructeur(ResultSet res)throws Exception
    {
        DetailCommande dc=new DetailCommande(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4),res.getInt(5));
        return dc;
    } 

    public DetailCommande(int id, int idCommande, int idPlat, int idServeur, int qte) {
        this.id = id;
        this.idCommande = idCommande;
        this.idPlat = idPlat;
        this.idServeur = idServeur;
        this.qte = qte;
    }

    

    public DetailCommande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public int getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(int idServeur) {
        this.idServeur = idServeur;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
    
    public void attribuerServeur(int id,int idServeur) throws Exception{
        Connex con = new Connex();
        String req = "update detailCommande set idServeur="+idServeur+" where id="+id;
        Connection c = con.getCon();
        java.sql.Statement stmt = c.createStatement();
        stmt.executeUpdate(req);
    }
}
