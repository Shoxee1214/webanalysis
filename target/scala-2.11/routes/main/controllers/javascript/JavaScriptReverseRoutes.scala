
// @GENERATOR:play-routes-compiler
// @SOURCE:E:/JsoupWebAPPFinalTEst/JsoupWebAPp/conf/routes
// @DATE:Sat May 20 02:12:34 PKT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:7
    def getPage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getPage",
      """
        function(t) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/url/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("t", encodeURIComponent(t))})
        }
      """
    )
  
  }


}