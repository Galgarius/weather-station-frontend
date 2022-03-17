package com.example.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherStat {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  private int temp;
  private int humid;

  public WeatherStat(int temp, int humid){
    this.temp = temp;
    this.humid = humid;
  }
  public WeatherStat(int id, int temp, int humid){
    this.temp = temp;
    this.humid = humid;
    this.id = id;
  }
  public int getTemp(){
    return this.temp;
  }
  public int getHumid(){
    return this.humid;
  }
  public int getId(){
    return this.id;
  }
}