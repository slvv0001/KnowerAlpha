package fit5042.knower.controllers;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
@RequestScoped
@Named(value = "author")
public class Author implements Serializable {

    private int authorId;
    private String name;
    private String phoneNumber;
    private String password;
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
