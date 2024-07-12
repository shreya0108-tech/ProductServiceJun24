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
