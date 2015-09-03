public class ArraySearcher {
  public static void main(String [] args) {
      int nSearch = Integer.parseInt(args[0]);
      int arrayLength = Integer.parseInt(args[1]);
      int [] a = new int[arrayLength];
      int counter = 2;
      for(int z = 0; z < arrayLength; z++){
          a[z] = Integer.parseInt(args[counter]);
          counter++;
      }
      int index = searchArray(nSearch,a);
      printArray(a);
      if(index == -1)
          System.out.println("nSearch not found");
      else
          System.out.println("First occurence of "+nSearch+" at index "+index);
  }
    public static int searchArray(int n, int[] a){
        for(int x = 0; x < a.length; x ++){
            if(n == a[x])
                return x;
        }
        return -1;
    }
    public static void printArray(int[] x){
        for(int z = 0; z < x.length; z++){
           System.out.print(" a["+z+"]="+x[z]); 
        }
        System.out.println();
    }
}