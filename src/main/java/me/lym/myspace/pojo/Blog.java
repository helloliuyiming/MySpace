package me.lym.myspace.pojo;

import lombok.Data;
import me.lym.myspace.util.bean.Address;

import java.util.Date;
import java.util.List;

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
