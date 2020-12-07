package com.robots.bumblebee.entity.db;

import lombok.Data;
import org.dom4j.tree.AbstractEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.persistence.Id;


@Document("userEntity")
@Data
public class UserEntity extends AbstractEntity {
    @Id
    private String id;

    @Field(name = "account")
    private String account;

    @Field(name = "pwd")
    private String pwd;

    @Field(name = "icon")
    private String icon;
}
