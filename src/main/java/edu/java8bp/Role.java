package edu.java8bp;


import java.util.EnumSet;
import java.util.Set;

public class Role {
    private String name;
    private Set<Permission> permissions = EnumSet.noneOf(Permission.class);

    public Role(String name, Set<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public Role() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
