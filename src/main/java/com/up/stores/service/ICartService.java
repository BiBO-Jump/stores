package com.up.stores.service;

import com.up.stores.vo.CartVO;

import java.util.List;

/* 处理商品数据的业务层接口 */
public interface ICartService {
    /*将商品添加到购物车*/
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /*查询某用户的购物车数据*/
    List<CartVO> getVOByUid(Integer uid);

    /*将购物车中某商品的数量加1*/
    Integer addNum(Integer cid, Integer uid, String username);

    /*将购物车中某商品的数量减1*/
    Integer reduceNum(Integer cid, Integer uid, String username);

    /*根据若干个购物车数据id查询详情的列表*/
    List<CartVO> getVOByCids(Integer uid, Integer[] cids);
}
