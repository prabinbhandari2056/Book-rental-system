//package com.example.bookrentalsystem.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Embeddable
//@Table(name = "tbl_book_author")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class BookAuthor {
//    @ManyToMany
//    @JoinColumn( name = "author_id", referencedColumnName = "author_id", foreignKey = @ForeignKey(name = "FK_book_author"))
//    private List<Author> author;
//
//    @OneToOne
//    @JoinColumn( name = "book_id", referencedColumnName = "book_id", foreignKey = @ForeignKey(name = "FK_book_author"))
//    private Book book;
//}
