import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GitHubNewIssuePage extends PageObject {

    By InputTitle = By.id("issue_title");
    By InputDescription = By.id("issue_body");
    By BtnSubmit = By.cssSelector(".form-actions [type]"); //By.xpath("//div[@class='form-actions']/button");

    By BtnLabel = By.cssSelector(".label-select-menu"); //By.xpath("(//div[@class='discussion-sidebar']/div)[2]/div/div[1]");
    By InputLabel = By.id("label-filter-field");

    By BtnMilestone = By.cssSelector(".sidebar-milestone button");
    By milestoneTxt = By.id("context-milestone-filter-field");


    public GitHubNewIssuePage(WebDriver d) { super(d); }

    protected void assertInPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/netanel0531/hello-world/issues/new");
    }

    public GitHubNewIssuePage typeNewIssueTitle(String title) {
        driver.findElement(InputTitle).sendKeys(title);

        return this;
    }

    public GitHubNewIssuePage typeNewIssueDescription(String description) {
        driver.findElement(InputDescription).sendKeys(description);

        return this;
    }

    public GitHubNewIssuePage clickLabalBtn() {
        driver.findElement(BtnLabel).click();

        return this;
    }

    /**
     * Type an exists label
     * @param label
     * @return
     */
    public GitHubNewIssuePage insertLabelNameInLabelTb(String label) {
        driver.findElement(InputLabel).sendKeys(label);

        return this;
    }

    public GitHubNewIssuePage clickSubmitBtn() {
        driver.findElement(BtnSubmit).click();

        return this;
    }

    public GitHubNewIssuePage clickMilestoneBtn() {
        driver.findElement(BtnMilestone).click();

        return this;
    }

    public GitHubNewIssuePage typeToMilestone(String milestone) {
        driver.findElement(milestoneTxt).sendKeys(milestone);

        return this;
    }

    public GitHubNewIssuePage submitNewIssue(String title, String description, String label) {
        typeNewIssueTitle(title);

        typeNewIssueDescription(description);

        clickLabalBtn();

        insertLabelNameInLabelTb(label);
        driver.findElement(InputLabel).sendKeys(Keys.ENTER);
        driver.findElement(InputLabel).sendKeys(Keys.ESCAPE);

        clickSubmitBtn();

        return  this;
    }

    public GitHubNewIssuePage submitNewIssue(String title, String description, String label, String milestone) {
        typeNewIssueTitle(title);

        typeNewIssueDescription(description);

        clickLabalBtn();

        insertLabelNameInLabelTb(label);
        driver.findElement(InputLabel).sendKeys(Keys.ENTER);
        driver.findElement(InputLabel).sendKeys(Keys.ESCAPE);

        clickMilestoneBtn();
        typeToMilestone(milestone);
        driver.findElement(milestoneTxt).sendKeys(Keys.ENTER);

        clickSubmitBtn();

        return  this;
    }

}
