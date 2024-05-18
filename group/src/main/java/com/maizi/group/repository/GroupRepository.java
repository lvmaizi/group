package com.maizi.group.repository;

import com.maizi.group.domain.entity.Group;
import com.maizi.group.repository.mapper.GroupMapper;

import java.util.List;

public interface GroupRepository extends BaseRepository<Group, GroupMapper> {

    List<Group> list();

}
