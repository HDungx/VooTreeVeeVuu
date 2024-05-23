package com.VooTreeVeeVuu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Facilities")
public class Facility {
    String fac_Id;
    String fac_Type;
    String fac_Name;
}
