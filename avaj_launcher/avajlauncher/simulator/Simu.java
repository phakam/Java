package avajlauncher.simulator;

import java.util.*;
import java.io.*;
import java.lang.*;
import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.writertofile.*;

public class Simu
{
  private static WeatherTower WeatherTower = new WeatherTower();
  private static Writter wrote = new Writter();
  private static List<Flyable> flyables = new ArrayList<Flyable>();

  public static void main(String[] args) throws InterruptedException
  {
    try
    {
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      String line = reader.readLine();
      if (line != null)
      {
        int simulation = Integer.parseInt(line.split(" ")[0]);
        if (simulation < 0)
        {
          System.out.println("Invalid number of Simulations " + simulation);
          System.exit(1);
        }
        while ((line = reader.readLine()) != null)
        {
          Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]),
            Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
          flyables.add(flyable);
        }
        for (Flyable flyable: flyables)
        {
          flyable.registerTower(WeatherTower);
        }
        for (int i = 0; i<= simulation; i++)
        {
          WeatherTower.changeWeather();
        }
      }
    }
    catch(FileNotFoundException no_file)
    {
      System.out.println(no_file.toString());
    }
    catch(IOException ex)
    {
      System.out.println(ex.toString());
    }
  }
};
