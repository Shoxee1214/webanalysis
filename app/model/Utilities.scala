package model

import org.jsoup.nodes.Document
import org.jsoup.nodes.DocumentType
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import play.api.libs.json._
import java.net.URL
import java.net.URI

/**
  * @author shahroz
  */
object Utilities {

  def startAnalysis(url: String): JsValue = {

    val document = connect(url)
    val htmlVersion = getHTMLVersion(document)
    val pageTitle = getPageTitle(document)
    val numHeadings = getHeadingGroupedByHeadingLevels(document)
    val numHypermedia = getHyperMediaLinks(url, document)
    val hasLogIn = hasLoginForm(document)

    val result: Seq[Map[String, JsValue]] = Seq(Map(
      "HTML Version" -> Json.toJson(htmlVersion),
      "Page Title" -> Json.toJson(pageTitle),
      "Number of Headings" -> Json.toJson(numHeadings),
      "Hypermedia Links" -> Json.toJson(numHypermedia),
      "Has Login Form" -> Json.toJson(hasLogIn)))

    Json.toJson(result)

  }

  def connect(url: String) = {

    Jsoup.connect(url).userAgent("Mozilla").get

  }

  def hasLoginForm(document: Document): Boolean = {

    !document.select("input[type=password]").isEmpty()

  }

  def getHTMLVersion(document: Document): String = {

    document.childNodes().toArray.foreach { node =>

      if (node.isInstanceOf[DocumentType]) {
        val documentType = node.asInstanceOf[DocumentType]
        if (documentType.attr("publicId").isEmpty && documentType.attr("systemId").isEmpty()) {
          return "HTML 5"
        } else {
          return "HTML 4"
        }
      }

    }

    return "HTML less than 4"
  }

  def getPageTitle(document: Document): String = {
    document.title()
  }

  def getHeadingGroupedByHeadingLevels(document: Document): Map[String, Int] = {

    val doc = document.select("h1, h2, h3, h4, h5, h6")

    Map(
      "Total Headings" -> doc.size(),
      "h1" -> doc.select("h1").size,
      "h2" -> doc.select("h2").size,
      "h3" -> doc.select("h3").size,
      "h4" -> doc.select("h4").size,
      "h5" -> doc.select("h5").size,
      "h6" -> doc.select("h6").size)

  }

  def getHyperMediaLinks(givenURL: String, document: Document): Map[String, Int] = {

    val media = document.select("[src]")

    val mediaURLs = media.toArray().map { link =>
      link.asInstanceOf[Element].attr("abs:src")
    }

    val links = document.select("a[href]")

    val linksURLs = links.toArray().map { link =>
      link.asInstanceOf[Element].attr("abs:href")
    }

    val imports = document.select("link[href]")

    val importsURLs = imports.toArray().map { link =>
      link.asInstanceOf[Element].attr("abs:href")
    }

    val allURLs = (mediaURLs ++ linksURLs ++ importsURLs).filter { !_.isEmpty() }

    var external = 0
    var internal = 0

    allURLs.map { url =>

      if (getURI(getURL(url)).isAbsolute() && !sameDomainName(givenURL, url)) {
        external += 1
      } else {
        internal += 1
      }

    }

    Map("Valid Total (Links, Media, Imports)" -> allURLs.size,
      "Valid Links (URLs)" -> links.size,
      "Valid Media (URLs)" -> media.size,
      "Valid Imports (URLs)" -> imports.size,
      "Internal Links" -> internal,
      "External Links" -> external)

  }

  def sameDomainName(givenUrl: String, innerUrl: String): Boolean = {

    if (getURL(givenUrl).getHost == getURL(innerUrl).getHost ||
      getURL(innerUrl).getHost.endsWith(getURL(givenUrl).getHost)) {
      true
    } else {
      false
    }

  }

  def getURL(link: String): URL = {

    new URL(link)
  }

  def getURI(url: URL): URI = {
    new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null)

  }



}