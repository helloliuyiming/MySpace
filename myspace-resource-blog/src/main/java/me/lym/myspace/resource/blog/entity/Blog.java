package me.lym.myspace.resource.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "rs_blog")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private Date createDate;

    private Date modifyDate;

    private String tags;

    private String status;

    private Long likes;

}
