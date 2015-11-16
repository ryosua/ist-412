package test;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompilerTest {
        
    @BeforeClass
    public static void setupTests() {
        System.out.println("Starting Tests");   
    }
    
    @Before
    public void setupTest() {
        
    }
    
    @Test
    public void testCompile() {
        fail("Test not implemented");
    }
    
    @After
    public void teardownTest() {
        System.out.println("Test Finished");
    }
    
    @AfterClass
    public static void teardownTests() {
        System.out.println("All Tests Finished");
    }
        
}
