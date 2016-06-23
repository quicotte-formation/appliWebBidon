/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Utilisateur;
import streaming.service.UtilisateurService;

/**
 *
 * @author tom
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Récup params de formulaire
        String login = req.getParameter("login");
        String mdp = req.getParameter("mdp");
        
        // Récup l'util correspondant ( en BD )
        Utilisateur u = new UtilisateurService().rechercheParLoginEtMdp(login, mdp);
        
        // Je suis loggé correctement
        resp.addCookie( new Cookie("login", login) );
        resp.addCookie( new Cookie("mdp", mdp) );
        resp.addCookie( new Cookie("util_type", u.getUtilType().toString()) );
        
        // Redirection vers ecran listage des films
        resp.sendRedirect("films_lister?connecte=vrai");
    }

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    
}
