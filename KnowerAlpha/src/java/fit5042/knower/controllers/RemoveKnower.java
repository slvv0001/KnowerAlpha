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
@Named("removeKnower")
public class RemoveKnower {

    @ManagedProperty(value = "#{knowerManagedBean}")
    KnowerManagedBean propertyManagedBean;

    private boolean showForm = true;

    //private final ArrayList<fit5042.tutex.repository.entities.Knower> properties;
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

    public RemoveKnower() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (KnowerApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "knowerApplication");

        app.updatePropertyList();

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        propertyManagedBean = (KnowerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "knowerManagedBean");
    }

    /**
     * @param property Id
     */
    public void removeProperty(int propertyId) {
        try {
            //remove this property from db via EJB
            propertyManagedBean.removeProperty(propertyId);

            //refresh the list in KnowerApplication bean
             app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Question has been deleted succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;

    }

}
