package com.example.collecton.mapper;

import com.example.collecton.entity.Merchant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MerchantMapper {

    @Insert("INSERT INTO merchant (id,shop_name,mobile,pass) VALUES (#{id}, #{shopName}, #{mobile}, #{pass});")
    int count (Merchant merchant);

    @Select("SELECT * FROM merchant")
    List<Merchant> all();
}
