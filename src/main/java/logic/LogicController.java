/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Ingredient;
import data.Recipe;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Fen
 */
public class LogicController {

    /**
     * Searches list of recipes for specific Recipe with the recipeName
     * Returns the Recipe if found, otherwise null
     * @param recipeName
     * @param recipes
     * @return 
     */
    public Recipe getSpecificRecipe(String recipeName, ArrayList<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            if(recipeName.equals(recipe.getRecipeName()))
                return recipe;
        }
        return null;
    }
    
    public ArrayList<Ingredient> convertStringToIngredients(String ingredients) {
        ArrayList<Ingredient> ingre = new ArrayList();
        String[] array = ingredients.split(":");
        for (int i = 0; i<array.length; i++){
            String[] nameAndQty = array[i].split(" ");
            ingre.add(new Ingredient(nameAndQty[0],nameAndQty[1]));
        }
        
        return ingre;
    }
    
    public ArrayList<Recipe> sortRecipesByDate(ArrayList<Recipe> recipes) {
        Collections.sort(recipes, new RecipeComparator());
        return recipes;
    }

}
