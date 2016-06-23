/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import streaming.dao.UtilisateurDAO;
import streaming.entity.Utilisateur;

/**
 *
 * @author tom
 */
public class UtilisateurService {

    public void inscription(Utilisateur util){
        
        UtilisateurDAO dao = new UtilisateurDAO();
        
        // VALIDATION
        
        // Throw exception si login existe
        
        List<Utilisateur> listeUtilAvecCeLogin = dao.rechercheParLogin(util.getLogin());
        
        if( listeUtilAvecCeLogin.size()>0 ){
            throw new RuntimeException("Ce login existe déjà");
        }
        
        // PASSE l'uil à l'état NON VALIDE
        util.setEtatUtil(Utilisateur.EtatUtil.NON_VALIDE);
        
        // Persiste
        dao.ajouter(util);
        
        // Envoie mail de validation
        new MailService().envoyerMail(util.getEmail(), "Inscription réussie", "Veuillez valider");
    }
    
    public Utilisateur rechercheParLoginEtMdp(String login, String mdp) {
        
        return new UtilisateurDAO().rechercheParLoginEtMdp(login, mdp);
    }
    
}
