package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}

/**
  * Created by simar on 8/3/17.
  */
class ProfileController @Inject() extends Controller {

  def profile = Action {
    Ok(views.html.profile())
  }

}