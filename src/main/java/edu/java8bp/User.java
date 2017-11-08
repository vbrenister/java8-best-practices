package edu.java8bp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<Role> roles = new HashSet<>();
}
