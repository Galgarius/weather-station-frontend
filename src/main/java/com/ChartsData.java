package com;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class ChartsData {
  public static class WeatherInfo {
    private Instant instant;
    private int temperature;
    private int humidity;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd:MM:uuuu");
    
    public WeatherInfo(String time, int temperature, int humidity) throws ParseException {
      instant = LocalDate.parse(time, dtf).atStartOfDay().toInstant(ZoneOffset.UTC);
      this.temperature= temperature;
      this.humidity = humidity;
    }

    public Instant getInstant() {
      return instant;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }
    public DateTimeFormatter getDtf(){
      return dtf;
    }
  }
  private List<WeatherInfo> weatherData;

  public ChartsData(){
    try { 
      //for(int i = 0; i<=dataAmount; i++){
      //  weatherData = Arrays.asList(new WeatherInfo(time, temperature, humidity));
      //}
      weatherData = Arrays.asList(
        new WeatherInfo("10:01:2022", 10, 50), 
        new WeatherInfo("11:01:2022", 8, 60), 
        new WeatherInfo("12:01:2022", 11, 40), 
        new WeatherInfo("13:01:2022", 13, 30), 
        new WeatherInfo("14:01:2022", 15, 10), 
        new WeatherInfo("15:01:2022", 10, 85), 
        new WeatherInfo("16:01:2022", 8, 90), 
        new WeatherInfo("17:01:2022", 5, 100)
      );
    }catch (ParseException pe) {
      throw new RuntimeException("This should not happen!", pe);
    }
  }
  public List<WeatherInfo> getWeatherData() {
    return weatherData;
  }
}
