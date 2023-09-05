package mbds.tpt.egouvernance_javaserver.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SondageMere {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    private String libelleSondage;
    private String descriptionSondage;
    private String author;
    private Date expirationDate;

    public SondageMere() {}

    public SondageMere(String libelleSondage, String descriptionSondage, String author, Date expirationDate) {
        this.setLibelleSondage(libelleSondage);
        this.setDescriptionSondage(descriptionSondage);
        this.setAuthor(author);
        this.setExpirationDate(expirationDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelleSondage() {
        return libelleSondage;
    }

    public void setLibelleSondage(String libelleSondage) {
        this.libelleSondage = libelleSondage;
    }

    public String getDescriptionSondage() {
        return descriptionSondage;
    }

    public void setDescriptionSondage(String descriptionSondage) {
        this.descriptionSondage = descriptionSondage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }    
}
