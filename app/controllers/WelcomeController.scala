package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}

class WelcomeController @Inject() extends Controller {

  def welcome = Action {
    Ok(views.html.welcome())
  }

  def signUp = Action {
    Ok(views.html.signUp())
  }

  def logIn = Action {
    Ok(views.html.logIn())
  }

}
