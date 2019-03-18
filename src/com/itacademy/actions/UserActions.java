package com.itacademy.actions;

import com.itacademy.shop.SportEquipment;
import com.itacademy.shop.search.SearchOptions;

public interface UserActions {

  String rentItem(SportEquipment sportEquipment, int count);
  
  void findGood(SearchOptions searchOptions);
}
