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
    
}
