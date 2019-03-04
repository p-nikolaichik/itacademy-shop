package com.itacademy.run;

import java.io.IOException;

import com.itacademy.utils.RentUtil;
import com.itacademy.shop.Category;
import com.itacademy.shop.Shop;
import com.itacademy.shop.SportEquipment;
import com.itacademy.user.User;

public class Main {

  public static void main(String[] args) throws IOException {
    Shop shop = new Shop();
    shop.setAvailableGoods();
    shop.printGoodsInfo(Shop.goods);
    User pavel = new User("Pavel");
    System.out.println(pavel.rentItem(new SportEquipment((Category.BICYCLE), "Rapid bike", 10), 2));
    System.out.println(pavel.rentItem(new SportEquipment((Category.BADMINTON), "Rocket", 5), 2));
    RentUtil.printUserRentedSportsEquipment(pavel);
    shop.printSearchResult("5");
  }

}
