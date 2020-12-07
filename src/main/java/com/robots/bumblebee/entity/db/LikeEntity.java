package com.robots.bumblebee.entity.db;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;


@Document("likeEntity")
@Data
public class LikeEntity {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    /**
     * 帖子的id
     */
    @Field("aid")
    @Indexed(unique = true)
    private String aid;

    /**
     * 该帖子被点赞的用户id
     */
    @Field(value = "uids", targetType = FieldType.ARRAY)
    private List<Long> uids;
}
