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
    @Column(name = "Written")
    private Double written;
    @Basic
    @Column(name = "Practical")
    private Double practical;
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
        return id == that.id && Objects.equals(written, that.written) && Objects.equals(note, that.note) &&Objects.equals(practical, that.practical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, written, practical, note);
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

    public Double getWritten() {
        return written;
    }

    public void setWritten(Double written) {
        this.written = written;
    }

    public Double getPractical() {
        return practical;
    }

    public void setPractical(Double practical) {
        this.practical = practical;
    }
}