package me.lym.myspace.pojo;

import lombok.Data;

import java.util.Date;
/**
 * @author lym
 * @version 1.0
 * @date 2021/1/24 18:20
 */
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
