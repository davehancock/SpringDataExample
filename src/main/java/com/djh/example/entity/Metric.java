package com.djh.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author David Hancock
 */
@Entity
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
