package me.lym.myspace.app.pojo;

import lombok.Data;
import java.util.Date;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
public class Friend {
  private long id;
  private String alias;
  private String host;
  private Date lastSync;
  private String status;
}
