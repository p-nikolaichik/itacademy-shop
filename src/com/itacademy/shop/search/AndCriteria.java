package com.itacademy.shop.search;

import com.itacademy.shop.SportEquipment;

import java.util.Map;

public class AndCriteria implements Criteria {

  private Criteria titleCriteria;

  private Criteria categoryCriteria;

  public AndCriteria(Criteria criteria, Criteria otherCriteria) {
    this.titleCriteria = criteria;
    this.categoryCriteria = otherCriteria;
  }

  @Override
  public Map<SportEquipment, Integer> meetCriteria(Map<SportEquipment, Integer> goods, String price) {
    Map<SportEquipment, Integer> foundedGoods = titleCriteria.meetCriteria(goods, price);
    return categoryCriteria.meetCriteria(foundedGoods, price);
  }
}
