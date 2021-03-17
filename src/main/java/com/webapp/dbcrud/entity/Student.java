package com.webapp.dbcrud.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private Long sid;

    @Column(name = "s_firstname")
    private String sfirstname;

    @Column(name = "s_lastname")
    private String slastname;

    @Column(name = "s_dob")
    private Date sdob;

    @Column(name = "s_street")
    private String sstreet;

    @Column(name = "s_postcode")
    private String spostcode;

    @Column(name = "s_country")
    private String scountry;

    public Student(Long sid,
                   String sfirstname,
                   String slastname,
                   Date sdob,
                   String sstreet,
                   String spostcode,
                   String scountry) {
        this.sid = sid;
        this.sfirstname = sfirstname;
        this.slastname = slastname;
        this.sdob = sdob;
        this.sstreet = sstreet;
        this.spostcode = spostcode;
        this.scountry = scountry;
    }

    public Student(){}

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSfirstname() {
        return sfirstname;
    }

    public void setSfirstname(String sfirstname) {
        this.sfirstname = sfirstname;
    }

    public String getSlastname() {
        return slastname;
    }

    public void setSlastname(String slastname) {
        this.slastname = slastname;
    }

    public Date getSdob() {
        return sdob;
    }

    public void setSdob(Date sdob) {
        this.sdob = sdob;
    }

    public String getSstreet() {
        return sstreet;
    }

    public void setSstreet(String sstreet) {
        this.sstreet = sstreet;
    }

    public String getSpostcode() {
        return spostcode;
    }

    public void setSpostcode(String spostcode) {
        this.spostcode = spostcode;
    }

    public String getScountry() {
        return scountry;
    }

    public void setScountry(String scountry) {
        this.scountry = scountry;
    }
}
