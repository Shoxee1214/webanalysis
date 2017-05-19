
// @GENERATOR:play-routes-compiler
// @SOURCE:E:/JsoupWebAPPFinalTEst/JsoupWebAPp/conf/routes
// @DATE:Sat May 20 02:12:34 PKT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    router.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""GET""", prefix, """controllers.Application.index"""),
    ("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/url/$t<[^/]+>""", """controllers.Application.getPage(t:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    controllers.Application.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_getPage1_route: Route.ParamsExtractor = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/url/"), DynamicPart("t", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getPage1_invoker = createInvoker(
    controllers.Application.getPage(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getPage",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """api/url/$t<[^/]+>"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Assets_at2_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at2_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
      }
  
    // @LINE:7
    case controllers_Application_getPage1_route(params) =>
      call(params.fromPath[String]("t", None)) { (t) =>
        controllers_Application_getPage1_invoker.call(controllers.Application.getPage(t))
      }
  
    // @LINE:8
    case controllers_Assets_at2_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at2_invoker.call(controllers.Assets.at(path, file))
      }
  }
}