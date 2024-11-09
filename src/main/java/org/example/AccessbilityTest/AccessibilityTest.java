package org.example.AccessbilityTest;

import com.deque.html.axecore.playwright.AxeBuilder;
import com.deque.html.axecore.results.AxeResults;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccessibilityTest {
    @Test
    void shouldNotHaveAutomaticallyDetectableAccessibilityIssues() throws Exception {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://baidu.com/"); // 3
        //扫描页面下元素的访问性问题
        AxeResults accessibilityScanResults = new AxeBuilder(page).analyze(); // 4
        assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations()); // 5
    }
}
