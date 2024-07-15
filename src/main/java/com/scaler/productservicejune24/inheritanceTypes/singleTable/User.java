package com.scaler.productservicejune24.inheritanceTypes.singleTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue(value = "0")
public class User {
    @Id
    private long id;
    private String name;
    private String email;
}

/* Single table creates only one table with all the attributes of the class. One thing to
note here is that, here we have a discriminator column that tells us what is the
user_type. To get it, we define the user_type values as well (same as enum),
We define the discriminator column, its type and also the discriminator value. The
value can be an integer or a string */