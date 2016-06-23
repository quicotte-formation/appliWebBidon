/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.servlet;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListerFilmsServlet", urlPatterns = {"/films_lister"})
public class ListerFilmsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Récup films DB
        FilmService service = new FilmService();
        List<Film> filmsTrouves = service.lister();
        
        // Init attributs pour la JSP
        req.setAttribute("films", filmsTrouves);
        req.setAttribute("connecte", req.getParameter("connecte"));
        
        // Forward vers JSP
        req.getRequestDispatcher("film_list.jsp").forward(req, resp);
    }

    
}
