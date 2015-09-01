public class ArraySearcher
{
  public static void main(String [] args)
  {
    int nSearch = Integer.parseInt(args[0]);
	int arrayLength = Integer.parseInt(args[1]);
	int [] a = new int [arrayLength];
	for(int k = 0; k < arrayLength; k++)
	{
	  a[k] = Integer.parseInt(args[k+2]);
	}
	int index = searchArray(nSearch, a);
	System.out.println("nSearch = " + nSearch);
	System.out.println("arrayLength = " + arrayLength);
	System.out.print("a[0] = " + a[0]);
	for(int k = 1; k < arrayLength; k++)
	{
	  System.out.print("; a[" + k + "] = " + a[k]);
	}
	System.out.println();
	if(index == -1)
	{
	  System.out.println("nSearch not found.");
	}
	else
	{
	  System.out.println("First occurence of " + nSearch + " at index " + index);
	}
  }
  
  public static int searchArray(int n, int [] a)
  {
    int index = -1;
    for(int k = 0; k < a.length; k++)
	{
	  if(a[k] == n) {index = k;}
	  if(index != -1) {break;}
	}
	return index;
  }
}