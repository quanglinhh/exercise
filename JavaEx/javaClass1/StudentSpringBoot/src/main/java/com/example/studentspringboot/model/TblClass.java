package com.example.studentspringboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tblclass", schema = "dbo", catalog = "springboot")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TblClass {

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
    @OneToMany(mappedBy = "tblclassByClassid",fetch =FetchType.EAGER)
//    @JsonBackReference
    private Collection<TblStudent> tblstudentsById;

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
        TblClass that = (TblClass) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, note);
    }


    public Collection<TblStudent> getTblstudentsById() {
        return tblstudentsById;
    }

    public void setTblstudentsById(Collection<TblStudent> tblstudentsById) {
        this.tblstudentsById = tblstudentsById;
    }
}