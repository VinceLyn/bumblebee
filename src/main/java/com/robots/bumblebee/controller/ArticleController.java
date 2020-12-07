package com.robots.bumblebee.controller;

import com.google.common.collect.Lists;
import com.robots.bumblebee.entity.request.Article;
import com.robots.bumblebee.entity.vo.ArticleVO;
import com.robots.bumblebee.entity.vo.SimpleUserVO;
import com.robots.bumblebee.service.ArticleService;
import com.robots.bumblebee.utils.CurrentUserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 帖子控制器
 */
@Api(tags = "帖子")
@RestController
@RequestMapping("/statuses/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("get_articles")
    @ApiOperation(value = "获取帖子列表", response = ArticleVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页面大小", required = true, dataType = "int", example = "10")
    })
    public ResponseEntity<List<ArticleVO>> getArticles(@RequestParam(value = "pageNum") Integer pageNum,
                                                       @RequestParam(value = "pageSize") Integer pageSize) {
        List<Long> uidList = Lists.newArrayList();
        List<ArticleVO> articleVOList = articleService.getArticles(pageNum, pageSize, uidList);
        return ResponseEntity.ok(articleVOList);
    }

    @GetMapping("show")
    @ApiOperation(value = "根据帖子id获取单条帖内容", response = ArticleVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子id", required = true, dataType = "String")
    })
    public ResponseEntity<ArticleVO> show(@RequestParam(value = "id") String id) {
        ArticleVO articleVO = articleService.show(id);
        return ResponseEntity.ok(articleVO);
    }

    @PostMapping("publish_article")
    @ApiOperation(value = "发布帖子")
    public ResponseEntity<String> publishArticle(HttpServletRequest request, Article article) {
        long curUserId = CurrentUserUtil.getCurUserId(request);
        article.setUserId(curUserId);
        articleService.publishArticle(article);
        return ResponseEntity.ok("发布成功！");
    }

    @PostMapping("repost")
    @ApiOperation(value = "转发")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "转发帖子的id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "text", value = "正文内容", required = true, dataType = "String")
    })
    public ResponseEntity<String> repost(HttpServletRequest request, String id, String text) {
        long curUserId = CurrentUserUtil.getCurUserId(request);
        articleService.repost(id, text, curUserId);
        return ResponseEntity.ok("转发成功！");
    }

    @PostMapping("like")
    @ApiOperation(value = "点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "被点赞帖子的id", required = true, dataType = "String"),
    })
    public ResponseEntity<String> like(HttpServletRequest request, @RequestParam(value = "id") String id) {
        long curUserId = CurrentUserUtil.getCurUserId(request);
        articleService.like(id, curUserId);
        return ResponseEntity.ok("点赞成功！");
    }

    @PostMapping("unlike")
    @ApiOperation(value = "取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "被点赞帖子的id", required = true, dataType = "String"),
    })
    public ResponseEntity<String> unlike(HttpServletRequest request, @RequestParam(value = "id") String id) {
        long curUserId = CurrentUserUtil.getCurUserId(request);
        articleService.unlike(id, curUserId);
        return ResponseEntity.ok("已取消点赞！");
    }

    @PostMapping("get_likes")
    @ApiOperation(value = "获取该帖子的点赞的用戶列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "被点赞帖子的id", required = true, dataType = "String"),
    })
    public ResponseEntity<List<SimpleUserVO>> getLikes(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(articleService.getLikes(id));
    }

}
