package mbds.tpt.egouvernance_javaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * TypeResource
 */
@Entity
public class TypeResource {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    private String typeResourceName;

    public TypeResource() {
    }

    public TypeResource(String typeResourceName) {
        this.setTypeResourceName(typeResourceName);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeResourceName() {
        return typeResourceName;
    }

    public void setTypeResourceName(String typeResourceName) {
        this.typeResourceName = typeResourceName;
    }
    
    
}