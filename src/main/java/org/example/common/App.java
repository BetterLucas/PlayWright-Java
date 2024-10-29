package org.example.common;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()){

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            //推荐为每个测试创建context
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.bilibili.com");
            page.pause();
        }
    }
}