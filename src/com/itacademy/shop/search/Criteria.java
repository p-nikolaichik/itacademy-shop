package com.itacademy.shop.search;

import com.itacademy.shop.SportEquipment;

import java.util.Map;

public interface Criteria {
    Map<SportEquipment, Integer> meetCriteria(Map<SportEquipment, Integer> goods, String parameterValue);
}
