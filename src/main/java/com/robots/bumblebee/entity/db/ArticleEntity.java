package com.robots.bumblebee.entity.db;


import lombok.Data;
import org.dom4j.tree.AbstractEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("articleEntity")
@Data
public class ArticleEntity extends AbstractEntity {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    @Field("uid")
    private long uid;

    @Field("title")
    private String title;

    @Field("text")
    private String text;

    /**
     * 來源id
     */
    @Field("sid")
    private String sid;

    @Field("ctime")
    private long ctime;

}
