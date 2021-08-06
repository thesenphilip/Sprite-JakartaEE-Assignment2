/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.base0001.entity;

import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thes0001
 */
@Entity
@XmlRootElement
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private long id;
    @Column
    private String userid;
    @Column
    private String password;
    @Column
    private String groupName;

    public AppUser() {}

    public AppUser(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getuserid() {
        return userid;
    }

    public void setuserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return "";
    }

    public void setPassword(String password) {
        if (password != null) {
            Instance < ? extends PasswordHash > instance = CDI.current().select(Pbkdf2PasswordHash.class);
            PasswordHash passwordHash = instance.get();
            passwordHash.initialize(new HashMap < String, String > ());
            String passwordEntry = password;
            passwordEntry = passwordHash.generate(passwordEntry.toCharArray());
            this.password = passwordEntry;
        }
    }

    public String getgroupName() {
        return groupName;
    }

    public void setgroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        return !((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid)));
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject4.Contact[ id=" + userid + " ]";
    }

}