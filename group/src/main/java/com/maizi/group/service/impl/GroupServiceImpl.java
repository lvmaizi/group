package com.maizi.group.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maizi.group.domain.entity.Group;
import com.maizi.group.repository.GroupRepository;
import com.maizi.group.repository.PostsRepository;
import com.maizi.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author create by fanwenhao
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public void create(Group group) {
        groupRepository.save(group);
    }

    @Override
    public Group detail(String uuid) {
        Group group = groupRepository.get(uuid);

        Page page = new Page(1, 100);
        postsRepository.listByPage(page, group);
        return group;
    }
}
