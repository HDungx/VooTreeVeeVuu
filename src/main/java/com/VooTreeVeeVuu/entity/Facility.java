package com.VooTreeVeeVuu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Facilities")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer facId;
    @Column(name = "FacilityType")
    @Enumerated(EnumType.STRING)
    Fac_Type facType;
    @NotBlank
    @Column(columnDefinition = "nvarchar(255)", name = "FacilityName")
    String facName;
    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    List<HotelFacility> hotelFacilities;
    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    List<RoomFacility> roomFacilities;

    public enum Fac_Type {
        Hotel, Room
    }
}