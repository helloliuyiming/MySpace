package me.lym.myspace.app.pojo;


import lombok.Data;

import java.util.Date;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
public class Moment {
  private long id;
  private String content;
  private Date createDate;
  private Date modifyDate;
  private String tags;
  private String status;
}
