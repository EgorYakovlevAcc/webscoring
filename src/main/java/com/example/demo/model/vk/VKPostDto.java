package com.example.demo.model.vk;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class VKPostDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Lob
    private String text;
    private Integer date;

    public VKPostDto() {
    }

    public VKPostDto(Integer id, String text, Integer date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
