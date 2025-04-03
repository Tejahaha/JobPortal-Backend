package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "roles")
    String roles;

    @ManyToOne
    @JoinColumn(name ="mid")
    Menus menus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Menus getMenus() {
        return menus;
    }

    public void setMenus(Menus menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roles='" + roles + '\'' +
                ", menus=" + menus +
                '}';
    }
}
