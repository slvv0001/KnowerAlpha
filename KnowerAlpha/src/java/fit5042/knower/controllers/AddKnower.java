package fit5042.knower.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.knower.mbeans.KnowerManagedBean;

import javax.faces.bean.ManagedProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guan
 */
@RequestScoped
@Named("addKnower")
public class AddKnower {

    @ManagedProperty(value = "#{knowerManagedBean}")
    KnowerManagedBean propertyManagedBean;

    private boolean showForm = true;

    private Knower property;

    KnowerApplication app;

    public void setProperty(Knower property) {
        this.property = property;
    }

    public Knower getProperty() {
        return property;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public AddKnower() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (KnowerApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "knowerApplication");

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        propertyManagedBean = (KnowerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "knowerManagedBean");
    }

    public void addProperty(Knower localProperty) {
        //this is the local property, not the entity
        try {
            //add this property to db via EJB
            propertyManagedBean.addProperty(localProperty);

            //refresh the list in KnowerApplication bean
             app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Question has been added succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;
    }

}
