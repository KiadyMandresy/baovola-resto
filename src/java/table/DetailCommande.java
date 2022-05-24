/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class DetailCommande extends BdTable{
    int id;
    int idCommande;
    int idPlat;
    int qte;
    
    public DetailCommande constructeur(ResultSet res)throws Exception
    {
        DetailCommande dc=new DetailCommande(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4));
        return dc;
    } 


    public DetailCommande(int id, int idCommande, int idPlat, int qte) {
        this.id = id;
        this.idCommande = idCommande;
        this.idPlat = idPlat;
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

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
