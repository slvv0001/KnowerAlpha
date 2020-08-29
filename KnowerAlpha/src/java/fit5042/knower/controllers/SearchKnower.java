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
@Named("searchKnower")
public class SearchKnower {
    private boolean showForm = true;

    private Knower property;

    KnowerApplication app;

    private int searchByInt;
    private double searchByDouble;

    public KnowerApplication getApp() {
        return app;
    }

    public void setApp(KnowerApplication app) {
        this.app = app;
    }
    private double searchByPopularity;

    public double getSearchByDouble() {
        return searchByDouble;
    }

    public void setSearchByDouble(double searchByDouble) {
        this.searchByDouble = searchByDouble;
    }

    public int getSearchByInt() {
        return searchByInt;
    }

    public void setSearchByInt(int searchByInt) {
        this.searchByInt = searchByInt;
    }

    public double getSearchByPopularity() {
        return searchByPopularity;
    }

    public void setSearchByPopularity(double searchByPopularity) {
        this.searchByPopularity = searchByPopularity;
    }

    public void setProperty(Knower property) {
        this.property = property;
    }

    public Knower getProperty() {
        return property;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public SearchKnower() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (KnowerApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "knowerApplication");

        app.updatePropertyList();

    }

    /**
     * Normally each page should have a backing bean but you can actually do it
     * any how you want.
     *
     * @param property Id
     */
    public void searchPropertyById(int propertyId) {
        try {
            //search this property then refresh the list in KnowerApplication bean
            app.searchPropertyById(propertyId);
        } catch (Exception ex) {

        }
        showForm = true;

    }

    public void searchPropertyByPopularity(double popularity) {
        try {
            //search this property from db via EJB
            app.searchPropertyByPopularity(popularity);
        } catch (Exception ex) {

        }
        showForm = true;
    }

    public void searchAll() {
        try {
            //return all properties from db via EJB
            app.searchAll();
        } catch (Exception ex) {

        }
        showForm = true;
    }

}
