package com.robots.bumblebee.controller;

import com.google.common.collect.Lists;
import com.robots.bumblebee.entity.vo.ArticleVO;
import com.robots.bumblebee.entity.vo.CommentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "评论")
@RestController
@RequestMapping("/comments/")
public class CommentController {

    @PostMapping("create")
    @ApiOperation(value = "对一个帖子进行评论", response = ArticleVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "被评论帖子id", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(name = "comment", value = "comment", required = true, dataType = "String"),
            @ApiImplicitParam(name = "commentOri", value = "当评论转发微博时，是否评论给原微博，0：否、1：是，默认为0", required = false, dataType = "int", example = "0"),
    })
    public ResponseEntity<String> create(@RequestParam(value = "id") Integer id,
                                            @RequestParam(value = "comment") String comment,
                                            @RequestParam(value = "commentOri",defaultValue = "0")Integer commentOri) {
        return ResponseEntity.ok("评论成功");
    }

    @PostMapping("destroy")
    @ApiOperation(value = "删除一条评论", response = ArticleVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cid", value = "评论id", required = true, dataType = "int", example = "1")
    })
    public ResponseEntity<String> destroy(@RequestParam(value = "cid") Integer cid) {
        return ResponseEntity.ok("删除成功");
    }

    @PostMapping("show")
    @ApiOperation(value = "获取某条帖子的评论列表", response = ArticleVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子id", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(name = "count", value = "单页返回的记录条数，默认为50", dataType = "int", example = "50"),
            @ApiImplicitParam(name = "page", value = "返回结果的页码，默认为1", dataType = "int", example = "1"),
            @ApiImplicitParam(name = "sortType", value = "排序类型（1:按时间排序,2:按热度排序）",  dataType = "int", example = "1")

    })
    public ResponseEntity<List<CommentVO>> show(@RequestParam(value = "id") Integer id,
                                                @RequestParam(value = "count",defaultValue = "50") Integer count,
                                                @RequestParam(value = "page",defaultValue = "1") Integer page,
                                                @RequestParam(value = "sortType",defaultValue = "1") Integer sortType) {
        List<CommentVO> model = Lists.newArrayList();
        model.add(new CommentVO());
        return ResponseEntity.ok(model);
    }

    @PostMapping("to_me")
    @ApiOperation(value = "我收到的评论", response = ArticleVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "帖子id", required = true, dataType = "int", example = "1"),
            @ApiImplicitParam(name = "count", value = "单页返回的记录条数，默认为50", dataType = "int", example = "50"),
            @ApiImplicitParam(name = "page", value = "返回结果的页码，默认为1", dataType = "int", example = "1"),
            @ApiImplicitParam(name = "sortType", value = "排序类型（1:按时间排序,2:按热度排序）",  dataType = "int", example = "1")

    })
    public ResponseEntity<List<CommentVO>> toMe(@RequestParam(value = "id") Integer id,
                                                @RequestParam(value = "count",defaultValue = "50") Integer count,
                                                @RequestParam(value = "page",defaultValue = "1") Integer page,
                                                @RequestParam(value = "sortType",defaultValue = "1") Integer sortType) {
        List<CommentVO> model = Lists.newArrayList();
        model.add(new CommentVO());
        return ResponseEntity.ok(model);
    }








}
