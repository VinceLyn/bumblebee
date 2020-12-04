package com.robots.bumblebee.entity.db;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;


@Document("articleEntity")
@Data
public class FocusEntity {

    @MongoId(value = FieldType.OBJECT_ID)
    private String id;

    private long uid;

    private List<Long> focusUidList;
}
