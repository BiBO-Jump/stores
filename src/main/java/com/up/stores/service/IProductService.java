package com.up.stores.service;

import com.up.stores.entity.Product;

import java.util.List;

/* 处理商品数据的业务层接口 */
public interface IProductService {
    /*查询热销商品的前四名*/
    List<Product> findHotList();

    /*根据商品id查询商品详情*/
    Product findById(Integer id);
}
