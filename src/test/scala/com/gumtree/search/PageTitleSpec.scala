package com.gumtree.search

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{Matchers, FlatSpec}

class PageTitleSpec extends FlatSpec with Matchers with WebBrowser{

  implicit val webDriver: WebDriver = new ChromeDriver

  go to "http://www.gumtree.com"

  "Gumtree home page" should "have correct title" in {

    pageTitle should be("Gumtree | Free classified ads from the #1 classifieds site in the UK")

    close()
  }
}
