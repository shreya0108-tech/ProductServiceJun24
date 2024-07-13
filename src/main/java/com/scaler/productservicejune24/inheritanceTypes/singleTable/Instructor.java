package com.scaler.productservicejune24.inheritanceTypes.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_instructor")
@DiscriminatorValue(value = "3")
public class Instructor extends User {
    private int avgRating;
}
