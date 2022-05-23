/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mac
 */
public class CategoriePlat extends BdTable{
    int id;
    String designation;
    
    public CategoriePlat(){}
    
    public CategoriePlat(int id,String designation){
        this.id=id;
        this.designation=designation;
    }
    
    public CategoriePlat constructeur(ResultSet res) throws SQLException{
        CategoriePlat cp = new CategoriePlat(res.getInt(1),res.getString(2));
        return cp;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
}
