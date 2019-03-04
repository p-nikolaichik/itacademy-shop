package com.itacademy.shop;

import com.itacademy.parsers.FileParser;
import com.itacademy.user.User;

import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;

public class Shop {
  
  private static final String pathToFile = "src/com/itacademy/data/testdata";
  
  public static Map<SportEquipment, Integer> goods;
  
  public void setAvailableGoods() throws IOException {
    goods = new HashMap();
    goods = new FileParser().parseFile(new File(pathToFile));
  }
  
  public void printGoodsInfo(Map<SportEquipment, Integer> goods) {
    for (Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      SportEquipment sportEquipment = entry.getKey();
      System.out.println("Category:" + sportEquipment.getCategory().getName() + ", " + "Title:" + sportEquipment.getTitle() + ", " + "Price:" + sportEquipment.getPrice());
    }
    System.out.println("=============================");
  }
  
  public static boolean isGoodAvailableInShop(SportEquipment sportEquipment) {
    for (Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      if (entry.getKey().getTitle().equalsIgnoreCase(sportEquipment.getTitle())) {
        return goods.get(sportEquipment) >= 1;
      }
    }
    return false;
  }

  public void printSearchResult(String searchText) {
    Map<SportEquipment, Integer> result = new HashMap<>();
    for (Entry<SportEquipment, Integer> entry : goods.entrySet()) {
      SportEquipment sportEquipment = entry.getKey();
      String equipmentTitle = sportEquipment.getTitle().toUpperCase();
      String equipmentCategory = sportEquipment.getCategory().getName().toUpperCase();
      String price = String.valueOf(sportEquipment.getPrice());
      //Integer countOfGood = entry.getValue();
      String searchTextInUpperCase = searchText.toUpperCase();
      if (searchTextInUpperCase.contains(equipmentTitle) || searchTextInUpperCase.contains(equipmentCategory) || searchTextInUpperCase.contains(price)) {
        result.put(entry.getKey(), entry.getValue());
      }
    }
    printGoodsInfo(result);
  }
}
