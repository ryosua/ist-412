public class Factorial
{
	public static void main(String [ ] args)
	{
		int n = Integer.parseInt(args[0]);

		//Int[] factorial = new Int[n];

		int factorial = 1;

		for(int i = n; i>0; i--)
		{
			factorial = factorial * i;
		}

		System.out.println("The factorial of n = " + factorial);
	}
}