package com.example.studentspringboot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tblstudent", schema = "dbo", catalog = "SpringBoot")
public class TblstudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "studentname")
    private String studentname;
    @Basic
    @Column(name = "studentcode")
    private String studentcode;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;



    @ManyToOne
    @JoinColumn(name = "classid", referencedColumnName = "id")
    private TblclassEntity tblclassByClassid;




//    @Basic
//    @Column(name = "classid")
//    private Long classid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblstudentEntity that = (TblstudentEntity) o;
        return id == that.id && Objects.equals(studentname, that.studentname) && Objects.equals(studentcode, that.studentcode) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentname, studentcode, address, email, phone);
    }

    public TblclassEntity getTblclassByClassid() {
        return tblclassByClassid;
    }

    public void setTblclassByClassid(TblclassEntity tblclassByClassid) {
        this.tblclassByClassid = tblclassByClassid;
    }



//    public Long getClassid() {
//        return classid;
//    }
//
//    public void setClassid(Long classid) {
//        this.classid = classid;
//    }
}
