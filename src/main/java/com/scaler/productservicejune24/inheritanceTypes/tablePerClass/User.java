package com.scaler.productservicejune24.inheritanceTypes.tablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    private long id;
    private String name;
    private String email;
}

/* In Table per class, we have the parent table and child table. We don't have to
* include the parent class attributes into the child class. Once we define it as
* TABLE_PER_CLASS, it creates the parent table as well as the child table with all the
* attributes of parent table as well. */