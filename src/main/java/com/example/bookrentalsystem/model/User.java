package com.example.bookrentalsystem.model;

import com.example.bookrentalsystem.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "user_name", name = "UNIQUE_user_user_name")})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(sequenceName = "users_seq_gen", name = "users_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer user_id;

    @Column(name = "user_name")

    private String userName;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}