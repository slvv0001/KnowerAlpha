/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.knower.repository;

import fit5042.knower.repository.entities.Author;
import javax.ejb.Remote;

/**
 *
 * @author luche
 */
@Remote
public interface AuthorRepository {
    public void addAuthor(Author author);
    
}
