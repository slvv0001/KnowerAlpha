package fit5042.knower.repository;

import fit5042.knower.repository.entities.Author;
import fit5042.knower.repository.entities.Knower;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 * @autor Shuang
 *@author Lu Chen
 */
@Remote
public interface KnowerRepository {

    /**
     * Add the property being passed as parameter into the repository
     *
     * @param property - the property to add
     */
    public void addProperty(Knower property) throws Exception;

    /**
     * Search for a property by its property ID
     *
     * @param id - the propertyId of the property to search for
     * @return the property found
     */
    public Knower searchPropertyById(int id) throws Exception;

    /**
     * Return all the properties in the repository
     *
     * @return all the properties in the repository
     */
    public List<Knower> getAllProperties() throws Exception;

    /**
     * Return all the contact people in the repository
     *
     * @return all the contact people in the repository
     */
    public List<Author> getAllAuthors() throws Exception;

    /**
     * Remove the property, whose property ID matches the one being passed as
     * parameter, from the repository
     *
     * @param propertyId - the ID of the property to remove
     */
    public void removeProperty(int propertyId) throws Exception;

    /**
     * Update a property in the repository
     *
     * @param property - the updated information regarding a property
     */
    public void editProperty(Knower property) throws Exception;

    /**
     * Search for properties whose price is less than or equal to a budget
     *
     * @param budget - the budget that the price of the returned properties must
     * be lower than or equal to
     * @return the properties found
     */
    public List<Knower> searchPropertyByPopularity(double popularity) throws Exception;

    /**
     * Search for properties by their contact person
     *
     * @param contactPerson - the contact person that is responsible for the
     * properties
     * @return the properties found
     */
    Set<Knower> searchPropertyByAuthor(Author author) throws Exception;
}
