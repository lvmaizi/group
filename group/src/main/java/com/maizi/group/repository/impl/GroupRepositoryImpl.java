package com.maizi.group.repository.impl;

import com.maizi.group.domain.entity.Group;
import com.maizi.group.repository.GroupRepository;
import com.maizi.group.repository.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author create by fanwenhao
 */
@Component
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    private RepositoryWrapper<Group, GroupMapper> repositoryWrapper;
    @Autowired
    private GroupMapper mapper;

    @Override
    public void save(Group domain) {
        repositoryWrapper.save(mapper, domain);
    }

    @Override
    public void insert(Group domain) {
        repositoryWrapper.insert(mapper, domain);
    }

    @Override
    public void update(Group domain) {
        repositoryWrapper.update(mapper, domain);

    }

    @Override
    public Group get(String uuid) {
        return repositoryWrapper.get(mapper, uuid);
    }

    @Override
    public List<Group> list() {
        return mapper.selectList(null);
    }
}
