package views

import org.scalatestplus.play.PlaySpec
import play.api.test.Helpers._

class HeaderSpec extends PlaySpec{

  "header" should {
    "set title of the page" in new App {
      val html = views.html.header("myTitle")

    }
  }


}
