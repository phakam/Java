package avajlauncher.towers;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import java.util.*;
import avajlauncher.writertofile.*;

public class WeatherTower extends Tower
{
  public String getWeather(Coordinates coordinates)
  {
    String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
    return weather;
  }
  public void changeWeather()
  {
    this.conditionsChanged();
  }
}
