package org.example.Demo3;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

public class TestExample{
    static Playwright playwright;
    static Browser browser;

    BrowserContext context;

    Page page;

    @BeforeAll
    static public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
    }

    @AfterAll
    static public void closeBrowser() {
        browser.close();
    }

    @BeforeEach
    public void createContext() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    public void closeContext() {
        context.close();
    }

    @Test
    public void searchContest() {
        page.navigate("https://www.bilibili.com");
        Locator locator = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("赛事"));
        locator.click();
        page.pause();

    }

}
