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
 * @author ravonirinafitahianarandriamanantena
 */
public class Utilisateur extends BdTable{
    int id;
    String usernamde;
    String password;
    String roleUser;
    
    public Utilisateur constructeur(ResultSet res) throws SQLException{
        Utilisateur u = new Utilisateur(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
        return u;
    }

    public Utilisateur(int id, String usernamde, String password, String roleUser) {
        this.id = id;
        this.usernamde = usernamde;
        this.password = password;
        this.roleUser = roleUser;
    }

    public Utilisateur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsernamde() {
        return usernamde;
    }

    public void setUsernamde(String usernamde) {
        this.usernamde = usernamde;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }
    
    public Utilisateur log(String user,String mdp) throws Exception{
        String req = "select * from utilisateur where username='"+user+"' and password='"+mdp+"'";
        Utilisateur ret = new Utilisateur();
        BdTable bd = new BdTable();
        Connex c = new Connex();
        Vector util = bd.findReq(req, ret, c.getCon());
        if(util.size() == 1){
            ret = (Utilisateur)(util.get(0));
        }
        return ret;
    }
}
