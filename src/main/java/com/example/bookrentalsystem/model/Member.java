package com.example.bookrentalsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "member_id")
    @SequenceGenerator(sequenceName = "tbl_member_seq_gen", name = "tbl_member_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_member_seq_gen", strategy = GenerationType.SEQUENCE)
    private  Integer memberId;

    @Column(name = "email")
    private  String email;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "address")
    private String address;
}
