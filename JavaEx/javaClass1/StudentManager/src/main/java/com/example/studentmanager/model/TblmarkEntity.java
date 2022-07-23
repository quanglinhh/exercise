package com.example.studentmanager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tblmark", schema = "dbo", catalog = "springboot")
public class TblmarkEntity {
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
    @Basic
    @Column(name = "studentid")
    private Long studentid;
    @Basic
    @Column(name = "subjectid")
    private Long subjectid;
    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "id")
    private TblstudentEntity tblstudentByStudentid;
    @ManyToOne
    @JoinColumn(name = "subjectid", referencedColumnName = "id")
    private TblsubjectEntity tblsubjectBySubjectid;

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

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Long getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblmarkEntity that = (TblmarkEntity) o;
        return id == that.id && Objects.equals(mark, that.mark) && Objects.equals(note, that.note) && Objects.equals(studentid, that.studentid) && Objects.equals(subjectid, that.subjectid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, note, studentid, subjectid);
    }

    public TblstudentEntity getTblstudentByStudentid() {
        return tblstudentByStudentid;
    }

    public void setTblstudentByStudentid(TblstudentEntity tblstudentByStudentid) {
        this.tblstudentByStudentid = tblstudentByStudentid;
    }

    public TblsubjectEntity getTblsubjectBySubjectid() {
        return tblsubjectBySubjectid;
    }

    public void setTblsubjectBySubjectid(TblsubjectEntity tblsubjectBySubjectid) {
        this.tblsubjectBySubjectid = tblsubjectBySubjectid;
    }
}
