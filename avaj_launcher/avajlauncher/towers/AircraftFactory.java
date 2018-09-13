package avajlauncher.towers;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.writertofile.*;

public class AircraftFactory
{
  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
  {
    if (longitude > 0 && latitude > 0 && height >= 1)
    {
      Coordinates coord = new Coordinates(longitude, latitude, height);
      if (type.equals("Baloon"))
        return new Baloon(name, coord);
      else if (type.equals("JetPlane"))
        return new JetPlane(name, coord);
      else if (type.equals("Helicopter"))
        return new Helicopter(name, coord);
      else
      {
        System.out.println("Type unknown");
        System.exit(1);
        return null;
      }
    }
    else
    {
      System.out.println("Coordinates are not positive values");
      System.exit(1);
      return null;
    }
  }
}
