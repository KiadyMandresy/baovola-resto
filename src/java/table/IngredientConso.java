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
public class IngredientConso  extends BdTable{
    String ingredient;
    int quantite;
    double prix;
   
    
     public IngredientConso constructeur(ResultSet res)throws Exception
    {
        IngredientConso j=new IngredientConso(res.getString(1),res.getInt(2), res.getDouble(3));
        return j;
    } 


    public String getIngredient() {
        return ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
     public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
   

    public IngredientConso(String ingredient, int quantite,double prix) {
        this.ingredient = ingredient;
        this.quantite = quantite;
        this.prix = prix;
    }

    public IngredientConso() {
    }
    
    public Vector getIngredient(String date1, String date2) throws Exception{
        IngredientConso tab = new IngredientConso();
        Connex con = new Connex();
        String req = "select v.ingredient as ingredient, sum(v.quantite) as quantite , sum(v.prix) as prix from detailCommande as d join ingredientPlat as v on (d.idPlat=v.idPlat) join commande as c on (d.idCommande=c.id)  where c.dateCom>'"+date1+"' and c.dateCom<='"+date2+"' group by v.ingredient";
        Vector val = this.findReq(req, tab, con.getCon());
        return val;
    }
    
    public double getTotal(Vector liste ){
        double total=0;
        for(int i=0; i<liste.size(); i++){
            total += ((IngredientConso)liste.get(i)).getPrix();
        }
        return total;
    }
}
