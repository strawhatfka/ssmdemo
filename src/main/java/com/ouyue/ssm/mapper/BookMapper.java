package com.ouyue.ssm.mapper;

import com.ouyue.ssm.pojo.Book;

import java.util.List;

/**
 * @Author:ydwang
 * @Date:2022/10/22
 * @Description:desc
 * @Version:1.0
 */

public interface BookMapper {

    //增加一个Book
    int addBook(Book book);

    //根据id删除一个Book
    int deleteBookById(int id);

    //更新Book
    int updateBook(Book book);

    //根据id查询,返回一个Book
    Book queryBookById(int id);

    //查询全部Book,返回list集合
    List<Book> queryAllBook();
}
