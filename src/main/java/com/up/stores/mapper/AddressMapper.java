package com.up.stores.mapper;

import com.up.stores.entity.Address;

import java.util.List;

public interface AddressMapper {
    /*插入收货地址数据*/
    Integer insert(Address address);

    /*统计某用户的收货地址数据的数量*/
    Integer countByUid(Integer uid);

    /*查询某用户的收货地址列表数据*/
    List<Address> findByUid(Integer uid);
}
