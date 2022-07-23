package com.example.studentspringboot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tblsubject", schema = "dbo", catalog = "springboot")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TblSubject{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "decrtiption")
    private String description;
    @Basic
    @Column(name = "duration")
    private Integer duration;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "sem")
    private Integer sem;
    @OneToMany(mappedBy = "tblsubjectBySubjectid")
    @JsonIgnore
    private Collection<TblMark> tblmarksById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSem() {
        return sem;
    }

    public void setSem(Integer sem) {
        this.sem = sem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblSubject that = (TblSubject) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(duration, that.duration) && Objects.equals(name, that.name) && Objects.equals(sem, that.sem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, duration, name, sem);
    }

    public Collection<TblMark> getTblmarksById() {
        return tblmarksById;
    }

    public void setTblmarksById(Collection<TblMark> tblmarksById) {
        this.tblmarksById = tblmarksById;
    }
}
