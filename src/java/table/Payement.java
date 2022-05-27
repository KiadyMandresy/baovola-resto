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
 * @author Dawood
 */
public class Payement extends BdTable {
    int id;
    int idTable;
    Timestamp date;
    
    public Payement constructeur(ResultSet res)throws Exception
    {
        Payement vp=new Payement(res.getInt(1),res.getInt(2),res.getTimestamp(3));
        return vp;
    }

    public Payement(int id, int idTable, Timestamp date) {
        this.id = id;
        this.idTable = idTable;
        this.date = date;
    }

    public Payement() {
    }

    public int getId() {
        return id;
    }

    public int getIdTable() {
        return idTable;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
    
    
}
