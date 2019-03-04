package com.itacademy.parsers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.itacademy.shop.Category;
import com.itacademy.shop.SportEquipment;

public class FileParser {
  
  public Map<SportEquipment, Integer> parseFile(File file) throws IOException {
    Map<SportEquipment, Integer> goods = new HashMap<>();
    Scanner scanner = new Scanner(new FileReader(file));
    while (scanner.hasNext()) {
      String line = scanner.nextLine();
      String[] goodValues = splitLineByOptions(line);
      goods.put(new SportEquipment(Category.valueOf(goodValues[0].toUpperCase()), goodValues[1], Integer.parseInt(goodValues[2])), Integer.parseInt(goodValues[3]));
    }
    return goods;
  }

  private String[] splitLineByOptions(String line) {
    String[] outPut = new String[4];
    String[] parameter = line.split(",");
    for(int i = 0; i < parameter.length; i++) {
      String[] parameterName = parameter[i].split(":");
      outPut[i] = parameterName[1];
    }
    return outPut;
  }

}
