package com.example.bookrentalsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tbl_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @SequenceGenerator(sequenceName = "tbl_book_seq_gen", name = "tbl_book_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_book_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name")
    @NotNull
    private String bookName;

    @Column(name = "no_of_pages")
    @NotNull
    private Integer noOfPages;

    @Column(name = "isbn")
    @NotNull
    private String isbn;

    @Column(name = "rating")
    @NotNull
    private double rating;

    @Column(name = "stock_count")
    @NotNull
    private Integer stockCount;

    @Column(name = "published_date")
    @NotNull
    private Date publishedDate;

    @Column(name = "photo")
    @NotNull
    private String photo;

    @ManyToOne
    @JoinColumn( name = "category_id", referencedColumnName = "category_id", foreignKey = @ForeignKey(name = "FK_book_category"))
    private  Category category;



}

