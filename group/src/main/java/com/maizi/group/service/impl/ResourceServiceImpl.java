package com.maizi.group.service.impl;

import com.maizi.group.domain.entity.Resource;
import com.maizi.group.repository.ResourceRepository;
import com.maizi.group.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author create by fanwenhao
 */
@Component
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public void create(Resource resource) {
        resourceRepository.save(resource);
    }
}
