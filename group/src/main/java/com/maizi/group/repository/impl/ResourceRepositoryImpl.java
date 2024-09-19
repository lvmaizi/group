package com.maizi.group.repository.impl;

import com.maizi.group.domain.entity.Resource;
import com.maizi.group.repository.ResourceRepository;
import com.maizi.group.repository.mapper.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author create by fanwenhao
 */
@Component
public class ResourceRepositoryImpl implements ResourceRepository {

    @Autowired
    private RepositoryWrapper<Resource, ResourceMapper> repositoryWrapper;
    @Autowired
    private ResourceMapper mapper;

    @Override
    public void save(Resource domain) {
        repositoryWrapper.save(mapper, domain);
    }

    @Override
    public void insert(Resource domain) {
        repositoryWrapper.insert(mapper, domain);
    }

    @Override
    public void update(Resource domain) {
        repositoryWrapper.update(mapper, domain);
    }

    @Override
    public Resource get(String uuid) {
        return repositoryWrapper.get(mapper, uuid);
    }
}
