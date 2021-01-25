package me.lym.myspace.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import me.lym.myspace.util.bean.Address;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
public class Diary implements Serializable {
    private Integer id;
    private Date date;
    private String content;
    private String mood;
    private String weather;
    private Address location;
    private static final long serialVersionUID = 1L;
}