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
 * @author ravonirinafitahianarandriamanantena
 */
public class ClientCommande extends BdTable{
    int id;
    int idClient;
    int idCommande;
    
    public ClientCommande constructeur(ResultSet res)throws Exception
    {
        ClientCommande cc=new ClientCommande(res.getInt(1),res.getInt(2),res.getInt(3));
        return cc;
    } 

    public ClientCommande(int id, int idClient, int idCommande) {
        this.id = id;
        this.idClient = idClient;
        this.idCommande = idCommande;
    }

    public ClientCommande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
    
    public ClientCommande getClientCommande(int idcommande) throws Exception{
        ClientCommande clicom = new ClientCommande();
        Connex con = new Connex();
        String req = "select * from clientCommande where idcommande="+idcommande;
        Vector li = clicom.findReq(req, clicom, con.getCon());
        clicom.setId( ((ClientCommande)(li.get(0))).getId() );
        clicom.setIdClient( ((ClientCommande)li.get(0)).getIdClient() );
        clicom.setIdCommande( ((ClientCommande)li.get(0)).getIdCommande() );
        return clicom;
    }
    
    public void InsertClientCommande(int idClient,int idCommande) throws Exception{
        Connex c = new Connex();
        this.setIdClient(idClient);
        this.setIdCommande(idCommande);
        this.insertInto(c.getCon());
    }
}
