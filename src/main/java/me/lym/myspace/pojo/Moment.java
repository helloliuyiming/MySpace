package me.lym.myspace.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Moment {

  private long id;
  private String content;
  private Date createDate;
  private Date modifyDate;
  private String tags;
  private String status;

}
