package com.mq.application.entity;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author BaiLiJun  on 2019/10/30
 */
public class User implements Serializable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
