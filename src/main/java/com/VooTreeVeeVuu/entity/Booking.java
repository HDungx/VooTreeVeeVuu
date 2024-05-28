package com.VooTreeVeeVuu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
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
    //@Pattern(regexp = "^BKN[1-9]{4}$\n")
    String bookingId;
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
    double totalPrice;
    @NotBlank
    @ManyToOne @JoinColumn(name = "customer_Id")
    Customer customer;
    @NotBlank
    @ManyToOne @JoinColumn(name = "roomId")
    Room room;
    @NotBlank
    @Column(columnDefinition = "nvarchar(50)")
    @Enumerated(EnumType.STRING)
    Booking_status status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Temporal(TemporalType.DATE)
    LocalDate booking_date;

    public enum Booking_status {
        PAID, PENDING
    }
}
