package com.gumtree.login

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest.selenium.WebBrowser
import org.scalatest.{Matchers, FlatSpec}


class loginSpec extends FlatSpec with Matchers with WebBrowser{

  implicit val webDriver: WebDriver = new ChromeDriver()

  go to "http://www.gumtree.com"
  click on cssSelector("li.header-nav-login")
  webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)
//  val emailAddress = find(id("email"))
  emailField("email").underlying.sendKeys("")
//  val password = find(id("fld-password"))
  pwdField("fld-password").underlying.sendKeys("")
  submit()

  close()

}
