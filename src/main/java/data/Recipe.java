package data;

import java.util.ArrayList;

public class Recipe {
    private ArrayList<Ingredient> ingredients;
    private String instructions;
    private String imgURL;
    private String recipeName;
    private int rating;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Recipe() {
        ingredients = new ArrayList();
    }

    public Recipe(String instructions, String imgURL) {
        this.instructions = instructions;
        this.imgURL = imgURL;    
        ingredients = new ArrayList<>();
    }
    public Recipe(ArrayList<Ingredient> ingredients, String instructions, String imgURL, String recipeName, int rating) {
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imgURL = imgURL;
        this.recipeName = recipeName;
        this.rating = rating;
    }

    public Recipe(String instructions, String imgURL, String recipeName, int rating) {
        this.instructions = instructions;
        this.imgURL = imgURL;
        this.recipeName = recipeName;
        this.rating = rating;
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getRating() {
        return rating;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }


    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
    
    
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" + "ingredients=" + ingredients + ", instructions=" + instructions + ", imgURL=" + imgURL + ", recipeName=" + recipeName + ", rating=" + rating + '}';
    }
    
}
