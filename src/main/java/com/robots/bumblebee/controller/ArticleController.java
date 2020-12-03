package com.robots.bumblebee.controller;

import com.robots.bumblebee.entity.request.Article;
import com.robots.bumblebee.entity.vo.ArticleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 帖子控制器
 *
 * @author yichengdong
 * @date 2020/12/3
 */
@Api(tags = "帖子")
@RestController
@RequestMapping("/statuses/")
public class ArticleController {


    @GetMapping("get_articles")
    @ApiOperation(value = "获取帖子列表", response = ArticleVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "int", example = "10"),
            @ApiImplicitParam(name = "sortType", value = "排序类型(1:根据发布时间排序；2:根据点赞数排序)", required = true, dataType = "int", example = "10")
    })
    public ResponseEntity<ArticleVO> getArticles(@RequestParam(value = "pageNum") Integer pageNum,
                                                 @RequestParam(value = "pageSize") Integer pageSize,
                                                 @RequestParam(value = "sortType") Integer sortType) {
        return ResponseEntity.ok(new ArticleVO());
    }

    @PostMapping("publish_article")
    @ApiOperation(value = "发布帖子")
    public ResponseEntity<String> publishArticle(Article article) {

        return ResponseEntity.ok("发布成功！");
    }

    @PostMapping("repost")
    @ApiOperation(value = "转发")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "转发帖子的id", required = true, dataType = "int",example = "1"),
            @ApiImplicitParam(name = "content", value = "正文内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "typeId", value = "转发到的圈子类型", required = true, dataType = "int",example = "1")
    })
    public ResponseEntity<String> repost(Integer id, String content, Integer typeId) {
        return ResponseEntity.ok("转发成功！");
    }

    @PostMapping("comment")
    @ApiOperation(value = "评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "被评论帖子的id", required = true, dataType = "int",example = "1"),
            @ApiImplicitParam(name = "content", value = "评论内容", required = true, dataType = "String"),
    })
    public ResponseEntity<String> comment(Integer id, String content) {
        return ResponseEntity.ok("评论成功！");
    }

    @PostMapping("like")
    @ApiOperation(value = "点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "被点赞帖子的id", required = true, dataType = "int",example = "1"),
    })
    public ResponseEntity<String> like(Integer id) {
        return ResponseEntity.ok("点赞成功！");
    }


}
