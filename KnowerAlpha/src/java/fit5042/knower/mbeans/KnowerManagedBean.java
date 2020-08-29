/*
 * To change this license header, choose License Headers in Project Properties.
 */
package fit5042.knower.mbeans;

import fit5042.knower.repository.entities.Question;
import fit5042.knower.repository.entities.Author;
import fit5042.knower.repository.entities.Knower;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import fit5042.knower.repository.KnowerRepository;

/**
 *
 * @author Feng
 * @author Shuang
 */
@ManagedBean(name = "knowerManagedBean")
@SessionScoped

public class KnowerManagedBean implements Serializable {

    @EJB
    KnowerRepository propertyRepository;

    /**
     * Creates a new instance of PropertyManagedBean
     */
    public KnowerManagedBean() {
    }

    public List<Knower> getAllProperties() {
        try {
            List<Knower> properties = propertyRepository.getAllProperties();
            return properties;
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addProperty(Knower property) {
        try {
            propertyRepository.addProperty(property);
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Search a property by Id
     */
    public Knower searchPropertyById(int id) {
        try {
            return propertyRepository.searchPropertyById(id);
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Set<Knower> searchPropertyByAuthor(Author author) {
        try {
            return propertyRepository.searchPropertyByAuthor(author);
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public List<Author> getAllAuthors() throws Exception {
        try {
            return propertyRepository.getAllAuthors();
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void removeProperty(int propertyId) {
        try {
            propertyRepository.removeProperty(propertyId);
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editProperty(Knower property) {
        try {
            String s = property.getQuestion().getQuestionTitle();
            String d=property.getQuestion().getQuestionDetail();
            Question question = property.getQuestion();
            question.setQuestionTitle(s);
            question.setQuestionDetail(d);
            property.setQuestion(question);

            propertyRepository.editProperty(property);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Question has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Knower> searchPropertyByPopularity(double popularity) {
        try {
            return propertyRepository.searchPropertyByPopularity(popularity);
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void addProperty(fit5042.knower.controllers.Knower localProperty) {
        //convert this newProperty which is the local property to entity property
        Knower property = convertPropertyToEntity(localProperty);

        try {
            propertyRepository.addProperty(property);
        } catch (Exception ex) {
            Logger.getLogger(KnowerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Knower convertPropertyToEntity(fit5042.knower.controllers.Knower myProperty) {
        Knower property = new Knower(); //entity
        String questionTitle = myProperty.getQuestionTitle();
        String questionDetail = myProperty.getQuestionDetail();
        String type = myProperty.getType();
        Question question = new Question(questionTitle, questionDetail, type);
        property.setQuestion(question);
        property.setLikes(myProperty.getLikes());
        property.setPropertyId(myProperty.getPropertyId());
        property.setTags(myProperty.getTags());
        int authorId = myProperty.getAuthorId();
        String name = myProperty.getName();
        String phoneNumber = myProperty.getPhoneNumber();
        Author author = new fit5042.knower.repository.entities.Author(authorId, name, phoneNumber);
        if (author.getAuthorId() == 0) {
            author = null;
        }
        property.setAuthor(author);
        return property;
    }

}
