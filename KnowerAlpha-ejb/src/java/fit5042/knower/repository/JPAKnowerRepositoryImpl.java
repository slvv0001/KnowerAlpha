package fit5042.knower.repository;

import fit5042.knower.repository.KnowerRepository;
import fit5042.knower.repository.entities.Author;
import fit5042.knower.repository.entities.Knower;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Feng
 */
@Stateless
public class JPAKnowerRepositoryImpl implements KnowerRepository {

    //insert code (annotation) here to use container managed entity manager to complete these methods  
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProperty(Knower property) throws Exception {
        List<Knower> properties = entityManager.createNamedQuery(Knower.GET_ALL_QUERY_NAME).getResultList();
        if (properties.size() == 0){
            property.setPropertyId(1);
        } else {
            property.setPropertyId(properties.get(0).getPropertyId() + 1);
        }
        
        entityManager.persist(property);
    }

    @Override
    public Knower searchPropertyById(int id) throws Exception {
        Knower property = entityManager.find(Knower.class, id);
        property.getTags();
        return property;
    }

    @Override
    public List<Knower> getAllProperties() throws Exception {
        return entityManager.createNamedQuery(Knower.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<Knower> searchPropertyByAuthor(Author author) throws Exception {
        author = entityManager.find(Author.class, author.getAuthorId());
        author.getProperties().size();
        entityManager.refresh(author);

        return author.getProperties();
    }

    @Override
    public List<Author> getAllAuthors() throws Exception {
        return entityManager.createNamedQuery(Author.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        //complete this method
        Knower p=searchPropertyById(propertyId);
        if(p!=null)
            entityManager.remove(p);
    }

    @Override
    public void editProperty(Knower property) throws Exception {
        try {
            entityManager.merge(property);
        } catch (Exception ex) {

        }
    }

    @Override
    public List<Knower> searchPropertyByPopularity(double popularity) throws Exception {
        //complete this method using Criteria API
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Knower> q=cb.createQuery(Knower.class);
        Root<Knower> r=q.from(Knower.class);
        Predicate condition=cb.le(r.get("likes"), popularity);
        q.where(condition);
        TypedQuery<Knower> tq=entityManager.createQuery(q);
        List<Knower> result=tq.getResultList();
        return result;
    }
}
