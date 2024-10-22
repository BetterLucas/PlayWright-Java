package org.example.Demo1;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class App {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            //无头模式即不展示网站
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();

            page.navigate("http://www.bilibili.com");
            //截图保存至本地
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
            System.out.println(page.title());
            page.pause();

        }
    }
}
