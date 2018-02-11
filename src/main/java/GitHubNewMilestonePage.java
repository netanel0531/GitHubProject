import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GitHubNewMilestonePage extends PageObject {

    By newMilestoneTitleTxt = By.id("milestone_title");
    By newMilestoneDueTxt = By.id("milestone_due_on");
    By newMilestoneDescriptionTxt = By.id("milestone_description");
    By submitNewMilesroneBtn = By.cssSelector(".btn-primary");


    public GitHubNewMilestonePage(WebDriver d) { super(d); }

    protected void assertInPage() {
//        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/netanel0531/hello-world/milestones/new");
    }

    public GitHubNewMilestonePage typeToMilestoneTitle(String title) {
        driver.findElement(newMilestoneTitleTxt).sendKeys(title);

        return this;
    }
    public GitHubNewMilestonePage typeToMilestoneDueDate(String mm, String dd, String yyyy) {
        driver.findElement(newMilestoneDueTxt).sendKeys(mm + "/" + dd + "/" + yyyy);

        return this;
    }

    public GitHubNewMilestonePage typeToMilestoneDescription(String description) {
        driver.findElement(newMilestoneDescriptionTxt).sendKeys(description);

        return this;
    }

    public GitHubMilestonesTab clickCreateMilestoneButtonAndGoToMilestonePage() {
        driver.findElement(submitNewMilesroneBtn).click();

        return new GitHubMilestonesTab(driver);
    }

    public GitHubMilestonesTab fillMilestoneDetailsAndGoToIssuesPage(String title, String mm, String dd,
                                                                     String yyyy, String description) {
        typeToMilestoneTitle(title);
        typeToMilestoneDueDate(mm, dd, yyyy);
        typeToMilestoneDescription(description);

        return clickCreateMilestoneButtonAndGoToMilestonePage();
    }


}
