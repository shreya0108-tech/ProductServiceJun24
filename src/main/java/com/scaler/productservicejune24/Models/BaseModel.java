package com.scaler.productservicejune24.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id     //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //auto-increment
    private long id;
}

/*
* In this, there is no table created for parent class, and the child tables are only
* created. The child table will have its own attributes and the attributes of the
* parent class.
*/