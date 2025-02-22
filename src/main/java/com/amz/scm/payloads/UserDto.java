package com.amz.scm.payloads;

import java.util.ArrayList;
import java.util.List;

import com.amz.scm.entities.Contact;
import com.amz.scm.entities.Provider;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {
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

    private List<Contact> contacts = new ArrayList<>();
}
