import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    WebDriver driver;

    public PageObject(WebDriver d) {
        this.driver = d;

        assertInPage();
    }
    public void waitForAjax()
    {

        while (true)
        {

            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return window.jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }
    }

    public void waitForLoad(WebDriver driver) {
        System.out.println("Waiting");
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    protected abstract void assertInPage();
}
