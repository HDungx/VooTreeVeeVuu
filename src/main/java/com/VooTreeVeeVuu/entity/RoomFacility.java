package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "RoomFacilities")
public class RoomFacility {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer id;
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "roomId")
	Room room;
	@NotBlank
	@ManyToOne
	@JoinColumn (name = "facId")
	Facility facility;
}
