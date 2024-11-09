package org.example.Actions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Actions {
    static Playwright playwright;

    static Browser browser;

    BrowserContext context;

    Page page;

    @BeforeAll
    public static void init() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    public void initContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    void actionTest() {
        /*获取对应文本并点击*/
        page.navigate("file:///F:/ToLearn/ForPlayWright/TestPage.html");
//        page.getByRole(AriaRole.BUTTON).click();
        page.getByText("百度").click();
    }

    @Test
    void actionTest2() {
        //定位输入框并输入字符
        page.navigate("www.baidu.com");
        page.getByRole(AriaRole.TEXTBOX).fill("java");
        String val = page.getByRole(AriaRole.TEXTBOX).inputValue();
        assertEquals(val, "java");
        System.out.println(val);
    }

}
