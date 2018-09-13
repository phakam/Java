package avajlauncher.air;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.writertofile.*;

public class Helicopter extends Aircraft implements Flyable
{

  private WeatherTower weatherTower;
  Writter obj = new Writter();

  public Helicopter(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }
  public void updateConditions()
  {
      int heightH = this.coordinates.getHeight();
      int longH = this.coordinates.getLongitude();
      int latiH = this.coordinates.getLatitude();
      String weather = this.weatherTower.getWeather(this.coordinates);

      if (weather.equals("RAIN"))
      {
        this.coordinates = new Coordinates(longH + 5, latiH, heightH);
        obj.writetofile("Helicopter#" + this.name + "(" + this.id + ")" + " :So much rain I can't see!");
      }
      else if (weather.equals("SUN"))
      {
        this.coordinates = new Coordinates(longH + 10, latiH, heightH + 2);
        obj.writetofile("Helicopter#" + this.name + "(" + this.id + ")" + " :Haaa the sun is making my view clear up here");
      }
      else if (weather.equals("FOG"))
      {
        this.coordinates = new Coordinates(longH + 1, latiH, heightH);
        obj.writetofile("Helicopter#" + this.name + "(" + this.id + ")" + " :Now I have to fly since I can't see properly");
      }
      else if (weather.equals("SNOW"))
      {
        this.coordinates = new Coordinates(longH, latiH, heightH - 12);
        obj.writetofile("Helicopter#" + this.name + "(" + this.id + ")" + " :My blades are gonna freeze!!");
      }
      else
      {
        System.out.println("Weather not available. Try a different weather");
      }
  }
  public void registerTower(WeatherTower weatherTower)
  {
    obj.writetofile("Tower 1234-543 : Helicopter#" + this.name + "(" + this.id + ")" + " has registered to the Tower" );
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }
  public void unregisterTower(WeatherTower weatherTower)
  {
    obj.writetofile("Tower 1234-543 : Helicopter#" + this.name + "(" + this.id + ")" + " has unregistered to the Tower" );
    this.weatherTower = weatherTower;
    weatherTower.unregister(this);
  }
}
