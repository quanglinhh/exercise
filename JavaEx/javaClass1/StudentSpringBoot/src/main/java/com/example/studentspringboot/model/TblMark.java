package com.example.studentspringboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tblmark", schema = "dbo", catalog = "springboot")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TblMark {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "mark")
    private Double mark;
    @Basic
    @Column(name = "note")
    private String note;
//    @Basic
//    @Column(name = "studentid")
//    private Long studentid;
//    @Basic
//    @Column(name = "subjectid")
//    private Long subjectid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentid", referencedColumnName = "id")
//    @JsonManagedReference
    private TblStudent tblstudentByStudentid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subjectid", referencedColumnName = "id")
//    @JsonManagedReference
    private TblSubject tblsubjectBySubjectid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//    public Long getStudentid() {
//        return studentid;
//    }
//
//    public void setStudentid(Long studentid) {
//        this.studentid = studentid;
//    }
//
//    public Long getSubjectid() {
//        return subjectid;
//    }
//
//    public void setSubjectid(Long subjectid) {
//        this.subjectid = subjectid;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblMark that = (TblMark) o;
        return id == that.id && Objects.equals(mark, that.mark) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, note);
    }

    public TblStudent getTblstudentByStudentid() {
        return tblstudentByStudentid;
    }

    public void setTblstudentByStudentid(TblStudent tblstudentByStudentid) {
        this.tblstudentByStudentid = tblstudentByStudentid;
    }

    public TblSubject getTblsubjectBySubjectid() {
        return tblsubjectBySubjectid;
    }

    public void setTblsubjectBySubjectid(TblSubject tblsubjectBySubjectid) {
        this.tblsubjectBySubjectid = tblsubjectBySubjectid;
    }
}