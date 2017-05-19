
import model.Utilities
import org.jsoup.Jsoup

import org.junit._
import Assert._


@Test
class AppTest{

  @Test
  def testVersion() {

    val htmlContent = Jsoup.connect("https://www.google.com").userAgent("Mozilla").get

    assertEquals(Utilities.getHTMLVersion(htmlContent), "HTML 5")

  }

  @Test
  def testLoginForm() {

    val htmlContent = Jsoup.connect("https://www.gmail.com").userAgent("Mozilla").get

    assertEquals(Utilities.hasLoginForm(htmlContent), true)

  }

  @Test
  def testTitle() {

    val htmlContent = Jsoup.connect("https://www.google.com").userAgent("Mozilla").get

    assertEquals(Utilities.getPageTitle(htmlContent), "Google")

  }

  @Test
  def testHeadings() {

    val htmlContent = Jsoup.parse("<html><body><h1></h1></body></html>")

    val map = Map(
      "Total Headings" -> 1,
      "h1" -> 1,
      "h2" -> 0,
      "h3" -> 0,
      "h4" -> 0,
      "h5" -> 0,
      "h6" -> 0)

    assertEquals(Utilities.getHeadingGroupedByHeadingLevels(htmlContent), map)

  }

  @Test
  def testSameDomain(){

    val url1 = "http://comicbook.com/marvel/2017/05/19/avengers-infinity-war-sebastian-stan-winter-soldier-tease/"
    val url2 = "https://www.youtube.com/watch?v=WaxMj5_SLUI"

    assertEquals(Utilities.sameDomainName(url1, url2), false)


  }




}
