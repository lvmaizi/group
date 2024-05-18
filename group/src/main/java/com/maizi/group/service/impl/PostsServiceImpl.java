package com.maizi.group.service.impl;

import com.maizi.group.domain.entity.Posts;
import com.maizi.group.repository.CommentsRepository;
import com.maizi.group.repository.PostsRepository;
import com.maizi.group.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author create by fanwenhao
 */
@Component
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public void create(Posts posts) {
        postsRepository.save(posts);
    }

    @Override
    public Posts detail(String uuid) {
        Posts posts = postsRepository.get(uuid);
        commentsRepository.list(posts);
        return posts;
    }

    @Override
    public List<Posts> listByPage(String groupUuid) {
        return null;
    }
}
