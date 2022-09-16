package com.example.studentspringboot.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;

    public Users(String username, String email, String encode) {
    }

    public Users() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(username, users.username) && Objects.equals(email, users.email) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name="user_id"),
                inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<Roles> roles = new HashSet<>();

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
