package remoteTesting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest1 {

        @BeforeTest
        public void startDocker() throws IOException, InterruptedException {
                StartDocker start = new StartDocker();
                start.startFile();
        }

        @AfterTest
        public void stopDocker() throws IOException, InterruptedException {
                StartDocker start = new StartDocker();
                start.stopFile();
        }

        @Test
        public void test1 () throws MalformedURLException {
        //Remote WD class
        URL u = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(u,cap);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        }

}
