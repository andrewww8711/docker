package remoteTesting;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeStandAloneTest {

    public static void main(String[] args) throws MalformedURLException {
        
        //Remote WD class
        URL u = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(u,cap);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
    }



}
