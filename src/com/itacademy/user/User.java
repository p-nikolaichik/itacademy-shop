package com.itacademy.user;

import com.itacademy.utils.RentUtil;
import com.itacademy.actions.UserActions;
import com.itacademy.shop.Shop;
import com.itacademy.shop.SportEquipment;
import com.itacademy.shop.search.SearchOptions;

public class User implements UserActions{
  
  private String name;

  private int id;

  {
    id = RentUtil.getNextId();
  }

  public User(String name) {
    this.name = name;
  }

  public String rentItem(SportEquipment sportEquipment, int count) {
    if (Shop.isGoodAvailableInShop(sportEquipment)) {
      return RentUtil.checkAndAddRentedEquipmentToList(this, sportEquipment, count);
    }
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (id != user.id) return false;
    return name != null ? name.equals(user.name) : user.name == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + id;
    return result;
  }

  @Override
  public void findGood(SearchOptions searchOptions) {
    
  }

}
