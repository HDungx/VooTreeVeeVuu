package com.VooTreeVeeVuu.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="accommodation_type")
public class AccommodationType {
    @Id
    String type_Id;
    String type_Name;
    @OneToMany( mappedBy = "accommodationType")
    List<Hotel> hotels;
}
