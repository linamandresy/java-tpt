package mbds.tpt.egouvernance_javaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Resources {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    private String resourceName;
    private String idTypeResource;

    public Resources() {
    }

    public Resources(String resourceName, String idTypeResource) {
        this.setResourceName(resourceName);
        this.setIdTypeResource(idTypeResource);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getIdTypeResource() {
        return idTypeResource;
    }

    public void setIdTypeResource(String idTypeResource) {
        this.idTypeResource = idTypeResource;
    }


}
