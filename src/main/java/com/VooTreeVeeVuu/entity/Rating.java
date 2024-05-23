package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    int rate;
    String comment;
    @ManyToOne @JoinColumn(name ="customer_Id")
    Customer customer;
    @ManyToOne @JoinColumn(name= "hotel_Id")
    Hotel hotel;

}
