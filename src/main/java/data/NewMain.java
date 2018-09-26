/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import logic.CreateDate;

/**
 *
 * @author jonab
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        RecipesDAO hej = new RecipesDAO();
        CreateDate da = new CreateDate();
        
        String dato = da.createDate();
        System.out.println(dato);
//        hej.displayAllRecipeNames();
        //hej.displaySingleRecipe1();
       
    }

}
