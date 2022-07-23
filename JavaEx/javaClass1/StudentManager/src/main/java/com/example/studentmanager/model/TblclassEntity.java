package com.example.studentmanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tblclass", schema = "dbo", catalog = "springboot")
public class TblclassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "tblclassByClassid")
    @JsonManagedReference
    private Collection<TblstudentEntity> tblstudentsById;
    @OneToMany(mappedBy = "tblclassByClassid_0")
    private Collection<TblstudentEntity> tblstudentsById_0;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblclassEntity that = (TblclassEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, note);
    }

    public Collection<TblstudentEntity> getTblstudentsById() {
        return tblstudentsById;
    }

    public void setTblstudentsById(Collection<TblstudentEntity> tblstudentsById) {
        this.tblstudentsById = tblstudentsById;
    }

    public Collection<TblstudentEntity> getTblstudentsById_0() {
        return tblstudentsById_0;
    }

    public void setTblstudentsById_0(Collection<TblstudentEntity> tblstudentsById_0) {
        this.tblstudentsById_0 = tblstudentsById_0;
    }
}
