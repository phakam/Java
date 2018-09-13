package avajlauncher.towers;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.writertofile.*;

public interface Flyable
{
  public void updateConditions();
  public void registerTower(WeatherTower WeatherTower);
  public void unregisterTower(WeatherTower weathertower);
}
