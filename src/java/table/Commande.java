/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class Commande extends BdTable{
    int id;
    Timestamp dateCom;
    int status;

     public Commande constructeur(ResultSet res)throws Exception
    {
        Commande c=new Commande(res.getInt(1),res.getTimestamp(2),res.getInt(3));
        return c;
    } 
   
    public Commande(int id, Timestamp dateCom, int status) {
        this.id = id;
        this.dateCom = dateCom;
        this.status = status;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateCom() {
        return dateCom;
    }

    public void setDateCom(Timestamp dateCom) {
        this.dateCom = dateCom;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    }
