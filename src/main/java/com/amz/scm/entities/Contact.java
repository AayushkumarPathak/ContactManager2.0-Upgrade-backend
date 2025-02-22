package com.amz.scm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contact {

    @Id
    private String id;

    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String picture;

    @Column(length = 1000)
    private String description;

    private boolean fav = false;
    private String website;
    private String linkedin;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();

    private String cloudinaryImagePublicId;


}
