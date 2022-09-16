package com.example.rent.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "address")
    private byte[] address;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "age")
    private Integer age;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Contract> contractsById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Room> roomsById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<UserRole> userRolesById;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private Users usersById;
    @OneToOne(mappedBy = "usersById")
    private Users usersById_0;

    public Users(String username, String email, String encode) {
    }

    public Users() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public byte[] getAddress() {
        return address;
    }

    public void setAddress(byte[] address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(fullname, users.fullname) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Arrays.equals(address, users.address) && Objects.equals(username, users.username) && Objects.equals(image, users.image) && Objects.equals(phone, users.phone) && Objects.equals(age, users.age);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, fullname, email, password, username, image, phone, age);
        result = 31 * result + Arrays.hashCode(address);
        return result;
    }

    public Collection<Contract> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<Contract> contractsById) {
        this.contractsById = contractsById;
    }

    public Collection<Room> getRoomsById() {
        return roomsById;
    }

    public void setRoomsById(Collection<Room> roomsById) {
        this.roomsById = roomsById;
    }

    public Collection<UserRole> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRole> userRolesById) {
        this.userRolesById = userRolesById;
    }

    public Users getUsersById() {
        return usersById;
    }

    public void setUsersById(Users usersById) {
        this.usersById = usersById;
    }

    public Users getUsersById_0() {
        return usersById_0;
    }

    public void setUsersById_0(Users usersById_0) {
        this.usersById_0 = usersById_0;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
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
