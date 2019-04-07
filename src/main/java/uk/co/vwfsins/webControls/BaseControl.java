package uk.co.vwfsins.webControls;

import uk.co.vwfsins.waits.WebWaits;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import uk.co.vwfsins.utilities.EnvConfig;


public abstract class BaseControl {


    protected static int time = Integer.parseInt(EnvConfig.getValue("default.timer"));
    private static Logger logger = LogManager.getLogger("TestLogger");


    protected static boolean isElementDisplayed(WebElement element){
        for(int i = 0; i < time; i++){
            if(element.isDisplayed()){
                logger.info("Element is displayed");
                return true;
            }else {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
        return false;
    }

    protected static boolean isElementSelected(WebElement element){
        for(int i = 0; i < time; i++){
            if(element.isSelected()){
                boolean status = element.isSelected();
                logger.info("The element selected status is "+status);
                return true;
            }else {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
        return false;
    }

    protected static boolean isElementEnabled(WebElement element){
        for(int i = 0; i < time; i++){
            if(element.isEnabled()){
                logger.info("The element enabled status is "+element.isEnabled());
                return true;
            }else {
                WebWaits.waitForNoOfSeconds(1);
            }
        }
        return false;
    }













}
