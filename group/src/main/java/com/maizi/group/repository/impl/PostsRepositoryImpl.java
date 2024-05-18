package com.maizi.group.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maizi.group.domain.entity.Group;
import com.maizi.group.domain.entity.Posts;
import com.maizi.group.repository.PostsRepository;
import com.maizi.group.repository.mapper.PostsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author create by fanwenhao
 */
@Component
public class PostsRepositoryImpl implements PostsRepository {

    @Autowired
    private RepositoryWrapper<Posts, PostsMapper> repositoryWrapper;
    @Autowired
    private PostsMapper mapper;

    @Override
    public void save(Posts domain) {
        repositoryWrapper.save(mapper, domain);
    }

    @Override
    public void insert(Posts domain) {
        repositoryWrapper.insert(mapper, domain);
    }

    @Override
    public void update(Posts domain) {
        repositoryWrapper.update(mapper, domain);
    }

    @Override
    public Posts get(String uuid) {
        return repositoryWrapper.get(mapper, uuid);
    }

    @Override
    public Page<Posts> listByPage(Page page, Group group) {
        LambdaQueryWrapper<Posts> wrapper = new LambdaQueryWrapper();
        wrapper.eq(Posts::getGroupUuid, group.getUuid());
        Page pageResult = mapper.selectPage(page, wrapper);
        group.setPostsList(pageResult.getRecords());
        return pageResult;
    }
}
