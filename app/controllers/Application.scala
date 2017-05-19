package controllers

import java.net.URLDecoder


import play.api.mvc._

/*case class WebRequest(url: String)
object WebRequest {
  implicit val jsonFormat = Json.format[WebRequest]
}*/

/*case class Webpage(source: String)
object Webpage {
  implicit val jsonFormat = Json.format[Webpage]
  val dummy = Webpage(source = """<html><head></head><body>My webpage.</body></html>""")

}*/

object Application extends Controller {
  def index = Action {
    Ok(views.html.main("WebAnalysis"))
  }

  def getPage(url:String) = Action { implicit request =>
    val decodedURL =URLDecoder.decode(url,"UTF-8")
    Ok(model.Utilities.startAnalysis(decodedURL))
  }
}