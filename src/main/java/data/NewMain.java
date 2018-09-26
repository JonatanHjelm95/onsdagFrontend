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
        ArrayList<Ingredient> ingredients = new ArrayList();
        ingredients.add(new Ingredient("Banan", "2"));
        ingredients.add(new Ingredient("Mel", "250"));
        ingredients.add(new Ingredient("Mælk", "3"));
        Recipe recipe = new Recipe(ingredients, "Kom alle ingredienser i en skål og så smid det i ovnen", "images/kage.jpg", "Farmors flotte kager", 2);
        recipe.setDate(dato);
        hej.createRecipe(recipe);
//        hej.displayAllRecipeNames();
        //hej.displaySingleRecipe1();
       
    }

}
