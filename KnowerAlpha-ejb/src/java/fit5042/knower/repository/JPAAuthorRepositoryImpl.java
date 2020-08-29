/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.knower.repository;

import fit5042.knower.repository.entities.Author;
import fit5042.knower.repository.entities.Knower;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luche
 */
@Stateless
public class JPAAuthorRepositoryImpl implements AuthorRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addAuthor(Author author) {
        List<Author> authors = entityManager.createQuery("SELECT p FROM Author p order by p.authorId DESC")
                .getResultList();
        if (authors.size() == 0){
            author.setAuthorId(1);
        } else {
            author.setAuthorId(authors.get(0).getAuthorId()+ 1);
        }
        
        entityManager.persist(author);
    }
    
}
