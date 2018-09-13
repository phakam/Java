package avajlauncher.air;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.writertofile.*;

public class JetPlane extends Aircraft implements Flyable
{
  private WeatherTower weatherTower;
  Writter obj = new Writter();

  public JetPlane(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }
  public void updateConditions()
  {
    int heightJ = this.coordinates.getHeight();
    int longJ = this.coordinates.getLongitude();
    int latiJ = this.coordinates.getLatitude();
    String weather = this.weatherTower.getWeather(this.coordinates);

    if (weather.equals("RAIN"))
    {
      this.coordinates = new Coordinates(longJ, latiJ + 5, heightJ);
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " :Rain you're messed up my vision!");
    }
    else if (weather.equals("SUN"))
    {
      this.coordinates = new Coordinates(longJ, latiJ + 10, heightJ + 2);
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " :Now I can shoot missiles with no distraction");
    }
    else if (weather.equals("FOG"))
    {
      this.coordinates = new Coordinates(longJ, latiJ + 1, heightJ);
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " : Damn now I can't see my enemies properly");
    }
    else if (weather.equals("SNOW"))
    {
      this.coordinates = new Coordinates(longJ, latiJ, heightJ - 7);
      obj.writetofile("JetPlane#" + this.name + "(" + this.id + ")" + " : SNOW!! You are messing with my engine!");
    }
    else
    {
      System.out.println("Weather not available. Try a different weather");
    }
  }
  public void registerTower(WeatherTower weatherTower)
  {
    obj.writetofile("Tower 1234-543 : JetPlane#" + this.name + "(" + this.id + ")" + " has registered to the Tower" );
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }
  public void unregisterTower(WeatherTower weatherTower)
  {
    obj.writetofile("Tower 1234-543 : JetPlane#" + this.name + "(" + this.id + ")" + " has unregistered to the Tower" );
    this.weatherTower = weatherTower;
    weatherTower.unregister(this);
  }
}
