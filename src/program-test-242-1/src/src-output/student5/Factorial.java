public class Factorial {
  public static void main(String [] args) {
      int num = Integer.parseInt(args[0]);
      int factorial = 1;
      for(int x = 1; x <= num; x++){
         factorial = factorial * x; 
      }
      System.out.println("The factorial of "+num+" = "+factorial);
  }
  }