/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.knower.controllers;

import fit5042.knower.repository.entities.Question;
import fit5042.knower.repository.entities.Author;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Guan
 */
@RequestScoped
@Named(value = "knower")
public class Knower implements Serializable {

    private int propertyId;
    private double likes;

    private Question question;
    private Author author;

    private HashSet<String> tags;

    private String questionTitle;
    private String questionDetail;
    private String type;
    

    private int authorId;
    private String name;
    private String phoneNumber;

    private Set<fit5042.knower.repository.entities.Knower> properties;

    public Knower() {
        this.tags = new HashSet<>();
    }

    //non-defaut constructor
    public Knower(int propertyId, Question question, double likes, Author author, Set<String> tags) {
        this.propertyId = propertyId;
        this.question = question;
        
        this.likes = likes;
        this.author = author;
        this.tags = (HashSet<String>) tags;
    }

    //=================================================================================
    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Set<fit5042.knower.repository.entities.Knower> getProperties() {
        return properties;
    }

    public void setProperties(Set<fit5042.knower.repository.entities.Knower> properties) {
        this.properties = properties;
    }
    //==================================================================================

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Property{" + "propertyId=" + propertyId + ", likes=" + likes + ", address=" + question + ", author=" + author + ", tags=" + tags + '}';
    }
}
