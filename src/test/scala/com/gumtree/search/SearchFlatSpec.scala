package com.gumtree.search

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{FlatSpec, Matchers}


class SearchFlatSpec extends FlatSpec with Matchers with WebBrowser{

  implicit val webDriver: WebDriver = new ChromeDriver()

  go to "http://www.airbnb.co.uk"

  textField("location").value = "London"
  click on id("submit_location")
  val searchResults = find(cssSelector("div.listings-container")).get
  searchResults.isDisplayed shouldEqual true

  checkbox("room-type").select()
  val home = find(partialLinkText("Entire home/flat")).get
  checkbox("room-type").isSelected should be (true)
  home should be ("Entire home/flat")

  close()

}
