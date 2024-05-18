package com.maizi.quan.manager;

import com.maizi.quan.manager.domain.Product;

public interface ProductRepository {

    /**
     * 保存/更新
     */
    void save(Product product);

    /**
     * 插入
     */
    void insert(Product product);

    /**
     * 更新
     */
    void update(Product product);

    /**
     * get
     */
    Product get(String uuid);

}
