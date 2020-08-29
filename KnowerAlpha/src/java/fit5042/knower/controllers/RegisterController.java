/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.knower.controllers;

import fit5042.knower.mbeans.AuthorManagedBean;
import fit5042.knower.repository.entities.Author;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Lu Chen
 */
@RequestScoped
@Named("registerController")
public class RegisterController {
    @ManagedProperty(value = "#{authorManagedBean}")
    AuthorManagedBean authorManagedBean;
    

    private boolean showForm = true;

    private Author author;

    KnowerApplication app;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public RegisterController() {
//        ELContext context
//                = FacesContext.getCurrentInstance().getELContext();

//        app = (KnowerApplication) FacesContext.getCurrentInstance()
//                .getApplication()
//                .getELResolver()
//                .getValue(context, null, "knowerApplication");

        //instantiate authorManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        authorManagedBean = (AuthorManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "authorManagedBean");
    }

    public void addAuthor(fit5042.knower.controllers.Author localProperty) {
        //this is the local author, not the entity
        try {
            //add this author to db via EJB
            authorManagedBean.addAuthor(localProperty);

            //refresh the list in KnowerApplication bean
            // app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Register succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;
    }
}
