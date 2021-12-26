package com.juniper.onlinesavdo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userlar")
public class Users {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;


    private String fullname;

    private String password;

    @NotNull
    @Column(unique = true)
    private String phonenumber;


    private String place;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createdAt;


    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @ManyToOne
    private Region region;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}
    )
    private Set<Roles> roles;
}
