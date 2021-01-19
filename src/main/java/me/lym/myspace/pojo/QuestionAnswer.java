package me.lym.myspace.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionAnswer {

  private long id;
  private String question;
  private Date createDate;
  private Date closeDate;
  private String answer;
  private String tags;
  private String status;

}
