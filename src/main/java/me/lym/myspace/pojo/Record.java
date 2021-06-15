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
@TableName("rs_record")
public class Record {
  private long id;
  private Date datetime;
  private String visitorType;
  private String visitorInfo;
  private String visited;
  private long count;
}
