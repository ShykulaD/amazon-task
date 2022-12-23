import com.codeborne.selenide.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ItemPage;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static pages.MainPage.PAGE_URL;

public class AmazonTest {
    public MainPage mainPage = new MainPage();
    public ItemPage itemPage = new ItemPage();

    @Test(description = "Get the description about the second-highest TV set")
    public void aboutThisItemLogTest() {
        Configuration.browserSize = "1920x1080";

        open(PAGE_URL);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        if (!mainPage.assertCurrentUrl(currentUrl)) {
            open(PAGE_URL);
        }
        Assert.assertEquals(PAGE_URL, currentUrl, "Url didn't match, actual url is " + currentUrl);

        SelenideElement hamburgerMenu = $(mainPage.hamburgerMenu);
        hamburgerMenu.isDisplayed();
        hamburgerMenu.click();

        $(mainPage.hamburgerMenuOpened).isDisplayed();

        $$(mainPage.hamburgerMenuMainItems).find(text("TV, Appliances, Electronics")).scrollTo().click();
        $$(mainPage.hamburgerMenuItems).find(text("Televisions")).scrollTo().click();

        $$(mainPage.filterMenuItem).find(text("Samsung")).scrollTo().click();

        $(mainPage.pricesDropdownSelect).isDisplayed();
        $(mainPage.pricesDropdownSelect).click();
        $$(mainPage.pricesDropdownSelectItem).find(text("Price: High to Low")).scrollTo().click();

        $(mainPage.secondResult).click();

        // Switch to new tab with the second-highest item price
        switchTo().window(1);
        $(itemPage.aboutThisItemTitle).isDisplayed();
        String aboutThisItemText = $(itemPage.aboutThisItemText).getText();
        System.out.println(aboutThisItemText);
    }
}
