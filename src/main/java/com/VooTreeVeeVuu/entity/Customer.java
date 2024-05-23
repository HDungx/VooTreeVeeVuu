package com.VooTreeVeeVuu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Customers")
public class Customer {
    @Id
    String customer_Id;
    String firstName;
    String lastName;
    String email;
    String phoneNum;
    String gender;
    int age;
    @OneToOne @JoinColumn(name = "account_Id")
    Account account;
    @JsonIgnore
    @OneToMany (mappedBy = "rating")
    List<Rating> listRating;
    @JsonIgnore
    @OneToMany (mappedBy = "booking")
    List<Booking> listBooking;

}
