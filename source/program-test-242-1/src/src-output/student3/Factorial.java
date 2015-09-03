public class Factorial{

	public static void main(String[] args){
		
		int n = Integer.parseInt(args[0]);
		System.out.println("n = " + n);
		int z = 1;
		for(int i = 1; i <= n; i++){
			z = z * i;
		}
		System.out.println(z);
	}

}