package com.robots.bumblebee.repository.impl;

import com.robots.bumblebee.entity.db.ArticleEntity;
import com.robots.bumblebee.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(ArticleEntity entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public ArticleEntity findById(String id) {
        return mongoTemplate.findById(id, ArticleEntity.class);
    }

    @Override
    public List<ArticleEntity> findByPage(int pageNum, int pageSize, List<String> uidList) {

        Query query = new Query();
        Criteria criteria = new Criteria();

        if (uidList != null && !uidList.isEmpty()) {
            criteria.and("uid").in(uidList);
        }

        //下面条件相当于select * from order where orderStatus in(16,32) and payStatus=4 and finishTime<=2019-07-05 00:00:00 and (customerId=139 or customerId=1360)
//        criteria.and("orderStatus").in(16, 32).andOperator(Criteria.where("payStatus").is(4)).and("finishTime").lte("2019-07-05 00:00:00")
//                .orOperator(Criteria.where("customerId").is("139"), Criteria.where("customerId").is("1360"));

        //1360
        query.addCriteria(criteria);
        long count = mongoTemplate.count(query, ArticleEntity.class); //计算总数,用于算法分页数

        int pageTotal = (int) (count % pageSize == 0 ? count / pageSize : count / pageSize + 1); //总页数
        System.out.println(pageTotal);
        int offset = (pageNum - 1) * pageSize;
        query.with(Sort.by(Sort.Order.desc("ctime"))); //排序逻辑
        query.skip(offset).limit(pageSize); // 分页逻辑
        return mongoTemplate.find(query, ArticleEntity.class);
    }


}
