package com.gumtree.search

import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{Matchers, FlatSpec}

class getTitleSpec extends FlatSpec with Matchers with WebBrowser{

  implicit val webDriver: WebDriver = new HtmlUnitDriver

  go to "http://www.gumtree.com"

  pageTitle should be ("Gumtree | Free classified ads from the #1 classifieds site in the UK")

  println(pageTitle)
}
