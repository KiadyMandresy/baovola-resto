/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.sql.ResultSet;

/**
 *
 * @author ravonirinafitahianarandriamanantena
 */
public class Client extends BdTable{
    int id;
    
    public Client constructeur(ResultSet res)throws Exception
    {
        Client c=new Client(res.getInt(1));
        return c;
    } 

    public Client(int id) {
        this.id = id;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}