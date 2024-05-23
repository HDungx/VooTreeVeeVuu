package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bookings")
public class Booking {
    @Id
    String booking_Id;
    @Temporal(TemporalType.DATE)
    LocalDate checkInDate;
    @Temporal(TemporalType.DATE)
    LocalDate checkOutDate;
    double total_price;
    @ManyToOne @JoinColumn(name = "customer_Id")
    Customer customer;
    @ManyToOne @JoinColumn(name = "roomId")
    Room room;
    String status;
    @Temporal(TemporalType.DATE)
    LocalDate booking_date;
}
