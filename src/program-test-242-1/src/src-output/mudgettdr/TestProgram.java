public class TestProgram
{
	public static void main(String [] args)
	{
		// ArraySearcher Test 1
		{
		ArraySearcher program = new ArraySearcher();
        System.out.println();
		System.out.println("Start ArraySearcher by <yourName>");
		String [] arg = new String [6];
		arg[0]="4";
		arg[1]="4";
		arg[2]="2";
		arg[3]="3";
		arg[4]="1";
		arg[5]="5";
		
		program.main(arg);
		System.out.println("End ArraySearcher Test");
		System.out.println();
		}
		
		// ArraySearcher Test 2
		{
		ArraySearcher program = new ArraySearcher();
        System.out.println();
		System.out.println("Start ArraySearcher by <yourName>");
		String [] arg = new String [6];
		arg[0]="3";
		arg[1]="4";
		arg[2]="1";
		arg[3]="2";
		arg[4]="3";
		arg[5]="4";
		
		program.main(arg);
		System.out.println("End ArraySearcher Test");
		System.out.println();
		}
	}
}

// Command-line commands:
// javac -d C:\java\bin TestProgram.java  or javac -d /java/bin TestProgram.java //compile
// java TestProgram //run
// CLASSPATH should be set to C:\java\bin or /java/bin respectively
