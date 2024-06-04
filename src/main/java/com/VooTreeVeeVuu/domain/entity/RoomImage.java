package com.VooTreeVeeVuu.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "room_images")
public class RoomImage {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	@Pattern (regexp = ".*\\.(jpg|png)$")
	String path;
	@ManyToOne
	@JoinColumn (name = "roomId")
	Room room;
}
