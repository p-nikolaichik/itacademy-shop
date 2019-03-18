package com.itacademy.actions;

import java.util.Map;

import com.itacademy.shop.SportEquipment;

public interface ShopActions {

  void printGoodsInfo(Map<SportEquipment, Integer> goods);
  
  void printSearchResult(String searchText);
}
