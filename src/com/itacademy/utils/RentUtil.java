package com.itacademy.utils;

import com.itacademy.shop.SportEquipment;
import com.itacademy.user.User;
import java.util.Map.Entry;

import java.util.*;

public class RentUtil {

  private static int userId = 1;

  private static Map<SportEquipment, Integer> rentedSportEquipment = new HashMap<>();

  private static Map<User, Map<SportEquipment, Integer>> users = new HashMap<>();

  private static final String STATUS_SUCCESS = "Ok\n=====================";

  private static final String STATUS_ERROR = "Count of items should be less than 3\n=====================";

  public static String checkAndAddRentedEquipmentToList(User user, SportEquipment sportEquipment, Integer count) {
    Map<SportEquipment, Integer> userAllRentedEquipment = getUserRentedSportEquipment(user);
    if (userAllRentedEquipment != null) {
      Integer countOfRentedSportEquipment = getCountOfUserRentedSportEquipment(userAllRentedEquipment, sportEquipment);
      if (countOfRentedSportEquipment != null) {
        if (count + countOfRentedSportEquipment <= 3) {
          updateRentList(sportEquipment, count + countOfRentedSportEquipment);
          updateUsersInfo(user, sportEquipment, count);
          return STATUS_SUCCESS;
        } else {
          return STATUS_ERROR;
        }
      }
    }
    updateRentList(sportEquipment, count);
    updateUsersInfo(user, sportEquipment, count);
    return STATUS_SUCCESS;
  }

  private static void updateRentList(SportEquipment sportEquipment, Integer count) {
    Integer countOfEquipment = rentedSportEquipment.get(sportEquipment);
    if (countOfEquipment != null) {
      rentedSportEquipment.put(sportEquipment, countOfEquipment + count);
    } else {
      rentedSportEquipment.put(sportEquipment, countOfEquipment);
    }
  }

  private static void updateUsersInfo(User user, SportEquipment sportEquipment, Integer count) {
    Map<SportEquipment, Integer> userEquipments = users.get(user);
    Integer countOfEquipment = null;
    if (userEquipments != null) {
      countOfEquipment = userEquipments.get(sportEquipment);
      if (countOfEquipment != null) {
        userEquipments.put(sportEquipment, countOfEquipment + count);
      } else {
        userEquipments.put(sportEquipment, countOfEquipment);
      }
    } else {
      userEquipments = new HashMap<>();
      userEquipments.put(sportEquipment, countOfEquipment);
    }
    users.put(user, userEquipments);
  }

  public static Map<SportEquipment, Integer> getUserRentedSportEquipment(User user) {
    return users.get(user);
  }

  private static Integer getCountOfUserRentedSportEquipment(Map<SportEquipment, Integer> userRentedGoods, SportEquipment sportEquipment) {
    return userRentedGoods.get(sportEquipment);
  }

  public static boolean isNewUser(User user) {
    return users.get(user) == null ? true : false;
  }

  public static int getNextId() {
    return userId++;
  }

  public static void printUserRentedSportsEquipment(User user) {
    if (!isNewUser(user)) {
      Map<SportEquipment, Integer> userEquipment = users.get(user);
      for (Entry<SportEquipment, Integer> entry : userEquipment.entrySet()) {
        SportEquipment sportEquipment = entry.getKey();
        System.out.println("Category:" + sportEquipment.getCategory().getName() + ", " + "Title:" + sportEquipment.getTitle() + ", " + "Price:" + sportEquipment.getPrice());
      }
      System.out.println("=============================");
    }
  }
}
