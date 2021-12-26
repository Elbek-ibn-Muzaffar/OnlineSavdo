package com.juniper.onlinesavdo.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String productname;

    private String size;

    private String about;

    private BigDecimal cost;

    @ManyToOne
    private FileStorage fileStorage;

    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @ManyToOne
    private Parts parts;

}
