package com.ouyue.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:ydwang
 * @Date:2022/10/22
 * @Description:desc
 * @Version:1.0
 */

//
@Data //为类基于lombok插件中所有属性添加get和set方法
@AllArgsConstructor //为类添加有参构造
@NoArgsConstructor //为类添加无参构造
public class Book {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
