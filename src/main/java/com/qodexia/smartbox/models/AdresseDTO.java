package com.qodexia.smartbox.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AdresseDTO {

    private Long id;

    @NotBlank(message = "country should'n be null")
    private String country;

    @NotBlank(message = "state should'n be null")
    private String state;

    @NotBlank(message = "city should'n be null")
    private String city;

    @NotBlank(message = "street should'n be null")
    private String Street;

    @NotNull(message = "number should'n be null")
    private Integer number;

    @NotBlank(message = "zip code should'n be null")
    private String zipCode;

    private String batiment;

    private String etage;

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

    private String numBureau;

    @NotNull(message = "adress should belong to an actor")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

}
