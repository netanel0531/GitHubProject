import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GitHubIssuesTab extends PageObject {

//    String byNewIssuesButtonPrefix = "//div[@class='subnav']//a[@href='/";
//    String byNewIssuesButtonSufix = "/hello-world/issues/new']";

    By BtnNewIssue = By.cssSelector(".btn-primary");

    By BtnMilstonesPage = By.cssSelector("div.subnav-links > :last-child");
    By BtnLabelsPage = By.cssSelector("div.subnav-links > :first-child");

    public GitHubIssuesTab(WebDriver d) { super(d); }

    protected void assertInPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/netanel0531/hello-world/issues");
    }

    public GitHubMilestonesTab clickMilestoneButtonAndGoToMilestonesTab() {
        driver.findElement(BtnMilstonesPage).click();

        return new GitHubMilestonesTab(driver);
    }

    public GitHubNewIssuePage clickNewIssueButtonAndGoToNewIssuePage(/*String mail*/) {
//        String userName = mail.split("@")[0];
//        By newIssuesButton = By.xpath(byNewIssuesButtonPrefix + userName + byNewIssuesButtonSufix);
//        driver.findElement(newIssuesButton).click();
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {}

        driver.findElement(BtnNewIssue).click();

        return new GitHubNewIssuePage(driver);
    }
}
