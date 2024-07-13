package com.scaler.productservicejune24.inheritanceTypes.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "st_student")
@DiscriminatorValue(value = "1")
public class Student extends User {
    private int psp;
}
