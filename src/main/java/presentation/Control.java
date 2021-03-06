/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Ingredient;
import data.Recipe;
import data.RecipesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.CreateDate;
import logic.LogicController;

/**
 *
 * @author porse
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    private RecipesDAO dao = new RecipesDAO();
    private LogicController lc = new LogicController();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String origin = request.getParameter("origin");

            if (origin != null) {
                switch (origin) {
                    case "login":
                        request.setAttribute("message", "Login method not implemented");
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                        break;

                    case "getRecipes":
                        HttpSession session = request.getSession();
                        ArrayList<Recipe> recipes = dao.getAllRecipes();
                        lc.sortRecipesByDate(recipes);
                        session.setAttribute("recipes", recipes);
                        request.getRequestDispatcher("showallrecipes.jsp").forward(request, response);
                        break;

                    case "showRecipe":

                        request.getRequestDispatcher("showRecipe.jsp").forward(request, response);
                        break;
                        
                    case "newRecipe":
                        request.getRequestDispatcher("addRecipe.jsp").forward(request, response);
                        break;
                        
                    case "createRecipe":
                        String recipeName = request.getParameter("recipename");
                        String ingredients = request.getParameter("ingredients");
                        String instructions = request.getParameter("instructions");
                        ArrayList<Ingredient> ingres = lc.convertStringToIngredients(ingredients);
                        Recipe recipe = new Recipe(ingres, instructions, "images/kage.jpg", recipeName, 3);
                        CreateDate da = new CreateDate();
                        recipe.setDate(da.createDate());
                        dao.createRecipe(recipe);
                        request.getRequestDispatcher("frontPage.jsp").forward(request, response);
                        break;

                    default:
                        request.getRequestDispatcher("frontPage.jsp").forward(request, response);
                        break;

                }
            } else {
                request.getRequestDispatcher("frontPage.jsp").forward(request, response);
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
