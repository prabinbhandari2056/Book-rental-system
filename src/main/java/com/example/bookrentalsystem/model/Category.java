package com.example.bookrentalsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_category")
public class Category {
    @Id
    @Column(name = "category_id")
    @SequenceGenerator(sequenceName = "tbl_category_seq_gen",name = "tbl_category_seq",allocationSize = 1)
    @GeneratedValue(generator = "tbl_category_seq_gen", strategy = GenerationType.SEQUENCE)

    private  Integer categoryId;
    @Column(name = "category_name")
    private  String categoryName;
    @Column(name = "category_description")
    private  String categoryDescription;
}
