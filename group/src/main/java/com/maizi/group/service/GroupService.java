package com.maizi.group.service;

import com.maizi.group.domain.entity.Group;

import java.util.List;

/**
 * @Author create by fanwenhao
 */
public interface GroupService {

    List<Group> list();

    void create(Group group);

    Group detail(String uuid);

}
