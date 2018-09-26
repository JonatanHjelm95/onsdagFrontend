/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Recipe;
import data.RecipesDAO;
import java.util.ArrayList;

/**
 *
 * @author jonab
 */
public class CollectionToHTML {

    private String recipesHTML = "";

    public CollectionToHTML() {
    }

    public String generateHTMLString(ArrayList<Recipe> recipes) {
        RecipesDAO dao = new RecipesDAO();

        recipesHTML = "<table style=\"width:100%\">\n"
                + "  <tr>\n"
                + "    <th>Recipe name</th>\n"
                + "    <th>Created</th>\n"
                + "    <th>Instructions</th> \n"
                + "    <th>Rating</th>\n"
                + "    <th>Image</th>\n"
                + "  </tr>\n";
        String inputData = "";
        for (int i = 0; i < recipes.size(); i++) {
            inputData = "  <tr>\n"
                    + "    <td>" + recipes.get(i).getRecipeName() + "</td>\n"
                    + "    <td>" + recipes.get(i).getDate() + "</td>\n"
                    + "    <td>" + recipes.get(i).getInstructions() + "</td> \n"
                    + "    <td>" + recipes.get(i).getRating() + "</td>\n"
                    + "    <td><img src =\"" + recipes.get(i).getImgURL() + "\"></td>\n"
                    + "  </tr>\n";
            recipesHTML += inputData;
            inputData = "";
        }

        recipesHTML += "</table>";

        return recipesHTML;
    }
}
