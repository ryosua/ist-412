import test.SingleTesterTest;
import test.ResultsControllerTest;
import test.FileFilterTest;
import test.BatchTesterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    BatchTesterTest.class,
    FileFilterTest.class,
    ResultsControllerTest.class,
    SingleTesterTest.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
