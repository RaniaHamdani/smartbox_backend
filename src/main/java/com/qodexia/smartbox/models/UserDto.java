package com.qodexia.smartbox.models;

import com.qodexia.smartbox.domains.User;
import com.qodexia.smartbox.enums.Sexe;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class UserDto {

    private Long id;
    private String username;

    @Email(message = "adresse mail n'est pas valide")
    private String email;

    private String password;

    @NotBlank(message = "first name invalid")
    private String nom;

    @NotBlank(message = "last name invalid")
    private String prenom;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String dateNaissance;
    private Sexe sexe;

    private String profilPicUrl;

    private Set<RoleUserDto> roles;

    private AdresseDTO adresse;

    private EntrepriseDto entrepriseDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getProfilPicUrl() {
        return profilPicUrl;
    }

    public void setProfilPicUrl(String profilPicUrl) {
        this.profilPicUrl = profilPicUrl;
    }

    public Set<RoleUserDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleUserDto> roles) {
        this.roles = roles;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }

    public EntrepriseDto getEntrepriseDto() {
        return entrepriseDto;
    }

    public void setEntrepriseDto(EntrepriseDto entrepriseDto) {
        this.entrepriseDto = entrepriseDto;
    }
}
