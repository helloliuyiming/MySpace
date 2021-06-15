package me.lym.myspace.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import me.lym.myspace.util.bean.Address;

import java.util.Date;
import java.util.List;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
@TableName("rs_blog")
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
