package me.lym.myspace.pojo;


import lombok.Data;

@Data
public class Message {

  private long id;
  private String content;
  private String category;
  private String senderCategory;
  private String senderInfo;
  private String status;


}
