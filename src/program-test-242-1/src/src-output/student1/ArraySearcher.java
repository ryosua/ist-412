public class ArraySearcher
{
	public static void main(String[] args)
	{
		int nSearch = Integer.parseInt(args[0]);
		int arrayLength = Integer.parseInt(args[1]);
		
		int[] a = new int[arrayLength];
		
		//start at 2 to avoid first two cmd arguments
		for(int i = 2; i < args.length; i++)
		{
			a[i - 2] = Integer.parseInt(args[i]);
		}
		
		int index = searchArray(nSearch, a);
		
		/////////output
		System.out.println("nSearch = " + nSearch);
		System.out.println("arrayLength = " + arrayLength);
		
		for(int j = 0; j < a.length; j++)
		{
			if(j < a.length - 1)
			{
				System.out.print("a[" + j + "] = " + a[j] + "; ");
			}
			else
			{
				System.out.print("a[" + j + "] = " + a[j]);
			}
		}
		
		System.out.println();
		
		if(index != -1)//result found
		{
			System.out.println("First occurence of " + nSearch + " at index " + index);
		}
		else
		{
			System.out.println("nSearch not found.");
		}
		
		//end output
	}
	
	public static int searchArray(int n, int[] a)
	{
		for(int k = 0; k < a.length; k++)
		{
			if(a[k] == n)
			{
				return k;
			}
		}
		
		return -1;
	}
}