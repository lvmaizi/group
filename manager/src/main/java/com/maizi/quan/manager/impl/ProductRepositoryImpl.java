package com.maizi.quan.manager.impl;

import com.maizi.quan.manager.BaseRepository;
import com.maizi.quan.manager.ProductRepository;
import com.maizi.quan.manager.domain.Product;
import com.maizi.quan.manager.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author create by fanwenhao
 */
@Component
public class ProductRepositoryImpl extends BaseRepository implements ProductRepository {

    @Resource
    private ProductMapper productMapper;

    @Override
    public void save(Product product) {
        super.save(productMapper, product);
    }

    @Override
    public void insert(Product product) {
        super.insert(productMapper, product);
    }

    @Override
    public void update(Product product) {
        super.update(productMapper, product);
    }

    @Override
    public Product get(String uuid) {
        return super.get(productMapper, uuid);
    }
}
