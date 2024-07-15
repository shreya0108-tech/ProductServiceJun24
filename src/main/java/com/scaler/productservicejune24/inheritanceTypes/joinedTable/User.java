package com.scaler.productservicejune24.inheritanceTypes.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    private long id;
    private String name;
    private String email;
}

/*
* In Joined table, parent class will have its attributes and child class will have
* different attributes, now the child table will be having the parent table attributes
* as well but they will be referred via Foreign Key by the child class.
* */