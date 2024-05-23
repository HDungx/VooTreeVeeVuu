package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "room_images")
public class RoomImage {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    String path;
    @ManyToOne @JoinColumn(name="room_Id")
    Room room;

}
