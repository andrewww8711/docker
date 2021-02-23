package remoteTesting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest2 {

        @Test
        public void test2() throws MalformedURLException {
        //Remote WD class
        URL u = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(u,cap);
        driver.get("http://www.gmail.com");
        System.out.println(driver.getTitle());
    }
}
