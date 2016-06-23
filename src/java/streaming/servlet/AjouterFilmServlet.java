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
import streaming.entity.Genre;
import streaming.service.FilmService;
import streaming.service.GenreService;

/**
 *
 * @author tom
 */
@WebServlet(name = "AjouterFilmServlet", urlPatterns = {"/film_ajouter"})
public class AjouterFilmServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Récup genre 
        long genreId = Long.parseLong( req.getParameter("genre_id") );
        Genre genre = new GenreService().rechercherParId( genreId );
        
        // Construit un film à partir de l'écran précédent
        Film f = new Film();
        f.setTitre( req.getParameter("titre") );
        genre.getFilms().add(f);
        f.setGenre(genre);
        
        // Persiste
        new FilmService().ajouter(f);
        
        // Forward vers liste films
        resp.sendRedirect("films_lister");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Récup genres
        List<Genre> mesGenres = new GenreService().lister();
        
        // Init attributs pr JSP
        req.setAttribute("genres", mesGenres);
        
        // Forward vers JSP forumlaire
        req.getRequestDispatcher("new_movie.jsp").forward(req, resp);
    }

    
}
