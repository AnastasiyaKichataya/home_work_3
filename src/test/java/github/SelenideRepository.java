package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Selenide.open;

public class SelenideRepository {

    @BeforeAll
    static void configure() {
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void findSelenideInGithub() {
        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $(".js-repo-nav").$("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}