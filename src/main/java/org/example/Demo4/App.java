package org.example.Demo4;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        //跟踪当前context下的操作
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page = context.newPage();
        page.navigate("https://www.bilibili.com");

        //停止跟踪并导出到文件中
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
    }
}
