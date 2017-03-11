package controllers

import play.api.mvc.{Action, Controller}
import play.api.routing.JavaScriptReverseRouter

class JavascriptRoutesController extends Controller{

  def javascriptRoutes = Action {
    implicit request =>
      Ok(
        JavaScriptReverseRouter("jsRoutes")(
          routes.javascript.SignUpController.signUp

        )
      ).as("text/javascript")
  }

}
