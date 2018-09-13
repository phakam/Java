package avajlauncher.towers;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import java.util.*;

public class WeatherProvider
{
  private static WeatherProvider weatherProvider = null;
  private static String[] weather = {"RAIN","FOG","SUN","SNOW"};

  private WeatherProvider()
  {}

  public static WeatherProvider getProvider()
  {
    if(weatherProvider == null)
      weatherProvider = new WeatherProvider();
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates)
  {
    int randNum = (int)(Math.random() * weather.length);
    return weather[randNum];
  }
};
