package com.amz.scm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private String password;

    @Column(length = 100)
    private String about;

    private String profilePic;
    private String phoneNumber;
    private boolean enabled;
    private boolean emailVerified;
    private boolean phoneNumberVerified;

    @Enumerated(value = EnumType.STRING)
    private Provider provider = Provider.SELF;
    private String providerId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<>();






}
