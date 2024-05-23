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
@Table(name = "Partners")
public class Partner {
    @Id
    String partner_Id;
    String firstName;
    String lastName;
    String email;
    String phoneNum;
    String gender;
    int age;
    @JsonIgnore
    @OneToOne (mappedBy = "partner")
    Account account;
    @JsonIgnore
    @OneToMany(mappedBy = "partner")
    List<Hotel> hotelList;
}
