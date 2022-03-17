package com;

import java.util.Random;

public class TestDataGenerator {
  public static int generateTemp(int min, int max){
    Random rand = new Random();  
    return rand.nextInt(min, max + 1);
  }
  public static int generateHumid() {
    Random rand = new Random();  
    return rand.nextInt(0, 100 + 1);
  }
}
