import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GitHubHomePage extends PageObject {

    By firstProject = By.cssSelector(".mini-repo-list .source:first-child"); // By.xpath("(//li[@class='public source'])[1]");
    By secondProject = By.cssSelector(".mini-repo-list .source:nth-child(2)");

    public GitHubHomePage(WebDriver d) {
        super(d);
    }
    protected void assertInPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/");
    }

    public GitHubProjectPage clickOnFirstProjectLinkInRepositoriesListAndGoToItsPage() {
        driver.findElement(firstProject).click();

        return new GitHubProjectPage(driver);
    }

    public GitHubProjectPage clickOnSecondProjectLinkInRepositoriesListAndGoToItsPage() {
        driver.findElement(secondProject).click();

        return new GitHubProjectPage(driver);
    }
}
