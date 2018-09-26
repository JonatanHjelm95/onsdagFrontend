/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author jonab
 */
public class CreateRecipeForms {
    
    
    public String generateHTMLForms(String numberOfIngredients){
        String html = "";
        int number = Integer.parseInt(numberOfIngredients);
        for (int i = 0; i < number; i++) {
            html += "\n" +
"                <br>\n" +
"                <input type=\"text\" name=\"ingredients"+i+"\" placeholder=\"Enter ingredient\"/>\n" +
"                <input type=\"text\" name=\"qty"+i+"\" placeholder=\"Enter quantity\"/>";
        }
        return html;
    }
}
