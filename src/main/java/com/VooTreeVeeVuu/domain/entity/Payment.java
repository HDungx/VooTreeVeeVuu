package com.VooTreeVeeVuu.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txn_ref", nullable = false, unique = true)
    private String txnRef;

    @Column(name = "amount", nullable = false)
    private long amount;

//    @Column(name = "bank_code")
//    private String bankCode;
//
//    @Column(name = "language")
//    private String language;

//    @Column(name = "order_info")
//    private String orderInfo;

    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

//    @Column(name = "expire_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date expireDate;

//    @Column(name = "ip_addr", nullable = false)
//    private String ipAddr;

//    @Column(name = "payment_url", nullable = false, columnDefinition = "varchar(500)")
//    private String paymentUrl;

    // Linking Payment to Booking and User
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
