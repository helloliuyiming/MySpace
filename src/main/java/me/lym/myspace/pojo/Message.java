package me.lym.myspace.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
@TableName("rs_message")
public class Message {
  private long id;
  private String content;
  private String category;
  private String senderCategory;
  private String senderInfo;
  private String status;
}
