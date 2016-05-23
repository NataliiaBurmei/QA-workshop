package com.gumtree.vip

import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{Matchers, FlatSpec}

class SendMailToSellerSpec extends FlatSpec with Matchers with WebBrowser {

  implicit val webDriver: WebDriver = new HtmlUnitDriver

  go to "https://www.gumtree.com/for-sale/london"

  //

}
