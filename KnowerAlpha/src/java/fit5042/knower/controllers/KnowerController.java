package fit5042.knower.controllers;

import javax.el.ELContext;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Messom
 * @author Guan
 */
@Named(value = "knowerController")
@RequestScoped
public class KnowerController {

    private int propertyId; //this propertyId is the index, don't confuse with the Knower Id

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }
    private fit5042.knower.repository.entities.Knower property;

    public KnowerController() {
        // Assign property identifier via GET param 
        //this propertyID is the index, don't confuse with the Knower Id
        propertyId = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("propertyID"));
        // Assign property based on the id provided 
        property = getProperty();
    }

    public fit5042.knower.repository.entities.Knower getProperty() {
        if (property == null) {
            // Get application context bean KnowerApplication 
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            KnowerApplication app
                    = (KnowerApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "knowerApplication");
            // -1 to propertyId since we +1 in JSF (to always have positive property id!) 
            return app.getProperties().get(--propertyId); //this propertyId is the index, don't confuse with the Knower Id
        }
        return property;
    }
}
