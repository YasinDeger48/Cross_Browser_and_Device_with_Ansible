package com.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Sample {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeEach
    public void make_setup() {
        String browserType = Optional.ofNullable(System.getProperty("webdriver.browser"))
                .filter(b -> !b.isEmpty())
                .orElse("chromium");


        playwright = Playwright.create();

        switch (browserType) {
            case "chromium":
                browser = playwright.chromium().launch();
                break;
            case "firefox":
                browser = playwright.firefox().launch();
                break;
            case "webkit":
                browser = playwright.webkit().launch();
                break;
            default:
                throw new IllegalArgumentException("Unsupported Browser: " + browserType);
        }

        page = browser.newPage();

    }

    @AfterEach
    public void tearDown() {
        browser.close();
    }

    @DisplayName("Sample Test 1")
    @Test
    public void test1() {
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
        assertThat(page).hasTitle("Fast and reliable end-to-end testing for modern web apps | Playwright");
    }

    @DisplayName("Sample Test 2")
    @Test
    public void test2() {
        page.navigate("https://junit.org/junit5");
        System.out.println(page.title());
        assertThat(page).hasTitle("JUnit 5");

    }


}
