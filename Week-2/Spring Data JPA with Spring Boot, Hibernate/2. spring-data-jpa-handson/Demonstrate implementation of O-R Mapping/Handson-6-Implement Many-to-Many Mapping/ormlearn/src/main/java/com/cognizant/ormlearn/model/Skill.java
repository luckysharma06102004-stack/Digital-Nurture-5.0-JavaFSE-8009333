package com.cognizant.ormlearn.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @Column(name = "sk_id")
    private int id;

    @Column(name = "sk_name")
    private String name;

    public Skill() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}