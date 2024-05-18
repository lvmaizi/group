package com.maizi.group.service;

import com.maizi.group.domain.entity.Group;

/**
 * @Author create by fanwenhao
 */
public interface GroupService {

    void create(Group group);

    Group detail(String uuid);

}
