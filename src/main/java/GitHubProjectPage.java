import com.sun.xml.internal.ws.policy.ComplexAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GitHubProjectPage extends PageObject {

//    By issuesTab = By.xpath("(//nav/span)[2]/a");
    By issuesTab =  By.cssSelector("[itemprop='itemListElement']:nth-of-type(2) > a");  // By.xpath("//span[contains(text(),'Issues')]");
    

    public GitHubProjectPage(WebDriver d) { super(d); }

    protected void assertInPage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://github.com/netanel0531/hello-world");
    }

    public GitHubIssuesTab ClickOnIssuesTabAndGoToIssuesTab() {
        driver.findElement(issuesTab).click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        return new GitHubIssuesTab(driver);
    }

}
