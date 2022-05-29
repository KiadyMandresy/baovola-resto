/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import connex.Connex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
    
    public Vector categories() throws Exception{
        Vector liste = new Vector();
        Connex con =new Connex();
        liste = this.find(this, con.getCon());
        con.deco();
        return liste;
    }
    
    public  String getCatById(int id) throws Exception{
        Connex con = new Connex();
        String req = "select * from categoriePlat where id="+id;
        Vector val = this.findReq(req, this, con.getCon());
        con.deco();
        return ((CategoriePlat)val.get(0)).getDesignation();
    }

    public Vector getCategorie() throws Exception {
        CategoriePlat plat = new CategoriePlat();
        Connex con = new Connex();
        Vector val = this.find(plat, con.getCon());
        con.deco();
        return val;
    }
    
}
