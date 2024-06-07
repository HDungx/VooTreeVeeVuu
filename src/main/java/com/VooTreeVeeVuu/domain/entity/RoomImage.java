package com.VooTreeVeeVuu.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private Long id;

	@Pattern (regexp = ".*\\.(jpg|png)$")
	private String path;

	@JsonIgnore
	@ManyToOne
	@JoinColumn (name = "roomId")
	Room room;
}
