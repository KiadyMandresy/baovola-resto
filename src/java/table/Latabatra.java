/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;

/**
 *
 * @author mac
 */
public class Latabatra extends BdTable{
    int id;
    String numero ;
    int isTaken;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getIsTaken() {
        return isTaken;
    }

    public void setIsTaken(int isTaken) {
        this.isTaken = isTaken;
    }

    public Latabatra() {
    }

    public Latabatra(int id, String numero, int isTaken) {
        this.id = id;
        this.numero = numero;
        this.isTaken = isTaken;
    }
    
    public Latabatra constructeur(ResultSet res)throws Exception{
        Latabatra lt = new Latabatra(res.getInt(1),res.getString(2),res.getInt(3));
        return lt;
    }
}
