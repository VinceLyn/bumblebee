package com.robots.bumblebee.entity.db;


import lombok.Data;
import org.dom4j.tree.AbstractEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Data
public class ArticleEntity extends AbstractEntity {

    @Field("id")
    private long id;
    @Field("title")
    private String title;
    @Field("context")
    private String context;

}
