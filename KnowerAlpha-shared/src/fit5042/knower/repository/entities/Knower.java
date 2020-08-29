package fit5042.knower.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Shuang
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Knower.GET_ALL_QUERY_NAME, query = "SELECT p FROM Knower p order by p.propertyId")})

public class Knower implements Serializable {

    public static final String GET_ALL_QUERY_NAME = "Knower.getAll";

    private int propertyId;
    
    private double likes;

    private Question question;
    private Author author;

    private Set<String> tags;

    public Knower() {
        this.tags = new HashSet<>();
    }

    public Knower(int propertyId, Question question, double likes, Author author, Set<String> tags) {
        this.propertyId = propertyId;
        this.question = question;
        
        this.likes = likes;
        this.author = author;
        this.tags = tags;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "property_id")
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Embedded
    //insert annotation here to make addess as embeded to Knower entity and stored as part of Knower
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public double getLikes() {
        return likes;
    }

    public void setLikes(double likes) {
        this.likes = likes;
    }

    @ManyToOne
    //enforce the relationship between a property and its contact person using annotation(s). Each property has one and only one contact person. Each contact person might be responsible for zero to many properties
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    //annotate the attribute tags in Knower class so that the tags of a property will be stored in a table called TAG. The tags of a property should be eagerly fetched and the value of each tag must be stored in a column VALUE in the TAG table
    @ElementCollection
    @CollectionTable(name="tag")
    @Column(name="value")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Property{" + "propertyId=" + propertyId + ", likes=" + likes + ", question=" + question + ", author=" + author + ", tags=" + tags + '}';
    }
}
