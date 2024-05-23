package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RoomFacilities")
public class RoomFacility {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne @JoinColumn(name = "roomId")
    Room room;
    @ManyToOne @JoinColumn(name = "fac_Id")
    Facility facility;
}
