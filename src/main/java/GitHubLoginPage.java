import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GitHubLoginPage extends PageObject{

    By email = By.id("login_field");
    By password = By.id("password");
    By BtnLogin = By.cssSelector(".btn-primary");

    public GitHubLoginPage(WebDriver d) {

        super(d);
        navigateToLoginPage();

    }
    protected void assertInPage() {
//        new WebDriverWait(driver,10).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/login");
    }

    public GitHubLoginPage navigateToLoginPage() {
        driver.get("https://github.com/login");
        return this;
    }

    public void typeToEmailTb(String email) {
        driver.findElement(this.email).sendKeys(email);
    }
    public void typeToPasswordTb(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(this.BtnLogin).click();
    }

    public GitHubHomePage doLogin(String email, String password) {
        typeToEmailTb(email);
        typeToPasswordTb(password);
        clickLoginBtn();

        return new GitHubHomePage(driver);
    }



}
