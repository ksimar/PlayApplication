package views

import org.scalatestplus.play.PlaySpec
import play.api.test.Helpers._

class HeaderSpec extends PlaySpec{

  "header" should {
    "set title of the page" in new App {
      val title = "myTitle"
      val html = <HTML><BODY>Hello</BODY></HTML>
      val header = views.html.header(title)(contentAsHtml(html))
      contentAsString(header) contains (title)
      contentAsString(header) contains ("Hello")
    }
  }


}
