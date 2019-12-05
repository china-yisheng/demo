package com.example.collecton.service.impl;

import com.example.collecton.entity.Merchant;
import com.example.collecton.mapper.MerchantMapper;
import com.example.collecton.service.IMerchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yr
 */
@Service
public class MerchantImpl  implements IMerchant {
    @Autowired
    public MerchantMapper merchantMapper;

    @Override
    public int count(Merchant merchant) {
        int a = this.merchantMapper.count(merchant);
        return a;
    }

    @Override
    public List<Merchant> all() {
        List<Merchant> a = this.merchantMapper.all();
        return  a;
    }
}
