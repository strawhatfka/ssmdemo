package com.ouyue.ssm.controller;

import com.ouyue.ssm.pojo.Book;
import com.ouyue.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author:ydwang
 * @Date:2022/10/22
 * @Description:desc
 * @Version:1.0
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
//    @Qualifier("BookServiceImpl") //在属性注入时，筛选特定的Bean，用指定名称（BookServiceImpl）的Bean，为该属性（bookService）赋值
    private BookService bookService;

    @RequestMapping("/allBook")
    public String allBook(Model model) {
        List<Book> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Book book) {
        System.out.println(book);
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Book book = bookService.queryBookById(id);
        System.out.println(book);
        model.addAttribute("book",book );
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Book book) {
        System.out.println(book);
        bookService.updateBook(book);
        Book books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
}
