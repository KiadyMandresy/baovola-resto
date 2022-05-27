/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;

/**
 *
 * @author Dawood
 */
public class DetailPayement extends BdTable {
    int id;
    int idPayement;
    int idTypePayement;
    double montant;

    public DetailPayement constructeur(ResultSet res)throws Exception
    {
        DetailPayement vp=new DetailPayement(res.getInt(1),res.getInt(2),res.getInt(3), res.getDouble(4));
        return vp;
    }

    public DetailPayement(int id, int idPayement, int idTypePayement, double montant) {
        this.id = id;
        this.idPayement = idPayement;
        this.idTypePayement = idTypePayement;
        this.montant = montant;
    }

    public DetailPayement() {
    }

    public int getId() {
        return id;
    }

    public int getIdPayement() {
        return idPayement;
    }

    public int getIdTypePayement() {
        return idTypePayement;
    }

    public double getMontant() {
        return montant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdPayement(int idPayement) {
        this.idPayement = idPayement;
    }

    public void setIdTypePayement(int idTypePayement) {
        this.idTypePayement = idTypePayement;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
}
