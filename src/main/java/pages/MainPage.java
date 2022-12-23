package pages;

public class MainPage {
    public static String PAGE_URL = "https://www.amazon.in/";

    public String hamburgerMenu = "#nav-hamburger-menu";
    public String hamburgerMenuOpened = ".hmenu-opaque";
    public String hamburgerMenuMainItems = ".hmenu-item div";
    public String hamburgerMenuItems = "[data-menu-id='9'] .hmenu-item";
    public String filterMenuItem = "#s-refinements li:nth-child(1) a";
    public String pricesDropdownSelect = "[data-action='a-dropdown-button']";
    public String pricesDropdownSelectItem = ".a-dropdown-item";
    public String secondResult = "[data-index='2']";

    public boolean assertCurrentUrl(String currentUrl) {
        return currentUrl.equals(PAGE_URL);
    }


}