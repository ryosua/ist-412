import test.ResultsControllerTest;
import test.FileFilterTest;
import test.BatchTesterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.ApplicationSettingsTest;
import test.BatchConfigReaderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    //working on this //ApplicationSettingsTest.class,
    FileFilterTest.class,
    ResultsControllerTest.class,
    BatchConfigReaderTest.class,
    BatchTesterTest.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
