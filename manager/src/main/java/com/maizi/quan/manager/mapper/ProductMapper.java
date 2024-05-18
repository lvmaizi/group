package com.maizi.quan.manager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maizi.quan.manager.domain.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
