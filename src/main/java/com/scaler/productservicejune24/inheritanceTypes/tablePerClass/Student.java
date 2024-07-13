package com.scaler.productservicejune24.inheritanceTypes.tablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "tpc_student")
public class Student extends User {
    private int psp;
}
