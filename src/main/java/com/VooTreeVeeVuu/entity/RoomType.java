package com.VooTreeVeeVuu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name= "room_type")
public class RoomType {
    @Id
    String typeId;
    @NotBlank
    @Column (columnDefinition = "nvarchar(50)")
    String typeName;
    @JsonIgnore
    @OneToMany (mappedBy = "roomType")
    List<Room> rooms;
}
