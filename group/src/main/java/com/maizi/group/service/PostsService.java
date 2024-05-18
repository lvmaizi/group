package com.maizi.group.service;

import com.maizi.group.domain.entity.Posts;

import java.util.List;

/**
 * @Author create by fanwenhao
 */
public interface PostsService {

    void create(Posts posts);

    void detail(String uuid);

    List<Posts> listByPage(String groupUuid);

}
