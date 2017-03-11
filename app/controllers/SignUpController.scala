package controllers

import com.google.inject.Inject
import models.{Credentials, Person}
import play.api.mvc.{Action, Controller}
import services.DataServer

class SignUpController @Inject()(db: DataServer) extends Controller {

//  def signUp = Action { implicit request =>
//    Ok(views.html.signUp())
//  }

  //  def savePerson = Action {
  //        implicit request =>
  //          mapping.personForm.bindFromRequest.fold(
  //            formWithErrors => {
  //              Redirect(routes.SignUpController.signUp()).flashing(
  //
  //                "error" -> formWithErrors.toString)
  //            },
  //            personData => {
  //              db.addPerson(personData)
  //              Redirect(routes.ProfileController.profile()).withSession(
  //                "username" -> personData.credentials.userName)
  //            }
  //          )
  //      }

   def addPerson(fname: String, uname: String, password: String, mobileNumber: String, age: Int) =  {
     Action {
     implicit request =>
       val credentials = Credentials(uname, password)
       val person = Person(fname, credentials, mobileNumber, age)
       if (!db.search(person.credentials.userName)) {
         db.addPerson(person)
         Ok(views.html.profile(person.credentials.userName))
       }
       else Ok(views.html.welcome())
     }

   }

}
