public class Factorial
{
	public static void main(String[] args)
	{
		int inputNum = Integer.parseInt(args[0]);
		int factorial = 1;
		
		System.out.println("N = 10");
		
		System.out.print(inputNum + "! = ");
		
		for(int i = 1; i <= inputNum; i++)
		{
			factorial = factorial  * i;
			
			if(i < inputNum)
			{
				System.out.print(i + "*");
			}
			else
			{
				System.out.print(i + " = " + factorial);
			}
		}
	}
}