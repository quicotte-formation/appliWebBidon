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
import streaming.entity.Utilisateur;

/**
 *
 * @author tom
 */
public class UtilisateurDAO {

    public Utilisateur rechercheParLoginEtMdp(String login, String mdp) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:monLogin AND u.mdp=:monMdp");
        query.setParameter("monLogin", login);
        query.setParameter("monMdp", mdp);
        
        return (Utilisateur) query.getSingleResult();
    }

    public List<Utilisateur> rechercheParLogin(String login) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:login")
                .setParameter("login", login).getResultList();
    }

    public void ajouter(Utilisateur util) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
