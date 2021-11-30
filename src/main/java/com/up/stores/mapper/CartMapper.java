package com.up.stores.mapper;

import com.up.stores.entity.Cart;
import com.up.stores.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/** 处理购物车数据的持久层接口 */
public interface CartMapper {
    /*插入购物车数据*/
    Integer insert(Cart cart);

    /*修改购物车数据中商品的数量*/
    Integer updateNumByCid(
            @Param("cid") Integer cid,
            @Param("num") Integer num,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /*根据用户id和商品id查询购物车中的数据*/
    Cart findByUidAndPid(
            @Param("uid") Integer uid,
            @Param("pid") Integer pid);

    /*查询某用户的购物车数据*/
    List<CartVO> findVOByUid(Integer uid);

    /*根据购物车数据id查询购物车数据详情*/
    Cart findByCid(Integer cid);

    /*根据若干个购物车数据id查询详情的列表*/
    List<CartVO> findVOByCids(Integer[] cids);
}
