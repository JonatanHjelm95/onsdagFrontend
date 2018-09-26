/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jonab
 */
public class RecipesDAO {

    private DBConnector con;
    //private Recipe recipe;

    public RecipesDAO() {

        try {
            this.con = new DBConnector();
        } catch (Exception ex) {
            Logger.getLogger(RecipesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't connect to DB");
        }
        //this.recipe = new Recipe();
    }

    public void editRecipe(Recipe recipe) {
        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "DELETE FROM `cupcakeRecipes`.`Recipe` WHERE `recipeName`='"
                    + recipe.getRecipeName() + "';";

            stmt.executeUpdate(query);
//            System.out.println(rs);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void createRecipe(Recipe recipe) {
        ResultSet rs = null;

        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "INSERT INTO `cupcakeRecipes`.`Recipe`"
                    + " (`recipeName`, `created`, `instructions`, `rating`, `image`)"
                    + " VALUES ('" + recipe.getRecipeName() + "', '" + recipe.getDate() + "',"
                    + " '" + recipe.getInstructions() + "',"
                    + " '" + recipe.getRating() + "', '" + recipe.getImgURL() + "');";
            stmt.executeUpdate(query);
            String query2 = "";
            for (Ingredient ingredient : recipe.getIngredients()) {
                query2 += "INSERT INTO `cupcakeRecipes`.`IngredientDetails`"
                        + " (`qty`, `recipeName`, `ingredientName`)"
                        + " VALUES ('" + ingredient.getQty() + "', '" + recipe.getRecipeName() + "', '" + ingredient.getName() + "');";
                stmt.executeUpdate(query2);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

//    public void createRecipe() {
//        ResultSet rs = null;
//
//        try {
//            Statement stmt = con.getConnection().createStatement();
//            String query = "insert into Recipe\n"
//                    + "values ('Farmors flotte kager', 'Kom alle ingredienser i en skål og så smid det i ovnen', 'Tommel op', null),\n"
//                    + "('Bedstemor med slag i', 'Fuld drøn på røremaskinen og så 400 grader i ovnen 20 min', 'Tommel op', null);";
//
//            stmt.executeUpdate(query);
////            System.out.println(rs);
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
    public String displaySingleRecipe(String recipeName) {
        ResultSet rs;

        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "SELECT *"
                    + "FROM `Recipe`"
                    + "WHERE recipeName = '" + recipeName + "';";

            rs = stmt.executeQuery(query);
            if (rs.next()) {
                String res = rs.toString();
                System.out.println(res);
            }
            System.out.println(rs);
            return rs.toString();

        } catch (Exception e) {
            return e.toString();
        }

    }

    public Recipe displaySingleRecipe1(String recipeName) {
        ResultSet rs = null;
        ResultSet rs2 = null;
        Recipe recipe;

        try {
            recipe = db_GetRecipeData(recipeName);
            recipe.setIngredients(db_GetIngredientsData(recipeName));
            return recipe;

        } catch (Exception e) {
//            return e.toString();
        }
        return null;
    }

    private ArrayList<Ingredient> db_GetIngredientsData(String recipeName) throws SQLException {
        ResultSet rs2;
        Statement stmt2 = con.getConnection().createStatement();
        String query2 = "SELECT * FROM IngredientDetails\n"
                + "where recipeName = '" + recipeName + "';";
        rs2 = stmt2.executeQuery(query2);
        ArrayList<Ingredient> ingredients = new ArrayList();
        while (rs2.next()) {
            Ingredient ingredient = new Ingredient(rs2.getString("ingredientName"), rs2.getString("qty"));
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    private Recipe db_GetRecipeData(String recipeName) throws SQLException {
        ResultSet rs;
        Statement stmt = con.getConnection().createStatement();
        String query = "SELECT * FROM cupcakeRecipes.Recipe\n"
                + "where recipeName = '" + recipeName + "';";
        rs = stmt.executeQuery(query);
        Recipe recipe = new Recipe();
        if (rs.next()) {
            recipe.setRecipeName(rs.getString("recipeName"));
            recipe.setInstructions(rs.getString("instructions"));
            recipe.setRating(rs.getInt("rating"));
            recipe.setImgURL(rs.getString("image"));
        }
        return recipe;
    }

    public ArrayList<String> displayAllRecipeNames() {
        ResultSet rs;
        ArrayList<String> recipeNames = new ArrayList();
        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "SELECT recipeName FROM cupcakeRecipes.Recipe;";

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                for (int i = 0; i < rs.getRow(); i++) {

                    recipeNames.add(rs.getString("recipeName"));
                }
//                recipeNames.add(new Recipe(rs.getString("recipeName")));
            }
//            System.out.println(recipeNames.get(1));
//            return recipeNames;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return recipeNames;
    }

    public ArrayList<Recipe> getAllRecipes() {
        ResultSet rs;
        ArrayList<Recipe> recipes = new ArrayList();

        try {
            Statement stmt = con.getConnection().createStatement();
            String query = "SELECT * FROM cupcakeRecipes.Recipe;";

            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String recipeName = rs.getString("recipeName");
//                String instructions = rs.getString("instructions");
//                String rating = rs.getString("rating");
//                String imageURL = rs.getString("image");
                Recipe recipe = db_GetRecipeData(recipeName);
                recipe.setIngredients(db_GetIngredientsData(recipeName));
                recipes.add(recipe);
//                return recipes;
            }
            return recipes;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
