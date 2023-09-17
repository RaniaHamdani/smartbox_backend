package com.qodexia.smartbox.domains;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_user")
public class RoleUser extends AuditModel {
    // SEQUENCE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name
    @Column(name = "nom")
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public RoleUser() {
    }

    public RoleUser(Long id, String nom) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUser role = (RoleUser) o;
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
