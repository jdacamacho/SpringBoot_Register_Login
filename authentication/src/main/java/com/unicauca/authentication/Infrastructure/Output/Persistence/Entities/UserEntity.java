package com.unicauca.authentication.Infrastructure.Output.Persistence.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    @Column(unique = true)
    private long numberDocument;
    @Column(length = 50)
    private String names;
    @Column(length = 50)
    private String lastNames;
    @OneToOne(mappedBy = "objUser",fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private CredentialEntity credential;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_has_roles",
        joinColumns = @JoinColumn(name = "idUser"),
        inverseJoinColumns = @JoinColumn(name = "idRole")
    )
    private List<RoleEntity> roles;

    public UserEntity(){
        this.roles = new ArrayList<>();
    }
}
