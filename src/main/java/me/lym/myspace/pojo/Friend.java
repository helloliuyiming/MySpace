package me.lym.myspace.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Friend {
  private long id;
  private String alias;
  private String host;
  private Date lastSync;
  private String status;
}
