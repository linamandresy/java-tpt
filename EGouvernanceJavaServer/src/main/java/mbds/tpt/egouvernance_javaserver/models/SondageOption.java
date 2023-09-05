package mbds.tpt.egouvernance_javaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SondageOption {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    private String libelleOption,descriptionOption,idSondageMere;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelleOption() {
        return libelleOption;
    }

    public void setLibelleOption(String libelleOption) {
        this.libelleOption = libelleOption;
    }

    public String getDescriptionOption() {
        return descriptionOption;
    }

    public void setDescriptionOption(String descriptionOption) {
        this.descriptionOption = descriptionOption;
    }

    public String getIdSondageMere() {
        return idSondageMere;
    }

    public void setIdSondageMere(String idSondageMere) {
        this.idSondageMere = idSondageMere;
    }

    public SondageOption() {
    }

    public SondageOption(String libelleOption, String descriptionOption, String idSondageMere) {
        this.setLibelleOption(libelleOption);
        this.setDescriptionOption(descriptionOption);
        this.setIdSondageMere(idSondageMere);
    }


}
