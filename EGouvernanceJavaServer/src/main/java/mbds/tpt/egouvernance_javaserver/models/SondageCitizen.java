package mbds.tpt.egouvernance_javaserver.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SondageCitizen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String idSondage;
    private String idOption;
    private String idUser;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdSondage() {
        return idSondage;
    }
    public void setIdSondage(String idSondage) {
        this.idSondage = idSondage;
    }
    public String getIdOption() {
        return idOption;
    }
    public void setIdOption(String idOption) {
        this.idOption = idOption;
    }
    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public SondageCitizen(String idSondage, String idOption, String idUser) {
        this.setIdOption(idOption);
        this.setIdSondage(idSondage);
        this.setIdUser(idUser);
    }   
}
