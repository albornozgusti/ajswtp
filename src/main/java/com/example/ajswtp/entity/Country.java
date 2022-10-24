package com.example.ajswtp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {

    @Id
    private String code;

    @Column
    private String name;

    @Column
    private String continent;

}
