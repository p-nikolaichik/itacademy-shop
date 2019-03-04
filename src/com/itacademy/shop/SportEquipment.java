package com.itacademy.shop;


public class SportEquipment {
  
  private Category category;
  private String title;
  private int price;
  
  public SportEquipment(Category category, String title, int price) {
    this.category = category;
    this.title = title;
    this.price = price;
  }
  
  public Category getCategory() {
    return category;
  }

  public String getTitle() {
    return title;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    SportEquipment that = (SportEquipment) o;

    if (price != that.price) return false;
    if (category != null ? !category.equals(that.category) : that.category != null) return false;
    return title != null ? title.equals(that.title) : that.title == null;
  }

  @Override
  public int hashCode() {
    int result = category != null ? category.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + price;
    return result;
  }
}
