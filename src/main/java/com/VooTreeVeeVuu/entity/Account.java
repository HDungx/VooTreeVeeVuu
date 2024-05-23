package com.VooTreeVeeVuu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")

public class Account {
    @Id
    String username;
    String email;
    String password;
    String role;
    @JsonIgnore
    @OneToOne @JoinColumn(name = "customer_Id")
    Customer customer;
    @JsonIgnore
    @OneToOne @JoinColumn(name = "partner_Id")
    Partner partner;
    @JsonIgnore
    @OneToOne @JoinColumn(name = "staff_Id")
    Staff staff;
}
