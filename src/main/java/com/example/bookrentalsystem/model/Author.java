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
@Table(name = "tbl_author",uniqueConstraints = {@UniqueConstraint(columnNames = "author_email", name = "UNIQUE_tbl_author_author_email")})
public class Author {
    @Id
    @SequenceGenerator(sequenceName = "tbl_author_seq_gen", name = "tbl_author_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_author_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "author_name")

    private  String authorName;
    @Column(name = "author_email")

    private String authorEmail;
    @Column(name = "author_phone_no")

    private String authorMobile;
}
