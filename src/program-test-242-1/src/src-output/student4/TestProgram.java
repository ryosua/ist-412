public class TestProgram
{
	public static void main(String [ ] args)
	{
		//ArraySearcher Test1
		{
			ArraySearcher program = new ArraySearcher();
			System.out.println("\n" + "Start ArraySearcher Test1 by student4");

			String [] arg = new String[6];
			arg[0]="4";
			arg[1]="4";
			arg[2]="2";
			arg[3]="3";
			arg[4]="1";
			arg[5]="5";

			program.main(arg);
			System.out.println("\n" + "End of ArraySearcher Test1");			

		}

		//ArraySearcher Test2
		{
			ArraySearcher program = new ArraySearcher();
			System.out.println("\n" + "Start ArraySearcher Test2 by student4");

			String [] arg = new String[6];
			arg[0]="3";
			arg[1]="4";
			arg[2]="1";
			arg[3]="2";
			arg[4]="3";
			arg[5]="4";

			program.main(arg);
			System.out.println("\n" + "End of ArraySearcher Test2");			

		}

	/*	/java/bin (unix/mac) answer:
		javac -d $CLASSPATH TestProgram.java
		java TestProgram
	*/
		
	}
}