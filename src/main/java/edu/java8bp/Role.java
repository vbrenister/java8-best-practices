package edu.java8bp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.EnumSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String name;
    private Set<Permission> permissions = EnumSet.noneOf(Permission.class);
}
