package com.VooTreeVeeVuu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    String typeId;//Hotel, Motel, Resort, Homestay, Apartment
    @NotBlank
    @Column(columnDefinition = "nvarchar(50)")
    String typeName;//Hotel, Motel, Resort, Homestay, Apartment
    @JsonIgnore
    @OneToMany( mappedBy = "accommodationType")
    List<Hotel> hotels;
}
