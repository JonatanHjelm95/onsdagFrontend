/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Recipe;
import java.util.ArrayList;

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

}
