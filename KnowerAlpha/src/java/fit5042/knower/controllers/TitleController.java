/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.knower.controllers;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Guan
 */
@Named(value = "titleController")
@RequestScoped
public class TitleController {

    private String homePageTitle;
    private String aboutPageTitle;
    private String contactPageTitle;
    private String welcomePageTitle;

    
    public TitleController() {
        // Set the page title 
        homePageTitle = "Knower - Home";
        aboutPageTitle= "Knower - About";
        contactPageTitle="Knower - Contact";
        welcomePageTitle="Knower";
    }
    public String getHomePageTitle() {
        return homePageTitle;
    }

    public void setHomePageTitle(String homePageTitle) {
        this.homePageTitle = homePageTitle;
    }

    public String getAboutPageTitle() {
        return aboutPageTitle;
    }

    public void setAboutPageTitle(String aboutPageTitle) {
        this.aboutPageTitle = aboutPageTitle;
    }
     public String getContactPageTitle() {
        return contactPageTitle;
    }

    public void setContactPageTitle(String contactPageTitle) {
        this.contactPageTitle = contactPageTitle;
    }
    public String getWelcomePageTitle() {
        return welcomePageTitle;
    }

    public void setWelcomePageTitle(String welcomePageTitle) {
        this.welcomePageTitle = welcomePageTitle;
    }

    
}
