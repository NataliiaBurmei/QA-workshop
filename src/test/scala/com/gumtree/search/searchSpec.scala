package com.gumtree.search

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{Matchers, FlatSpec}

class searchSpec extends FlatSpec with Matchers with WebBrowser {

    implicit val webDriver: WebDriver = new ChromeDriver()

    go to "http://www.gumtree.com"

    searchField("header-search-q").value = "sofa"
    click on name("search-gumtree")
    val resultTitle = find(cssSelector("h1")).get.text
    resultTitle should include ("ads for sofa")

    close()

}
