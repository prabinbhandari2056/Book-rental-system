package com.example.bookrentalsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_book_author")
public class BookAuthor {
    @Id
    @SequenceGenerator(sequenceName = "tbl_book_author_seq_gen", name = "tbl_book_author_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_book_author_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "book_author_id")
    private Integer bookAuthorId;

    @OneToOne
//    @ManyToMany
    @JoinColumn( name = "author_id", referencedColumnName = "author_id", foreignKey = @ForeignKey(name = "FK_book_author"))
//    private List<Author> author;
    private Author author;

    @OneToOne
    @JoinColumn( name = "book_id", referencedColumnName = "book_id", foreignKey = @ForeignKey(name = "FK_book_author"))
    private Book book;
}
