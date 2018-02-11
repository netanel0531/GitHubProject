import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GitHubMilestonesTab extends PageObject {

    By BtnNewMilestone = By.cssSelector(".btn-primary");

    public GitHubMilestonesTab(WebDriver d) { super(d); }

    protected void assertInPage() {
//        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/netanel0531/hello-world/milestones");
    }

    public GitHubNewMilestonePage clickNewMilestoneBtnAndGoToNewMilstonePage() {
        driver.findElement(BtnNewMilestone).click();

        return new GitHubNewMilestonePage(driver);
    }
}
