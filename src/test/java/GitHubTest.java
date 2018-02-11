import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GitHubTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\netanelbr\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test(description = "My GitHub Test")
    public void myGitHubTest() {
        String email = "netanel0531@gmail.com";
        String password = "Netanel8452";

        driver.get("https://github.com/login");

        GitHubLoginPage loginPage = new GitHubLoginPage(driver);
        loginPage = loginPage.navigateToLoginPage();

        GitHubHomePage homePage = loginPage.doLogin(email, password);

        GitHubProjectPage projectPage = homePage.clickOnSecondProjectLinkInRepositoriesListAndGoToItsPage();

        GitHubIssuesTab issuesTab = projectPage.ClickOnIssuesTabAndGoToIssuesTab();




        GitHubMilestonesTab milestonesTab = issuesTab.clickMilestoneButtonAndGoToMilestonesTab();



        GitHubNewMilestonePage newMilstionePage = milestonesTab.clickNewMilestoneBtnAndGoToNewMilstonePage();
        Date d = new Date();
        String milestoneTitle = "MilestoneTitle"+ d.getTime();
        milestonesTab = newMilstionePage.fillMilestoneDetailsAndGoToIssuesPage(
                milestoneTitle, "01", "01", "2200", "Milstone Description");

        issuesTab = projectPage.ClickOnIssuesTabAndGoToIssuesTab();

        GitHubNewIssuePage newIssuePage = issuesTab.clickNewIssueButtonAndGoToNewIssuePage(/*email*/);
        newIssuePage = newIssuePage.submitNewIssue("Test Title", "Test Description", "bug",
                milestoneTitle);

        driver.get("https://github.com/logout");
        GitHubLogoutPage logoutPage = new GitHubLogoutPage(driver);
        logoutPage = logoutPage.goToLogoutPage();
        logoutPage.clickLogOutBtn();

    }
}
