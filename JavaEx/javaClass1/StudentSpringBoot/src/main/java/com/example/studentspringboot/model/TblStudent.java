package com.example.studentspringboot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tblstudent", schema = "dbo", catalog = "springboot")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TblStudent {

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
    @Column(name = "email")

    private String email;
    @Basic
    @Column(name = "address")

    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name="avatar")
    private String avatar;



    //    @Basic
//    @Column(name = "classid")
//    private Long classid;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "classid", referencedColumnName = "id")

//    @JsonIgnore
    private TblClass tblclassByClassid;


    public Collection<TblMark> getTblmarkById() {
        return tblmarkById;
    }

    public void setTblmarkById(Collection<TblMark> tblmarkById) {
        this.tblmarkById = tblmarkById;
    }

    @OneToMany(mappedBy = "tblstudentByStudentid",fetch =FetchType.EAGER)
//    @JsonBackReference
    private Collection<TblMark> tblmarkById;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    //    public Long getClassid() {
//        return classid;
//    }
//
//    public void setClassid(Long classid) {
//        this.classid = classid;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TblStudent that = (TblStudent) o;
        return id == that.id && Objects.equals(studentname, that.studentname) && Objects.equals(studentcode, that.studentcode) && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentname, studentcode, email, address, phone,avatar);
    }
    public TblClass getTblclassByClassid() {
        return tblclassByClassid;
    }

    public void setTblclassByClassid(TblClass tblclassByClassid) {
        this.tblclassByClassid = tblclassByClassid;
    }
}