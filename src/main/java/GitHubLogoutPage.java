import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GitHubLogoutPage extends PageObject {

    By BtnSignOut = By.cssSelector("[type='submit']");

    public GitHubLogoutPage(WebDriver d) { super(d); }

    protected void assertInPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/logout");

    }

    /**
     * TEMPORARY: Instead of click the way out - navigate to the logout page
     * @return
     */
    public GitHubLogoutPage goToLogoutPage() {
        driver.get("https://github.com/logout");

        return this;
    }

    public void clickLogOutBtn() {
        driver.findElement(BtnSignOut).click();
    }




}
