package com.itacademy.shop.search;

import com.itacademy.shop.SportEquipment;

import java.util.HashMap;
import java.util.Map;

public class CriteriaCategory implements Criteria {

  @Override
  public Map<SportEquipment, Integer> meetCriteria(Map<SportEquipment, Integer> goods, String title) {
    Map<SportEquipment, Integer> foundedGoods = new HashMap<>();
    for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      if(entry.getKey().getTitle().equalsIgnoreCase(title)){
        foundedGoods.put(entry.getKey(), entry.getValue());
      }
    }
    return foundedGoods;
  }
}
