package com.maizi.group.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maizi.group.domain.entity.Group;
import com.maizi.group.domain.entity.Posts;
import com.maizi.group.repository.mapper.PostsMapper;

/**
 * @Author create by fanwenhao
 */
public interface PostsRepository extends BaseRepository<Posts, PostsMapper> {

    Page<Posts> listByPage(Page page, Group group);

}
