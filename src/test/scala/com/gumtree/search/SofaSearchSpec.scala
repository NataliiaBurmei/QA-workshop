package com.gumtree.search

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers, FlatSpec}

class SofaSearchSpec extends FeatureSpec with Matchers with WebBrowser with GivenWhenThen {

    feature("Search sofa ad") {


        scenario("Verify I can find sofa ad") {
            implicit val webDriver: WebDriver = new FirefoxDriver()

            Given("I am on Home page on Gumtree")
            go to "http://www.gumtree.com"

            When("I look for sofa ad")
            searchField("header-search-q").value = "sofa"
            click on name("search-gumtree")

            Then("I see sofa ads on SRP")
            val resultTitle = find(cssSelector("h1")).get.text
            resultTitle should include("ads for sofa")

            close()
        }

        scenario("Verify I can filter urgent sofa ads") {
            implicit val webDriver: WebDriver = new FirefoxDriver()

            Given("I am on SRP page")
            go to "https://www.gumtree.com/search?search_category=for-sale&q=sofa"

            When("I filter by Urgent ads")
            val urgentAd = find(cssSelector("label[for='urgent_filter']")).get
            val update = find(cssSelector("button[name='refine']")).get
            click on urgentAd
            click on update

            Then("I see only them")
            val urgentLabel = find(cssSelector("strong.label-urgent")).get
            urgentLabel.isDisplayed shouldEqual true

            close()
        }
    }
}

