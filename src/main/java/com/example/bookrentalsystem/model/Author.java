package com.example.bookrentalsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_author")
public class Author {
    @Id
    @SequenceGenerator(sequenceName = "tbl_author_seq_gen", name = "tbl_author_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_author_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "author_name")
    @NotNull
    private  String authorName;
    @Column(name = "author_email")
    @NotNull
    private String authorEmail;
    @Column(name = "author_phone_no")
    @NotNull
    private String authorMobile;
}
