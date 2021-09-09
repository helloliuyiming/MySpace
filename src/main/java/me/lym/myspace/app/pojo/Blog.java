package me.lym.myspace.app.pojo;

import lombok.Data;
import me.lym.myspace.app.bean.Address;

import java.util.Date;
import java.util.List;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
public class Blog {
    private int id;
    private String title;
    private String content;
    private Date createDate;
    private Date modifyDate;
    private String status;
    private Address location;
    private List<String> tags;
    private int likes;


}
