public class Factorial
{
  public static void main(String [] args)
  {
    int n = Integer.parseInt(args[0]);
    int nFactorial = 1;
    for(int k = 1; k <= n; k++)
    {
      nFactorial = k*nFactorial;
    }
    System.out.println(n + "! = " + nFactorial);
  }
}