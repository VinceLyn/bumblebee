package com.robots.bumblebee.entity.db;


import lombok.Data;
import org.dom4j.tree.AbstractEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.List;

@Document("articleEntity")
@Data
public class ArticleEntity extends AbstractEntity {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    @Field("title")
    private String title;

    @Field("text")
    private String text;

    /**
     * 來源id
     */
    @Field("sid")
    private String sid;

    @CreatedDate
    private long ctime;

    @DBRef
    private UserEntity user;
    @Field("likes")
    private List<String> likes;
}
