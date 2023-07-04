package com.daofab.model;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

/*
Author : shubham
*/


/**
 * This is a base class by which we can Reduce
 * Code Repition
 */
@MappedSuperclass
@DynamicUpdate(value = true)
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
