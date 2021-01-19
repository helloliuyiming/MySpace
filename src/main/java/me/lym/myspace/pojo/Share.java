package me.lym.myspace.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Share {

  private long id;
  private String link;
  private String status;
  private String tags;
  private String comment;
  private Date createDate;


}
