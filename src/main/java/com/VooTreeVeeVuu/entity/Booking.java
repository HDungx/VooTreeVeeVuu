package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bookings")
public class Booking {
    @Id
    String booking_Id;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    LocalDate checkInDate;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    LocalDate checkOutDate;
    @NotNull
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    double total_price;
    @NotBlank
    @ManyToOne @JoinColumn(name = "customer_Id")
    Customer customer;
    @NotBlank
    @ManyToOne @JoinColumn(name = "roomId")
    Room room;
    @NotBlank
    @Column(columnDefinition = "nvarchar(50)")
    Booking_status status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    LocalDate booking_date;

    public enum Booking_status {
        PAID, PENDING
    }
}
