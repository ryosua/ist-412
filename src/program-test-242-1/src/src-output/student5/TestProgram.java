public class TestProgram{
public static void main(String [] args) {
    
    // javac -d /java/bin TestProgram.java
    // java TestProgram
    // The CLASSPATH variable is TestProgram
    {
        ArraySearcher program = new ArraySearcher();
        System.out.println("Start Array Searcher program by student5");
        String [] arg = new String [5];
        arg[0]="2";
        arg[1]="3";
        arg[2]="2";
        arg[3]="1";
        arg[4]="5";
        program.main(arg);
        System.out.println("End of Array Searcher program"+"\n");
    }
    
    {
        ArraySearcher program = new ArraySearcher();
        System.out.println("Start Array Searcher program by student5");
        String [] arg = new String [6];
        arg[0]="9";
        arg[1]="4";
        arg[2]="3";
        arg[3]="5";
        arg[4]="6";
        arg[5]="9";
        program.main(arg);
        System.out.println("End of Array Searcher program"+"\n");
    }
}
}