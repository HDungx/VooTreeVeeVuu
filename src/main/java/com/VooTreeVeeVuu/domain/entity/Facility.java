package com.VooTreeVeeVuu.domain.entity;

import com.VooTreeVeeVuu.domain.utils.Fac_Type;
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
    private Integer facId;
    @Column(name = "FacilityType")
    @Enumerated(EnumType.STRING)
    private Fac_Type facType;
    @NotBlank
    @Column(columnDefinition = "nvarchar(200)", name = "FacilityName")
    private String facName;
    private String facIcon;
    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    List<HotelFacility> hotelFacilities;
    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    List<RoomFacility> roomFacilities;
}