package com.juniper.onlinesavdo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Region {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String regionname;
}
