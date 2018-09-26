/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Recipe;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Fen
 */
public class RecipeComparator implements Comparator<Recipe> {

    @Override
    public int compare(Recipe t, Recipe t1) {
        CreateDate cd = new CreateDate();
        Date date = cd.convertToDate(t.getDate());
        Date date1 = cd.convertToDate(t1.getDate());
        return date.compareTo(date1);
    }
    
}
