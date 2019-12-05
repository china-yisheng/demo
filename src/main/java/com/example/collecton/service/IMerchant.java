package com.example.collecton.service;

import com.example.collecton.entity.Merchant;

import java.util.List;

public interface IMerchant {

    int count(Merchant merchant);

    List<Merchant> all();
}
