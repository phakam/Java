package brokerwork;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    //args[0] == market id && args[1] == 1 == buy || args[1] == 2 == sell
    Broker broker = new Broker(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    try
    {
      broker.contact();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}