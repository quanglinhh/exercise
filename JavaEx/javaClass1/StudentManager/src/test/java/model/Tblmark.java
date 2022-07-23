package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tblmark {
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
    private Tblstudent tblstudentByStudentid;
    @ManyToOne
    @JoinColumn(name = "subjectid", referencedColumnName = "id")
    private Tblsubject tblsubjectBySubjectid;

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
        Tblmark tblmark = (Tblmark) o;
        return id == tblmark.id && Objects.equals(mark, tblmark.mark) && Objects.equals(note, tblmark.note) && Objects.equals(studentid, tblmark.studentid) && Objects.equals(subjectid, tblmark.subjectid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, note, studentid, subjectid);
    }

    public Tblstudent getTblstudentByStudentid() {
        return tblstudentByStudentid;
    }

    public void setTblstudentByStudentid(Tblstudent tblstudentByStudentid) {
        this.tblstudentByStudentid = tblstudentByStudentid;
    }

    public Tblsubject getTblsubjectBySubjectid() {
        return tblsubjectBySubjectid;
    }

    public void setTblsubjectBySubjectid(Tblsubject tblsubjectBySubjectid) {
        this.tblsubjectBySubjectid = tblsubjectBySubjectid;
    }
}
