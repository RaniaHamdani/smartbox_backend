package com.qodexia.smartbox.models;

import java.util.Objects;

public class RoleUserDto {
    // SEQUENCE
    private Long id;

    // name
    private String nom;

    public RoleUserDto() {
    }

    public RoleUserDto(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUserDto role = (RoleUserDto) o;
        return Objects.equals(id, role.id) && Objects.equals(nom, role.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
