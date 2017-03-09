package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}

class SignUpController @Inject() extends Controller {

  def signUp = Action {
    Ok(views.html.signUp())
  }

//  def savePerson = Action {
//        implicit request =>
//          personForm.bindFromRequest.fold(
//            formWithErrors => {
//              Redirect(routes.SignUpController.signUp()).flashing(
//                "error" -> "Something went Wrong Please Try Again Later")
//            },
//            personData => {
////              DatabaseServer.addPerson(personData)
////              Redirect(routes.HomeController.profile()).withSession(
////                "username" -> userData.uname)
//            }
//          )
//      }



}
