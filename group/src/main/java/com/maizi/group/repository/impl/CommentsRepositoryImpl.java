package com.maizi.group.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.maizi.group.domain.entity.Comments;
import com.maizi.group.domain.entity.Posts;
import com.maizi.group.repository.CommentsRepository;
import com.maizi.group.repository.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @Author create by fanwenhao
 */
@Component
public class CommentsRepositoryImpl implements CommentsRepository {

    @Autowired
    private RepositoryWrapper<Comments, CommentsMapper> repositoryWrapper;
    @Autowired
    private CommentsMapper mapper;

    @Override
    public void save(Comments domain) {
        repositoryWrapper.save(mapper, domain);

    }

    @Override
    public void insert(Comments domain) {
        repositoryWrapper.insert(mapper, domain);

    }

    @Override
    public void update(Comments domain) {
        repositoryWrapper.update(mapper, domain);

    }

    @Override
    public Comments get(String uuid) {
        return repositoryWrapper.get(mapper, uuid);
    }

    @Override
    public void list(Posts posts) {
        LambdaQueryWrapper<Comments> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comments::getPostsUuid, posts.getUuid());
        List<Comments> commentsList = mapper.selectList(queryWrapper);

        List<Comments> rootComments = new ArrayList<>();
        List<Comments> leafComments = new ArrayList<>();

        for (Comments comments : commentsList) {
            if (isBlank(comments.getRootComments())) {
                rootComments.add(comments);
            } else {
                leafComments.add(comments);
            }
        }

        Map<String, List<Comments>> map = leafComments
                .stream()
                .collect(Collectors.groupingBy(Comments::getRootComments));

        for (Comments comments : rootComments) {
            comments.setReplyList(map.get(comments.getUuid()));
        }

        posts.setCommentsList(rootComments);
    }


}
