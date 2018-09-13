package avajlauncher.air;

import avajlauncher.towers.*;
import avajlauncher.air.*;
import avajlauncher.writertofile.*;

public class Aircraft
{
  protected static long idCounter = 0;
  protected String name;
  protected Coordinates coordinates;
  protected long id;

  protected Aircraft(String name, Coordinates coordinates)
  {
    this.id = this.nextId();
    this.name = name;
    this.coordinates = coordinates;
  }
  private long nextId()
  {
    return ++idCounter;
  }
}
