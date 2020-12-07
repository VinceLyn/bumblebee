package com.robots.bumblebee.entity.db;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Set;


@Document("likeEntity")
@Data
public class LikeEntity {

    @Id
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
    @Field(value = "uids")
    private Set<Long> uids;
}
