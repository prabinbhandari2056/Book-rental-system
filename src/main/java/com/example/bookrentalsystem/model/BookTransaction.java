package com.example.bookrentalsystem.model;

import com.example.bookrentalsystem.enums.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tbl_book_transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTransaction {
    @Id
    @Column(name = "book_transaction_id")
    @SequenceGenerator(sequenceName = "tbl_book_transaction_seq_gen", name = "tbl_book_transaction_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_book_transaction_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer bookTransactionId;

    @ManyToOne
    @JoinColumn( name = "book_id", referencedColumnName = "book_id", foreignKey = @ForeignKey(name = "FK_book_author"))
    private Book book;

    @Column(name = "code")
    private String code;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "rent_status")
    private RentType rentType;

    @ManyToOne
    @JoinColumn( name = "member_id", referencedColumnName = "member_id", foreignKey = @ForeignKey(name = "FK_book_member"))
    private Member member;
}
