
// @GENERATOR:play-routes-compiler
// @SOURCE:E:/JsoupWebAPPFinalTEst/JsoupWebAPp/conf/routes
// @DATE:Sat May 20 02:12:34 PKT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
