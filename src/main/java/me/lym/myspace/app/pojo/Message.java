package me.lym.myspace.app.pojo;


import lombok.Data;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
@Data
public class Message {
  private long id;
  private String content;
  private String category;
  private String senderCategory;
  private String senderInfo;
  private String status;
}
