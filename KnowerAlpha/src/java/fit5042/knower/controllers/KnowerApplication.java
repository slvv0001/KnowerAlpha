package fit5042.knower.controllers;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import fit5042.knower.mbeans.KnowerManagedBean;
import javax.inject.Named;
import fit5042.knower.repository.entities.Knower;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * The class is a demonstration of how the application scope works. You can
 * change this scope.
 *
 * @author Guan
 */
@Named(value = "knowerApplication")
@ApplicationScoped

public class KnowerApplication {

    //dependency injection of managed bean here so that we can use its methods
    @ManagedProperty(value = "#{knowerManagedBean}")
    KnowerManagedBean knowerManagedBean;

    private ArrayList<Knower> properties;

    private boolean showForm = true;

    public boolean isShowForm() {
        return showForm;
    }

    // Add some property data from db to app 
    public KnowerApplication() throws Exception {
        properties = new ArrayList<>();

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        knowerManagedBean = (KnowerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "knowerManagedBean");

        //get properties from db 
        updatePropertyList();
    }

    public ArrayList<Knower> getProperties() {
        return properties;
    }

    private void setProperties(ArrayList<Knower> newProperties) {
        this.properties = newProperties;
    }

    //when loading, and after adding or deleting, the property list needs to be refreshed
    //this method is for that purpose
    public void updatePropertyList() {
        if (properties != null && properties.size() > 0)
        {
            
        }
        else
        {
            properties.clear();

            for (fit5042.knower.repository.entities.Knower property : knowerManagedBean.getAllProperties())
            {
                properties.add(property);
            }

            setProperties(properties);
        }
    }

    public void searchPropertyById(int propertyId) {
        properties.clear();

        properties.add(knowerManagedBean.searchPropertyById(propertyId));
    }

    public void searchPropertyByPopularity(double popularity) {
        properties.clear();

        for (fit5042.knower.repository.entities.Knower property : knowerManagedBean.searchPropertyByPopularity(popularity)) {
            properties.add(property);
        }

        setProperties(properties);
    }
    
    public void searchAll()
    {
        properties.clear();
        
        for (fit5042.knower.repository.entities.Knower property : knowerManagedBean.getAllProperties())
        {
            properties.add(property);
        }
        
        setProperties(properties);
    }
}
