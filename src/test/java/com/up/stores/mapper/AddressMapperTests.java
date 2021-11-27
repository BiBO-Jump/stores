package com.up.stores.mapper;

import com.up.stores.entity.Address;
import com.up.stores.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;


    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(11);
        address.setName("李四");
        address.setPhone("17858802974");
        address.setAddress("四川省绵阳市游仙区绵阳职业技术学院");
        addressMapper.insert(address);
    }

    @Test
    public void countByUid() {
        Integer count = addressMapper.countByUid(11);
        System.out.println("count=" + count);
    }

    @Test
    public void findByUid() {
        Integer uid = 12;
        List<Address> list = addressMapper.findByUid(uid);
        System.out.println("count=" + list.size());
        for (Address item : list) {
            System.out.println(item);
        }
    }
}