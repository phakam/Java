package marketwork;

public class Main
{
  //args[0] == quantity, args[1] == price
  public static void main(String[] args)
  {
    Market market = new Market(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    try
    {
      market.contact();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}