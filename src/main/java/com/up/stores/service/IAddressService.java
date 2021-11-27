package com.up.stores.service;

import com.up.stores.entity.Address;

import java.util.List;

//处理收货地址数据的业务层接口
public interface IAddressService {
//    创建新的收货地址
    void addNewAddress(Integer uid, String username, Address address);
//    查询某用户的收货地址列表数据
    List<Address> getByUid(Integer uid);
}
