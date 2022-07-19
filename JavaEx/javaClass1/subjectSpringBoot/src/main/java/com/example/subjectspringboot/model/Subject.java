package com.example.subjectspringboot.model;

import javax.persistence.*;

@Entity
@Table(name="Tblsubject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="decrtiption")
    private String  description;
    @Column(name="sem")
    private int sem;
    @Column(name="duration")
    private int duration;

    public Subject(long id, String name, String description, int sem, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sem = sem;
        this.duration = duration;
    }

    public Subject() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
