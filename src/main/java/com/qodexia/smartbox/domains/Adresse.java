package com.qodexia.smartbox.domains;

/**
 * @author RadhCHbinou created on 09/juin/2023 10:33
 **/

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "adresse")
public class Adresse extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ")
    @SequenceGenerator(sequenceName = "address_seq", allocationSize = 1, name = "ADDRESS_SEQ")
    private Long id;

    @Column(name = "pays")
    @NotBlank(message = "country should'n be null")
    private String country;

    @Column(name = "gouvernorat")
    @NotBlank(message = "state should'n be null")
    private String state;

    @Column(name = "ville")
    @NotBlank(message = "city should'n be null")
    private String city;

    @Column(name = "rue")
    @NotBlank(message = "street should'n be null")
    private String Street;

    @Column(name = "numero")
    @NotNull(message = "number should'n be null")
    private Integer number;

    @Column(name = "zip_code")
    @NotBlank(message = "zip code should'n be null")
    private String zipCode;



    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public String getNumBureau() {
        return numBureau;
    }

    public void setNumBureau(String numBureau) {
        this.numBureau = numBureau;
    }

    @Column(name = "batiment")
    private String batiment;
    @Column(name = "etage")
    private String etage;
    @Column(name = "num_bureau")
    private String numBureau;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adresse", fetch = FetchType.LAZY)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    // hackcode + equalss + tostring
}
