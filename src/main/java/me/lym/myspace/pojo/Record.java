package me.lym.myspace.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Record {
  private long id;
  private Date datetime;
  private String visitorType;
  private String visitorInfo;
  private String visited;
  private long count;
}
