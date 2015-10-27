import test.SingleTesterTest;
import test.ResultsControllerTest;
import test.FileFilterTest;
import test.BatchTesterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.ApplicationSettingsTest;
import test.MainTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    //working on this //ApplicationSettingsTest.class,
    BatchTesterTest.class,
    FileFilterTest.class,
    MainTest.class,
    ResultsControllerTest.class,
    SingleTesterTest.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
