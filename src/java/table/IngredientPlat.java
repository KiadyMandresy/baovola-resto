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
 * @author Dawood
 */
public class IngredientPlat extends BdTable {
    double quantite;
    int idplat;
    String ingredient;
    double prix;
    String unite;
    
    public IngredientPlat constructeur(ResultSet res)throws Exception
    {
        IngredientPlat j=new IngredientPlat(res.getDouble(1),res.getInt(2),res.getString(3),res.getDouble(4), res.getString(5));
        return j;
    } 

    public IngredientPlat(double quantite, int idplat, String ingredient, double prix, String unite) {
        this.quantite = quantite;
        this.idplat = idplat;
        this.ingredient = ingredient;
        this.prix = prix;
        this.unite = unite;
    }

    public IngredientPlat() {
    }

    public double getQuantite() {
        return quantite;
    }

    public int getIdplat() {
        return idplat;
    }

    public String getIngredient() {
        return ingredient;
    }

    public double getPrix() {
        return prix;
    }

    public String getUnite() {
        return unite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public void setIdplat(int idplat) {
        this.idplat = idplat;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    public Vector getIngredientPlat(int idplat) throws Exception{
        Vector liste =new Vector();
        Connex con = new Connex();
        String req = "select * from ingredientplat where idplat="+idplat;
        liste = this.findReq(req, this, con.getCon());
        con.deco();
        return liste;
    }
    public double getPrixRev(){
        double val = 0;
        val = (this.prix*this.quantite)/1000;
        return val;
    }
    public double getSommePrixRev(int id) throws Exception{
        Vector liste = this.getIngredientPlat(id);
        double somme =0;
        for(int i=0; i<liste.size(); i++){
            somme+= ((IngredientPlat)liste.get(i)).getPrixRev();
        }
        return somme;
    }
    
    public double getPrixVente(int id, int marge1, int marge2,int pourc1,int pourc2,int pourc3 ) throws Exception{
       double rev = this.getSommePrixRev(id);
       double prix = 0;
       if(rev<marge1){
           prix = rev + (rev*pourc1)/100;
       }
        if(rev>=marge1 && rev<marge2){
           prix = rev + (rev*pourc2)/100;
       }
       if(rev>=marge2){
           prix = rev + (rev*pourc3)/100;
       }
       return prix;
    }
}
