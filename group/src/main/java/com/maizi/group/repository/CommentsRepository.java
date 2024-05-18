package com.maizi.group.repository;

import com.maizi.group.domain.entity.Comments;
import com.maizi.group.domain.entity.Posts;
import com.maizi.group.repository.mapper.CommentsMapper;

/**
 * @Author create by fanwenhao
 */
public interface CommentsRepository extends BaseRepository<Comments, CommentsMapper> {

    void list(Posts posts);

}
