package com.itacademy.shop;

public enum Category {

  BICYCLE("Bicycle"), BADMINTON("Badminton"), FOOTBALL("Football");
  
  private String name;
  
  Category(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
