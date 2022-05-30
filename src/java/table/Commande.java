/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import connex.Connex;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class Commande extends BdTable{
    int id;
    Timestamp dateCom;
    int status;
    int idTable;
    int idServeur;
    
     public Commande constructeur(ResultSet res)throws Exception
    {
        Commande c=new Commande(res.getInt(1),res.getTimestamp(2),res.getInt(3), res.getInt(4), res.getInt(5));
        return c;
    } 

    public Commande(int id, Timestamp dateCom, int status, int idTable, int idServeur) {
        this.id = id;
        this.dateCom = dateCom;
        this.idTable = idTable;
        this.status = status;
        this.idServeur = idServeur;
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

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdServeur() {
        return idServeur;
    }

    public void setIdServeur(int idServeur) {
        this.idServeur = idServeur;
    }
    
    
    
    public Vector getCommandesValide() throws Exception{
        Vector rep = new Vector();
        Connex con = new Connex();
        String req = "select * from commande where status=1";
        rep = this.findReq(req, this, con.getCon());
        con.deco();
        return rep;
    }
    
    public Vector getDetailCommande(int idcommande) throws Exception{
        Vector rep = new Vector();
        Connex con = new Connex();
        DetailCommande detcom = new DetailCommande();
        String req = "select * from detailcommande where idcommande="+idcommande;
        rep = detcom.findReq(req, detcom, con.getCon());
        con.deco();
        return rep;
    }
    
    public Commande getCommande(int idcommande) throws Exception{
        Commande rep = new Commande();
        Connex con = new Connex();
        String req = "select * from commande where id="+idcommande;
        Vector val  = this.findReq(req, this, con.getCon());
        rep.setId( ((Commande)val.get(0)).getId() );
        rep.setIdTable( ((Commande)val.get(0)).getIdTable() );
        rep.setDateCom( ((Commande)val.get(0)).getDateCom() );
        rep.setStatus( ((Commande)val.get(0)).getStatus() );
        con.deco();
        return rep;
    }
    
        
    public void InsertCommande(int idTable,int idServeur) throws Exception{
        Connex c = new Connex();
        this.setIdTable(idTable);
        this.setIdServeur(idServeur);
        this.setStatus(0);
        this.insertInto(c.getCon());
    }
    
      public int getlastId() throws Exception{
        Commande cat = new Commande();
        Connex con = new Connex();
        String req = "select * from commande where id=(select max(id) from commande)";
        Vector val = this.findReq(req, cat, con.getCon());
        return ((Commande)val.get(0)).getId();
    }
      
    public void update(int id,int idtable) throws Exception{
       
        Commande cat = new Commande();
        Connex c = new Connex();
        String req = "update commande set status=1 where id="+id+" and idtable="+idtable;
        System.out.println(req);
        java.sql.Statement stmt = c.getCon().createStatement();
        int ret =stmt.executeUpdate(req);
      
     }
 }
