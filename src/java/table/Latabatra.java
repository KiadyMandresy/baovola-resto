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
    
    public Latabatra getLatatbatra(int idlatabatra) throws Exception{
        Latabatra lat = new Latabatra();
        Connex con = new Connex();
        String req = "select * from latabatra where id="+idlatabatra;
        Vector li = this.findReq(req, lat, con.getCon());
        lat.setId( ((Latabatra)li.get(0)).getId() );
        lat.setNumero( ((Latabatra)li.get(0)).getNumero() );
        lat.setIsTaken( ((Latabatra)li.get(0)).getIsTaken() );
        con.deco();
        return lat;
    }
    
    public Vector getAllLatabatra() throws Exception{
        Connex con =new Connex();
        Vector liste = this.find(this, con.getCon());
        con.deco();
        return liste;
    }
    
    public Vector getFreeLatabatra() throws Exception{
        Connex con =new Connex();
        String req = "select * from latabatra where isTaken=0";
        Vector liste = this.findReq(req,this, con.getCon());
        con.deco();
        return liste;
    }
}
