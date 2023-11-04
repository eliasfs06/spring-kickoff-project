package com.eliasfs06.spring.projectkickoff.model;

public enum UserRole {

    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

}
