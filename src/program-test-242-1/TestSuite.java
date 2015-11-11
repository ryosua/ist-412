import test.ResultsControllerTest;
import test.FileFilterTest;
import test.BatchTesterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.ApplicationSettingsTest;
import test.MainTest;
import test.StudentReaderTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MainTest.class,
    ApplicationSettingsTest.class,
    FileFilterTest.class,
    ResultsControllerTest.class,
    StudentReaderTest.class,
    BatchTesterTest.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
