package uk.co.vwfsins.webControls;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import uk.co.vwfsins.browsers.WebDriverFactory;


public class JavaScriptControl extends BaseControl{
    private static WebDriver driver = WebDriverFactory.getThreadedDriver();


    public static Object runJsScript(String script){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return js.executeScript(script);
    }
}
