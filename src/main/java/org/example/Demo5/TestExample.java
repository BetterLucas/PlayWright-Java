package org.example.Demo5;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;


import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@UsePlaywright(TestExample.CustomOptions.class)
public class TestExample {

    public static class CustomOptions implements OptionsFactory {

        @Override
        public Options getOptions() {
            return new Options()
                    .setHeadless(false)
                    .setContextOptions(new Browser.NewContextOptions().setBaseURL("https://www.baidu.com"))
                    .setApiRequestOptions(new APIRequest.NewContextOptions().setBaseURL("https://www.bilibili.com"));

        }
    }


    @Test
    void basicTest(Page page, APIRequestContext requestContext) {
        page.navigate("/");
        assertThat(page).hasURL(Pattern.compile("baidu"));
        APIResponse response = requestContext.get("/");
        assertTrue(response.text().contains("bilibili"));
    }
}
