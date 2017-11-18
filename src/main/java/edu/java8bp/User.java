package edu.java8bp;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String name;
    private int age;
    private Set<Role> roles = new HashSet<>();

    public User(Long id, String name, int age, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.roles = roles;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
