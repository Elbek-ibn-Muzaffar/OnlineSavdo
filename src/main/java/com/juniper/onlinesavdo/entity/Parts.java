package com.juniper.onlinesavdo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String partname;

    @ManyToOne
    private FileStorage fileStorage;

}
