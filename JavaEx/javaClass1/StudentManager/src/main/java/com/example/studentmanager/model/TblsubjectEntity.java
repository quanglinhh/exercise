package com.example.studentmanager.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tblsubject", schema = "dbo", catalog = "springboot")
public class TblsubjectEntity {
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
    private Collection<TblmarkEntity> tblmarksById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String decrtiption) {
        this.description = decrtiption;
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
        TblsubjectEntity that = (TblsubjectEntity) o;
        return id == that.id && Objects.equals(description, that.description) && Objects.equals(duration, that.duration) && Objects.equals(name, that.name) && Objects.equals(sem, that.sem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, duration, name, sem);
    }

    public Collection<TblmarkEntity> getTblmarksById() {
        return tblmarksById;
    }

    public void setTblmarksById(Collection<TblmarkEntity> tblmarksById) {
        this.tblmarksById = tblmarksById;
    }
}
