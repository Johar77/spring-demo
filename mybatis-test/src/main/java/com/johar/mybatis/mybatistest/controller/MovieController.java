package com.johar.mybatis.mybatistest.controller;

import com.johar.mybatis.mybatistest.neo4j.MovieEntity;
import com.johar.mybatis.mybatistest.neo4j.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author : [johar]
 * @description : [一句话描述该类的功能]
 * @createTime : [2025/9/14 17:59]
 * @updateUser : [johar]
 * @updateTime : [2025/9/14 17:59]
 * @updateRemark : [说明本次修改内容]
 * @since : [v1.0]
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/by-title")
    Mono<MovieEntity> byTitle(@RequestParam String title) {
        return movieRepository.findOneByTitle(title);
    }
}
