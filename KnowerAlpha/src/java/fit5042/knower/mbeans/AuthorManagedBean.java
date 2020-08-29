/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.knower.mbeans;

import fit5042.knower.repository.AuthorRepository;
import fit5042.knower.repository.KnowerRepository;
import fit5042.knower.repository.entities.Author;
import fit5042.knower.repository.entities.Knower;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author Lu Chen
 */
@Named(value = "authorManagedBean")
@SessionScoped
public class AuthorManagedBean implements Serializable {
    @EJB
    AuthorRepository authorRepository;
    /**
     * Creates a new instance of AuthorManagedBean
     */
    public AuthorManagedBean() {
    }
    
        public void addAuthor(fit5042.knower.controllers.Author author) {
            
        try {
            authorRepository.addAuthor(convertAuthorToEntity(author));
        } catch (Exception ex) {
            Logger.getLogger(AuthorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        private Author convertAuthorToEntity(fit5042.knower.controllers.Author localAuthor) throws NoSuchAlgorithmException{
            Author author = new Author();
            author.setName(localAuthor.getName());
            
            final MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
            final byte bin[] = messageDigest.digest((localAuthor.getPassword()).getBytes());
            author.setPassword(bytesToHex(bin));
            //can only be registered as user.
            author.setRole("user");
            
            return author;
        }
        
        private static String bytesToHex(byte[] hash) {
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	    String hex = Integer.toHexString(0xff & hash[i]);
	    if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
    
}
