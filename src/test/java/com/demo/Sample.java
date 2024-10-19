package com.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Sample {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeEach
    public void make_setup() {
        String browserType =
                (System.getProperty("webdriver.browser")) == null ||
                        (System.getProperty("webdriver.browser")).isEmpty()
                        ? "chromium" :
                        System.getProperty("webdriver.browser");


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
                throw new IllegalArgumentException("Desteklenmeyen tarayıcı: " + browserType);
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

    }

    @DisplayName("Sample Test 2")
    @Test
    public void test2() {
        page.navigate("https://junit.org/junit5");
        System.out.println(page.title());

    }


}
