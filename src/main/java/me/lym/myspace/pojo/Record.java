package me.lym.myspace.pojo;


import lombok.Data;

import java.util.Date;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
public class Record {
  private long id;
  private Date datetime;
  private String visitorType;
  private String visitorInfo;
  private String visited;
  private long count;
}
