package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tblclass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "tblclassByClassid")
    private Collection<Tblstudent> tblstudentsById;
    @OneToMany(mappedBy = "tblclassByClassid_0")
    private Collection<Tblstudent> tblstudentsById_0;

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
        Tblclass tblclass = (Tblclass) o;
        return id == tblclass.id && Objects.equals(name, tblclass.name) && Objects.equals(note, tblclass.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, note);
    }

    public Collection<Tblstudent> getTblstudentsById() {
        return tblstudentsById;
    }

    public void setTblstudentsById(Collection<Tblstudent> tblstudentsById) {
        this.tblstudentsById = tblstudentsById;
    }

    public Collection<Tblstudent> getTblstudentsById_0() {
        return tblstudentsById_0;
    }

    public void setTblstudentsById_0(Collection<Tblstudent> tblstudentsById_0) {
        this.tblstudentsById_0 = tblstudentsById_0;
    }
}
