package com.example.springboot.model;

import javax.persistence.*;

@Entity
@Table(name ="Tbluser")
public class TblUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="uname")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;

    public TblUser( String name, String email, String phone) {

        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public TblUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
