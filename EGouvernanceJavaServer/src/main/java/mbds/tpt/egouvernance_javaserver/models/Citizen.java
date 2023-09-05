package mbds.tpt.egouvernance_javaserver.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    private String cinNumber;
    private Date birthDate;
    private String idFather;
    private String idMother;

    public Citizen(Date birthDate, String cinNumber, String firstName, String idFather, String idMother, String lastName) {
        this.setBirthDate( birthDate);
        this.setCinNumber( cinNumber);
        this.setFirstName( firstName);
        this.setIdFather(idFather);
        this.setIdMother(idMother);
        this.setLastName(lastName);
    }

    public Citizen(){}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCinNumber() {
        return cinNumber;
    }

    public void setCinNumber(String cinNumber) {
        this.cinNumber = cinNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdFather() {
        return idFather;
    }

    public void setIdFather(String idFather) {
        this.idFather = idFather;
    }

    public String getIdMother() {
        return idMother;
    }

    public void setIdMother(String idMother) {
        this.idMother = idMother;
    }

    @Override
    public String toString() {
        return this.getFirstName()+ " " +this.getLastName();
    }
    
}
