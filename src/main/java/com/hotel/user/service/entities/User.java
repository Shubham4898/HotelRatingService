package com.hotel.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String about;

    @Transient
    private List<Rating> ratings;

}
