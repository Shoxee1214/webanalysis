
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.17*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <style>
        table, td, th """),format.raw/*8.23*/("""{"""),format.raw/*8.24*/("""
            """),format.raw/*9.13*/("""border: 1px solid #ddd;
            text-align: left;
        """),format.raw/*11.9*/("""}"""),format.raw/*11.10*/("""

        """),format.raw/*13.9*/("""table """),format.raw/*13.15*/("""{"""),format.raw/*13.16*/("""
            """),format.raw/*14.13*/("""border-collapse: collapse;
            width: 70%;
        """),format.raw/*16.9*/("""}"""),format.raw/*16.10*/("""

        """),format.raw/*18.9*/("""th, td """),format.raw/*18.16*/("""{"""),format.raw/*18.17*/("""
            """),format.raw/*19.13*/("""padding: 10px;
        """),format.raw/*20.9*/("""}"""),format.raw/*20.10*/("""
        """),format.raw/*21.9*/("""input[type=text] """),format.raw/*21.26*/("""{"""),format.raw/*21.27*/("""
            """),format.raw/*22.13*/("""width: 50%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        """),format.raw/*29.9*/("""}"""),format.raw/*29.10*/("""

        """),format.raw/*31.9*/("""input[type=submit] """),format.raw/*31.28*/("""{"""),format.raw/*31.29*/("""
            """),format.raw/*32.13*/("""width: 20%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        """),format.raw/*40.9*/("""}"""),format.raw/*40.10*/("""
    """),format.raw/*41.5*/("""</style>
        <title>"""),_display_(/*42.17*/title),format.raw/*42.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*43.54*/routes/*43.60*/.Assets.at("stylesheets/main.css")),format.raw/*43.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*44.59*/routes/*44.65*/.Assets.at("images/favicon.png")),format.raw/*44.97*/("""">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
        <script src=""""),_display_(/*46.23*/routes/*46.29*/.Assets.at("javascripts/jquery-1.9.0.min.js")),format.raw/*46.74*/("""" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function()"""),format.raw/*48.41*/("""{"""),format.raw/*48.42*/("""
                """),format.raw/*49.17*/("""$("#page-source-button").click(function()"""),format.raw/*49.58*/("""{"""),format.raw/*49.59*/("""
                    """),format.raw/*50.21*/("""var tt = $("#source-url-text").val()
                    console.log(tt)
                     var v = "1"

                    $.ajax("""),format.raw/*54.28*/("""{"""),format.raw/*54.29*/("""
                        """),format.raw/*55.25*/("""type: "POST",
                        url: "/api/url/"+ encodeURIComponent(tt),
                        success: function (data) """),format.raw/*57.50*/("""{"""),format.raw/*57.51*/("""
                            """),format.raw/*58.29*/("""if (data.length >=1) """),format.raw/*58.50*/("""{"""),format.raw/*58.51*/("""
                                """),format.raw/*59.33*/("""data = data[0]
                                var col = ['Attribute','Analysis'];
                                Object.keys(data).forEach(function(key) """),format.raw/*61.73*/("""{"""),format.raw/*61.74*/("""

                                """),format.raw/*63.33*/("""}"""),format.raw/*63.34*/(""");
                                // CREATE DYNAMIC TABLE.
                                var table = document.createElement("table");

                                // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.

                                var tr = table.insertRow(-1);                   // TABLE ROW.

                                for (var i = 0; i < col.length; i++) """),format.raw/*71.70*/("""{"""),format.raw/*71.71*/("""
                                    """),format.raw/*72.37*/("""var th = document.createElement("th");      // TABLE HEADER.
                                    th.innerHTML = col[i];
                                    tr.appendChild(th);
                                """),format.raw/*75.33*/("""}"""),format.raw/*75.34*/("""

                                """),format.raw/*77.33*/("""// ADD JSON DATA TO THE TABLE AS ROWS.
                                Object.keys(data).forEach(function(key) """),format.raw/*78.73*/("""{"""),format.raw/*78.74*/("""
                                    """),format.raw/*79.37*/("""tr = table.insertRow(-1);
                                    var tabCell1 = tr.insertCell(-1);
                                    tabCell1.innerHTML = key;
                                    var tabCell2 = tr.insertCell(-1);

                                    console.log(tabCell2)
                                    console.log(typeof data[key])
                                    s = typeof data[key]
                                    console.log (s)
                                    if(s != 'object')
                                        tabCell2.innerHTML = data[key];
                                    else"""),format.raw/*90.41*/("""{"""),format.raw/*90.42*/("""

                                        """),format.raw/*92.41*/("""var innerTable = document.createElement("table");
                                        Object.keys(data[key]).forEach(function(innerKey) """),format.raw/*93.91*/("""{"""),format.raw/*93.92*/("""

                                            """),format.raw/*95.45*/("""var tr1 = innerTable.insertRow(-1);                   // TABLE ROW.
                                            var tabCell1_new = tr1.insertCell(-1);
                                            tabCell1_new.innerHTML = innerKey;
                                            var tabCell2_new = tr1.insertCell(-1);
                                            tabCell2_new.innerHTML = data[key][innerKey];

                                        """),format.raw/*101.41*/("""}"""),format.raw/*101.42*/(""");
                                        tabCell2.appendChild(innerTable)
                                    """),format.raw/*103.37*/("""}"""),format.raw/*103.38*/("""

                                """),format.raw/*105.33*/("""}"""),format.raw/*105.34*/(""");
                            """),format.raw/*106.29*/("""}"""),format.raw/*106.30*/("""


                            """),format.raw/*109.29*/("""// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
                            var divContainer = document.getElementById("showData");
                            divContainer.innerHTML = "";
                            divContainer.appendChild(table);
                            $("#page-source-textarea").val(JSON.stringify(data[0]));
                        """),format.raw/*114.25*/("""}"""),format.raw/*114.26*/(""",
                        data: """),format.raw/*115.31*/("""{"""),format.raw/*115.32*/("""url: $("#source-url-text").val() """),format.raw/*115.65*/("""}"""),format.raw/*115.66*/("""
                    """),format.raw/*116.21*/("""}"""),format.raw/*116.22*/(""");
                """),format.raw/*117.17*/("""}"""),format.raw/*117.18*/(""");
            """),format.raw/*118.13*/("""}"""),format.raw/*118.14*/(""");
        </script>
    </head>
    <body>
        <h1 align="center"> Web Analysis Assignment (Scout24 Scala Developer - Shahroz Haider)</h1>
        <input type="text" placeholder="URL" id="source-url-text"/>
        <input type="submit" id="page-source-button"/><br>

        <div id="showData"></div>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String): play.twirl.api.HtmlFormat.Appendable = apply(title)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (title) => apply(title)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Sat May 20 02:21:47 PKT 2017
                  SOURCE: E:/JsoupWebAPPFinalTEst/JsoupWebAPp/app/views/main.scala.html
                  HASH: 620a1336ce1748dc0ab0832e6c9a480a9a85f706
                  MATRIX: 525->1|635->16|663->18|763->91|791->92|831->105|920->167|949->168|986->178|1020->184|1049->185|1090->198|1176->257|1205->258|1242->268|1277->275|1306->276|1347->289|1397->312|1426->313|1462->322|1507->339|1536->340|1577->353|1822->571|1851->572|1888->582|1935->601|1964->602|2005->615|2263->846|2292->847|2324->852|2376->877|2402->882|2491->944|2506->950|2561->984|2649->1045|2664->1051|2717->1083|2869->1208|2884->1214|2950->1259|3093->1374|3122->1375|3167->1392|3236->1433|3265->1434|3314->1455|3476->1589|3505->1590|3558->1615|3715->1744|3744->1745|3801->1774|3850->1795|3879->1796|3940->1829|4123->1984|4152->1985|4214->2019|4243->2020|4673->2422|4702->2423|4767->2460|5003->2668|5032->2669|5094->2703|5233->2814|5262->2815|5327->2852|5983->3480|6012->3481|6082->3523|6250->3663|6279->3664|6353->3710|6826->4154|6856->4155|6997->4267|7027->4268|7090->4302|7120->4303|7180->4334|7210->4335|7270->4366|7680->4747|7710->4748|7771->4780|7801->4781|7863->4814|7893->4815|7943->4836|7973->4837|8021->4856|8051->4857|8095->4872|8125->4873
                  LINES: 20->1|25->1|27->3|32->8|32->8|33->9|35->11|35->11|37->13|37->13|37->13|38->14|40->16|40->16|42->18|42->18|42->18|43->19|44->20|44->20|45->21|45->21|45->21|46->22|53->29|53->29|55->31|55->31|55->31|56->32|64->40|64->40|65->41|66->42|66->42|67->43|67->43|67->43|68->44|68->44|68->44|70->46|70->46|70->46|72->48|72->48|73->49|73->49|73->49|74->50|78->54|78->54|79->55|81->57|81->57|82->58|82->58|82->58|83->59|85->61|85->61|87->63|87->63|95->71|95->71|96->72|99->75|99->75|101->77|102->78|102->78|103->79|114->90|114->90|116->92|117->93|117->93|119->95|125->101|125->101|127->103|127->103|129->105|129->105|130->106|130->106|133->109|138->114|138->114|139->115|139->115|139->115|139->115|140->116|140->116|141->117|141->117|142->118|142->118
                  -- GENERATED --
              */
          