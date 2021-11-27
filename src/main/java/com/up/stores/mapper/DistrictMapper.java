package com.up.stores.mapper;

import com.up.stores.entity.District;

import java.util.List;

public interface DistrictMapper {
    List<District> findByParent(String parent);
    String findNameByCode(String code);
}
