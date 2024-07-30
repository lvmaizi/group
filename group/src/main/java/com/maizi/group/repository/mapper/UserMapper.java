package com.maizi.group.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maizi.group.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
