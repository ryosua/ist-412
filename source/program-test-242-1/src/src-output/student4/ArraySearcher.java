public class ArraySearcher
{
	public static void main(String [ ] args)
	{
		int nSearch = Integer.parseInt(args[0]);
		int arrayLength = Integer.parseInt(args[1]);

		int[] a = new int[arrayLength];

		for(int i = 0; i<arrayLength; i++)
		{
			a[i] = Integer.parseInt(args[i+2]);
		}

		int value = searchArray(nSearch, a);

		System.out.println("nSearch = " + nSearch);
		System.out.println("arrayLength = " + arrayLength);

		for(int j = 0; j<arrayLength; j++)
		{
			System.out.print("a[" + j + "] = " + a[j] + "; ");
		}

		System.out.println();

		if(value == -1)
		{
			System.out.println("nSearch not found.");
		}

		else
		{
			System.out.println("First occurance of " + nSearch + " at index " + value);
		}

	}

	public static int searchArray(int n, int a[])
	{
		//int i = 0;
		int k;

		for(int i = 0; i<a.length; i++)
		{
			if(a[i] == n)
			{
				k = i;
				//break;
				return k;
			}
		}

		return -1;
		//if(i == a.length)
		//{
		//	i = -1;
		//}

		//return i;

	/*	while (a[i] != n)
		{
			i++;
		}

		if(i == n)
		{
			i = -1;
		}

		return i;
	*/

	}
}