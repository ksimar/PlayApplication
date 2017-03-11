package controllers

import play.api.mvc.{Action, Controller}
import play.api.routing.JavaScriptReverseRouter

class JavascriptRoutesController extends Controller{

  def javascriptRoutes = Action {
    implicit request =>
      Ok(
        JavaScriptReverseRouter("jsRoutes")(
          routes.javascript.WelcomeController.signUp,
          routes.javascript.WelcomeController.logIn,
          routes.javascript.LogInController.logIn,
          routes.javascript.WelcomeController.welcome
         // routes.javascript.SignUpController.addPerson
        )
      ).as("text/javascript")
  }

}
