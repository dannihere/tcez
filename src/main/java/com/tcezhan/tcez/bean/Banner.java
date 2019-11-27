package com.tcezhan.tcez.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Banner {
    private Integer id;
    private String title;
    private String description;
    private String img;
    private Integer display;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }
}

