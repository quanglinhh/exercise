package model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Tblstudent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
    @Column(name = "classid")
    private Long classid;
    @OneToMany(mappedBy = "tblstudentByStudentid")
    private Collection<Tblmark> tblmarksById;
    @ManyToOne
    @JoinColumn(name = "classid", referencedColumnName = "id")
    private Tblclass tblclassByClassid;
    @ManyToOne
    @JoinColumn(name = "classid", referencedColumnName = "id")
    private Tblclass tblclassByClassid_0;

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

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tblstudent that = (Tblstudent) o;
        return id == that.id && Objects.equals(studentname, that.studentname) && Objects.equals(studentcode, that.studentcode) && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(classid, that.classid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentname, studentcode, email, address, phone, classid);
    }

    public Collection<Tblmark> getTblmarksById() {
        return tblmarksById;
    }

    public void setTblmarksById(Collection<Tblmark> tblmarksById) {
        this.tblmarksById = tblmarksById;
    }

    public Tblclass getTblclassByClassid() {
        return tblclassByClassid;
    }

    public void setTblclassByClassid(Tblclass tblclassByClassid) {
        this.tblclassByClassid = tblclassByClassid;
    }

    public Tblclass getTblclassByClassid_0() {
        return tblclassByClassid_0;
    }

    public void setTblclassByClassid_0(Tblclass tblclassByClassid_0) {
        this.tblclassByClassid_0 = tblclassByClassid_0;
    }
}
