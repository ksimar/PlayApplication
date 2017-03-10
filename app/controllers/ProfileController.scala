package controllers

import com.google.inject.Inject
import models.Person
import play.api.cache.CacheApi
import play.api.mvc.{Action, Controller}
import services.DataServer

class ProfileController @Inject()(cache: CacheApi) extends Controller {

  def profile = Action { implicit request =>
    val userName = request.session.get("username").fold("notFound")(name => name)
    val user = cache.get[Person](userName)
    val fName = user.fold("")(_.name.fName)
    Ok(views.html.profile(fName))
  }

}
