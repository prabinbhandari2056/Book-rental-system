package com.example.bookrentalsystem.service.book;

import com.example.bookrentalsystem.globalException.AppException;
import com.example.bookrentalsystem.mapper.BookDetailMapper;
import com.example.bookrentalsystem.model.Author;
import com.example.bookrentalsystem.model.Book;
import com.example.bookrentalsystem.model.Category;
import com.example.bookrentalsystem.pojo.book.BookDetailRequestPojo;
import com.example.bookrentalsystem.repository.AuthorRepository;
import com.example.bookrentalsystem.repository.BookRepository;
import com.example.bookrentalsystem.repository.CategoryRepository;
import com.example.bookrentalsystem.util.FileExtensionValidatior;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final ObjectMapper objectMapper;

    private final BookDetailMapper bookDetailMapper;

    private final CategoryRepository categoryRepository;

    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, ObjectMapper objectMapper, BookDetailMapper bookDetailMapper, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.objectMapper = objectMapper;
        this.bookDetailMapper = bookDetailMapper;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    /**
     *
     * @param bookId
     * @return
     */

    @Override
    public Object getBookById(Integer bookId) {
//        BookDetailResponsePojo bookDetailResponsePojo = bookDetailMapper.getBookById(bookId);
        return bookRepository.findById(bookId);


    }

    @Override
    @Transactional
    public void saveBookDetails(BookDetailRequestPojo bookDetailRequestPojo) throws Exception {

        Book book;
        if (!(FileExtensionValidatior.validateFileExtension(bookDetailRequestPojo.getBookImage(), "jpeg", "jpg", "png"))) //Checks file extensions and size
            throw new AppException("Please upload image file of type .png,.jpeg,.jpg  of size less than 250 KB.");
        byte[] bytes = IOUtils.toByteArray(bookDetailRequestPojo.getBookImage().getInputStream()); //new code
        String image = Base64.getEncoder().encodeToString(bytes);
        Category category = categoryRepository.findById(bookDetailRequestPojo.getCategoryId()).orElseThrow(() -> new AppException("Category does not exist by category id"));
        List<Author> authors = authorRepository.findAllById(bookDetailRequestPojo.getAuthorId());
        if (authors.size() != bookDetailRequestPojo.getAuthorId().size())
            throw new AppException("Authors does not exist");
        if (bookDetailRequestPojo.getBookId() != null)
            book = bookRepository.findById(bookDetailRequestPojo.getBookId()).orElse(new Book());
        book = Book
                .builder()
                .bookId(bookDetailRequestPojo.getBookId())
                .bookName(bookDetailRequestPojo.getBookName())
                .noOfPages(bookDetailRequestPojo.getNoOfPages())
                .isbn(bookDetailRequestPojo.getIsbn())
                .rating(bookDetailRequestPojo.getRating())
                .stockCount(bookDetailRequestPojo.getStockCount())
                .publishedDate(bookDetailRequestPojo.getPublishedDate())
                .imagePath(image)
                .category(category)
                .author(authors)
                .build();
        bookRepository.save(book);
    }


    @Override
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @Transactional
    @Override
    public void updateBookStock(BookDetailRequestPojo bookDetailRequestPojo) {
        Category category = categoryRepository.findById(bookDetailRequestPojo.getCategoryId()).orElseThrow(() -> new RuntimeException("Category does not exist by category id"));
        List<Author> authors = authorRepository.findAllById(bookDetailRequestPojo.getAuthorId());
        bookRepository.updateBookStock(bookDetailRequestPojo.getBookId(), bookDetailRequestPojo.getStockCount());
    }

    @Override
    public void deleteBookById(Integer bookId) throws AppException {
        Optional<Book> exists=bookRepository.findById(bookId);
        if (!exists.isPresent()){
            throw new AppException("Book does not exist by given "+ bookId +" book Id");
        }
        else if (exists.isPresent()){
            bookRepository.deleteById(bookId);
        }

    }
}
