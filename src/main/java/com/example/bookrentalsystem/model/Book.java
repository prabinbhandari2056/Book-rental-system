package com.example.bookrentalsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @SequenceGenerator(sequenceName = "tbl_book_seq_gen", name = "tbl_book_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_book_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name")

    private String bookName;

    @Column(name = "no_of_pages")
    private Integer noOfPages;

    @Column(name = "isbn")

    private String isbn;

    @Column(name = "rating")

    private Double rating;

    @Column(name = "stock_count")

    private Integer stockCount;

    @Column(name = "published_date")

    private LocalDate publishedDate;

    @Column(name = "photo",columnDefinition = "TEXT")

    private String imagePath;

    @ManyToOne(targetEntity = Category.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", foreignKey = @ForeignKey(name = "FK_book_category"))
    private  Category category;


    @ManyToMany(targetEntity = Author.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="author_id",referencedColumnName = "author_id")
    private List<Author>  author;


}

