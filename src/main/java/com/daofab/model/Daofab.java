package com.daofab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

/*
Author : shubham
*/


/**
 * This is a base class by which we can Reduce
 * Code Repition
 */
@Entity
public class Daofab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
