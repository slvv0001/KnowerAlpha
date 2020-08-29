package fit5042.knower.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Shuang
 */
@Entity(name="Author")
@Table(name = "Author")
@NamedQueries({
    @NamedQuery(name = Author.GET_ALL_QUERY_NAME, query = "SELECT a FROM Author a order by a.authorId")})
public class Author implements Serializable {

    public static final String GET_ALL_QUERY_NAME = "Author.getAll";

    @Id
    @GeneratedValue
    @Column(name = "author_id")
    private int authorId;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;



    private Set<Knower> properties;

    public Author() {
    }

    public Author(int authorId, String name, String phoneNumber) {
        this.authorId = authorId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.properties = new HashSet<>();
    }
        public Author(int authorId, String name, String phoneNumber, String password, String role) {
        this.authorId = authorId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public Author(int authorId, String name, String phoneNumber, String password, String role, Set<Knower> properties) {
        this.authorId = authorId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.properties = properties;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //enforce the relationship between a property and its contact person using annotation(s). Each property has one and only one contact person. Each contact person might be responsible for zero to many properties
    public Set<Knower> getProperties() {
        return properties;
    }

    public void setProperties(Set<Knower> properties) {
        this.properties = properties;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.authorId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (this.authorId != other.authorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.authorId + " - " + name + " - " + phoneNumber;
    }
}
