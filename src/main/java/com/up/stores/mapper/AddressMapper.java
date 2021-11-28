package com.up.stores.mapper;

import com.up.stores.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AddressMapper {
    /*插入收货地址数据*/
    Integer insert(Address address);

    /*统计某用户的收货地址数据的数量*/
    Integer countByUid(Integer uid);

    /*查询某用户的收货地址列表数据*/
    List<Address> findByUid(Integer uid);

    /*将某用户的所有收货地址设置为非默认地址*/
    Integer updateNonDefaultByUid(Integer uid);

    /* 将指定的收货地址设置为默认地址*/
    Integer updateDefaultByAid(
            @Param("aid") Integer aid,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /* 根据收货地址aid值，查询收货地址详情*/
    Address findByAid(Integer aid);

    /* 根据收货地址id删除数据*/
    Integer deleteByAid(Integer aid);

    /* 查询某用户最后修改的收货地址*/
    Address findLastModified(Integer uid);
}
