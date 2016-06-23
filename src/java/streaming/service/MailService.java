/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

/**
 *
 * @author tom
 */
public class MailService {
    
    public void envoyerMail(String mailDest, String titre, String msg){
        
        System.out.println("*** Envoi mail: " + mailDest + " " + titre + " " + msg);
    }
}
