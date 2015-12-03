package test;

import controller.Main;
import java.io.File;
import model.Strings;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

    private Main main;

    @BeforeClass
    public static void setupTests() {

    }

    @Before
    public void setupTest() {
        File settingsFile = new File(Strings.SETTINGS_FILE_NAME);
        main = new Main(settingsFile);
    }

    @Test
    public void frameCreated() {
        main.openFrame();
        Assert.assertNotNull("frame is null", main.getFrame());
    }

    @Test
    public void fileChooserNotNull() {
        Assert.assertNotNull("fileChooser is null", main.getFileChooser());
    }

    @Test
    public void settingsNotNull() {
        Assert.assertNotNull("settings is null", main.getSettings());
    }

    @After
    public void teardownTest() {

    }

    @AfterClass
    public static void teardownTests() {

    }
}
