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
public class Serveur extends BdTable {
    int id;
    String nom;
    double marge;
    int idUtilisateur;

    public int getIdUtilisateur() {
        return idUtilisateur;
    }
    
    public Serveur(){
        
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Serveur constructeur(ResultSet res)throws Exception
    {
        Serveur vp=new Serveur(res.getInt(1),res.getString(2), res.getDouble(3),res.getInt(4));
        return vp;
    }
    
    public Serveur(int id, String nom, double marge,int idUtilisateur) {
        this.id = id;
        this.nom = nom;
        this.marge = marge;
        this.idUtilisateur=idUtilisateur;
    }

    public void setMarge(double marge) {
        this.marge = marge;
    }

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getMarge() {
        return marge;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
  
    public Serveur getServeur(int idUtil) throws Exception{
        Serveur lat = new Serveur();
        Connex con = new Connex();
        String req = "select * from serveur where idUtilisateur="+idUtil;
        Vector li = this.findReq(req, lat, con.getCon());
        lat.setId( ((Serveur)li.get(0)).getId() );
        lat.setNom( ((Serveur)li.get(0)).getNom() );
        lat.setMarge( ((Serveur)li.get(0)).getMarge() );
        lat.setIdUtilisateur( ((Serveur)li.get(0)).getIdUtilisateur() );
        con.deco();
        return lat;
    }
    
}
