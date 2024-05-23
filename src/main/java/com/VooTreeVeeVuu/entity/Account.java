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
    @OneToOne (mappedBy = ("account"))
    Customer customer;
    @JsonIgnore
    @OneToOne (mappedBy = ("account"))
    Partner partner;
    @JsonIgnore
    @OneToOne (mappedBy = ("account"))
    Staff staff;
}
