public class TestProgram {

	//Command to compile
	//javac -d \Java\bin TestProgram.java

	//ClassPath location
	//C:\Java\bin
	
	public static void main(String args[])
	{
		ArraySearcher.main(new String[]{"4","4","2","3","1","5"});
		
		System.out.println();
		
		ArraySearcher.main(new String[]{"3","4","1","2","3","4"});
	}
}