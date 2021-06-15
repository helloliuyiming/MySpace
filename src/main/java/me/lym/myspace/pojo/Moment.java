package me.lym.myspace.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
@TableName("rs_moment")
public class Moment {
  private long id;
  private String content;
  private Date createDate;
  private Date modifyDate;
  private String tags;
  private String status;
}
