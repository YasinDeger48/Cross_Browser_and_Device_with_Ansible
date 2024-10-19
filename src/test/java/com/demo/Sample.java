package com.demo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Sample {

    @DisplayName("Sample Test 1")
    @Test
    public void test1(){

      Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());

    }

    @DisplayName("Sample Test 2")
    @Test
    public void test2(){

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://junit.org/junit5");
        System.out.println(page.title());
    }



}
