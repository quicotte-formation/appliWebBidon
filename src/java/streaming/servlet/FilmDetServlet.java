/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import streaming.entity.Film;
import streaming.service.FilmService;

/**
 *
 * @author tom
 */
@WebServlet(name = "FilmDetServlet", urlPatterns = {"/film_detail"})
public class FilmDetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Récup ID
        long idFilm = Long.parseLong( req.getParameter("id") );
        
        // Récup Film à partir de idFilm
        Film f = new FilmService().rechercherParId(idFilm);
        
        // Set attribute film
        req.setAttribute("film", f);
        
        // Forward vers JSP
        req.getRequestDispatcher("film_detail.jsp").forward(req, resp);
    }

    
}
