/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import streaming.entity.Film;

/**
 *
 * @author tom
 */
public class FilmDAO {
    
    public void modifier(Film film){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        
        em.merge(film);
        
        em.getTransaction().commit();
    }
    
    public void supprimer(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        
//        Query q = em.createQuery("DELETE FROM Film f WHERE f.id=:idFilm");
//        q.setParameter("idFilm", id);
//        q.executeUpdate();

        Film f = em.find(Film.class, id);
        em.remove(f);
                
        em.getTransaction().commit();
    }
    
    public Film rechercherParId(long id){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.find(Film.class, id);
    }
    
    public List<Film> listerTous(){
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT f FROM Film f").getResultList();
    }

    public void ajouter(Film f) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }
}
