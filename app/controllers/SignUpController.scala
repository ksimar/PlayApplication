package controllers

import com.google.inject.Inject
import models.{Credentials, Name, Person}
import play.api.mvc.{Action, Controller}
import services.DataServer

class SignUpController @Inject()(mapping: Mapping)(db: DataServer) extends Controller {

  def signUp = Action { implicit request =>
    Ok(views.html.signUp())
  }

  def savePerson = Action {
        implicit request =>
          mapping.personForm.bindFromRequest.fold(
            formWithErrors => {
              Redirect(routes.SignUpController.signUp()).flashing(

                "error" -> formWithErrors.toString)
            },
            personData => {
              db.addPerson(personData)
              Redirect(routes.ProfileController.profile()).withSession(
                "username" -> personData.credentials.userName)
            }
          )
      }


//    def savePerson = Action {
//      val myName2 = Name("Charmy", "Garg", None)
//      val myCredential2 = Credentials("charmy", "charmy")
//      val person2 = Person(myName2, myCredential2, "1234567890", "female", 22, Some(List("Singing")))
//
//      db.addPerson(person2)
//      Redirect(routes.ProfileController.profile()).withSession(
//        "username" -> person2.credentials.userName)
//
//    }
}
