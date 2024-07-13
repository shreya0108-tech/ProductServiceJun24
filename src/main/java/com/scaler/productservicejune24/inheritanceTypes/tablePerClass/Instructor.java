package com.scaler.productservicejune24.inheritanceTypes.tablePerClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_instructor")
public class Instructor extends User {
    private int avgRating;
}
