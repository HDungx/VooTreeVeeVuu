package com.VooTreeVeeVuu.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name ="staffs")
public class Staff {
    @Id
    String staff_Id;
    String firstName;
    String lastName;
    String email;
    String phoneNum;
    @JsonIgnore
    @OneToMany (mappedBy = "staff")
    List<Hotel> hotels;
    @JsonIgnore
    @OneToOne @JoinColumn(name = "email")
    Account account;

}
