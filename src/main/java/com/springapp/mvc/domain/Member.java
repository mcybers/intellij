package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by n on 2015-12-21.
 */
@Entity
@Table(name="MEMBER")
public class Member {
    @Id
    @Column(name="ID")
    private String id;

    @Column
    private String name;

    @Lob
    @Column(name="PASSWD")
    private byte[] password;

    @Lob
    @Column(name="SALT")
    private byte[] salt;

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public Member() {
    }

    public Member(String id, String name, byte[] password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }
}
