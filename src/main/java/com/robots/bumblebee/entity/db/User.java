package com.robots.bumblebee.entity.db;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "account")
    private String account;

    @JoinColumn(name = "user_image_url")
    private String userImageUrl;
}
