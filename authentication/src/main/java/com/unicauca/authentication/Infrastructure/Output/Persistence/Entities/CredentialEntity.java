package com.unicauca.authentication.Infrastructure.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Credentials")
@Data
@AllArgsConstructor
public class CredentialEntity {
    @Id
    private long idCredential;
    @Column(unique = true,length = 30)
    private String userName;
    @Column(length = 400)
    private String password;
    @OneToOne
    @MapsId
    @JoinColumn(name = "idUser")
    private UserEntity objUser;

    public CredentialEntity(){

    }
}
