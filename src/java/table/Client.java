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
public class Client extends BdTable{
    int id;
    String nom;
    
    public Client constructeur(ResultSet res)throws Exception
    {
        Client c=new Client(res.getInt(1), res.getString(2));
        return c;
    } 

    public Client(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Client getClient(int id) throws Exception{
        Client cli = new Client();
        Connex con = new Connex();
        String req = "select * from client where id="+id;
        Vector client = this.findReq(req, this, con.getCon());
        cli.setId( ((Client)client.get(0)).getId() );
        cli.setNom(  ((Client)client.get(0)).getNom() );
        return cli;
    }
    
    public Client getClientByCom(int idcommande) throws Exception{
        ClientCommande clicom = new ClientCommande();
        clicom = clicom.getClientCommande(idcommande);
        Client cli = this.getClient(clicom.getIdClient());
        return cli;
    }
}
