package me.lym.myspace.pojo;

import lombok.Data;

import java.util.Date;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
public class Share {

  private long id;
  private String link;
  private String status;
  private String tags;
  private String comment;
  private Date createDate;


}
