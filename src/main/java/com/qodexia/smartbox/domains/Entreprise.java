package com.qodexia.smartbox.domains;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "entreprise")
public class Entreprise extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ent_seq")
    @SequenceGenerator(sequenceName = "ent_seq", allocationSize = 1, name = "ent_seq")
    private Long id;
    @Column(name = "raison_social")
    private String raisonSocial;
    @Column(name = "code")
    private String code;
    @Column(name = "code_interne")
    private String codeInterne;
    @Column(name = "siren")
    private String siren;
    @Column(name = "vat")
    private String vat;
    @Column(name = "share_capital")
    private String shareCapital;

    @OneToMany(mappedBy = "entreprise", fetch = FetchType.LAZY)
    private Set<User> users;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeInterne() {
        return codeInterne;
    }

    public void setCodeInterne(String codeInterne) {
        this.codeInterne = codeInterne;
    }

    public String getSiren() {
        return siren;
    }

    public void setSiren(String siren) {
        this.siren = siren;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getShareCapital() {
        return shareCapital;
    }

    public void setShareCapital(String shareCapital) {
        this.shareCapital = shareCapital;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
