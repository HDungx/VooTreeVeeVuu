package com.VooTreeVeeVuu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    String fac_Id;
    String fac_Type;
    String fac_Name;
    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    List<HotelFacility> hotelFacilities;
    @JsonIgnore
    @OneToMany(mappedBy = "facility")
    List<RoomFacility> roomFacilities;
}
