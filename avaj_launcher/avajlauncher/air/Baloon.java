package avajlauncher.air;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.writertofile.*;


public class Baloon extends Aircraft implements Flyable
{
  private WeatherTower BweatherTower;
  Writter obj = new Writter();

  public Baloon(String name, Coordinates coordinates)
  {
    super(name, coordinates);
  }
  public void updateConditions()
  {
    int heightB = this.coordinates.getHeight();
    int longB = this.coordinates.getLongitude();
    int latiB = this.coordinates.getLatitude();
    String weather = this.BweatherTower.getWeather(this.coordinates);

    if (weather.equals("RAIN"))
    {
      this.coordinates = new Coordinates(longB, latiB, heightB - 5);
      obj.writetofile("Baloon#" + this.name + "(" + this.id + ")" + " :The clouds are gonna get my baloon wet!");
    }
    else if (weather.equals("SUN"))
    {
      this.coordinates = new Coordinates(longB + 2, latiB, heightB + 4);
      obj.writetofile("Baloon#" + this.name + "(" + this.id + ")" + " :This sun makes sightseeing so good!");
    }
    else if (weather.equals("SNOW"))
    {
      this.coordinates = new Coordinates(longB, latiB, heightB - 3);
      obj.writetofile("Baloon#" + this.name + "(" + this.id + ")" + " :I'm freezing in here!!");
    }
    else if (weather.equals("FOG"))
    {
      this.coordinates = new Coordinates(longB, latiB, heightB - 15);
      obj.writetofile("Baloon#" + this.name + "(" + this.id + ")" + " :I can't see much but I'm sure I saw a bird flying past");
    }
    else
    {
      System.out.println("Weather not available. Try a different weather");
      System.exit(1);
    }
    if(this.coordinates.getHeight() <= 0)
      unregisterTower(BweatherTower);
  }

  public void registerTower(WeatherTower weathertower)
  {
    obj.writetofile("Tower 1234-543 : Baloon#" + this.name + "(" + this.id + ")" + " has registered to the Tower" );
    this.BweatherTower = weathertower;
    weathertower.register(this);
  }

  public void unregisterTower(WeatherTower weathertower)
  {
    obj.writetofile("Tower 1234-543 : Baloon#" + this.name + "(" + this.id + ")" + " has unregistered to the Tower" );
    this.BweatherTower = weathertower;
    weathertower.unregister(this);
  }
}
