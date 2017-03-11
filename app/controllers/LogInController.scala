package controllers

import play.api.mvc.{Action, Controller}
import javax.inject._

import models.Credentials
import services.DataServer

class LogInController @Inject()( dataServer: DataServer) extends Controller {

  def logIn(userName: String, password: String) = Action { implicit request =>
    //Ok(views.html.logIn())
    val credentials = Credentials(userName, password)
    val isValid = dataServer.validatePerson(credentials)
    if(isValid == 0)
      Ok(views.html.profile(credentials.userName))
    else
      Ok(views.html.welcome())
  }

  /*def validate = Action {
            implicit request => {
              mapping.logInForm.bindFromRequest.fold(
                formWithErrors => {
                  Redirect(routes.LogInController.logIn()).flashing(
                    "error" -> "Something went Wrong Please Try Again Later")
                },
                personData => {
                  val isValidate = dataServer.validatePerson(personData)
                  Console.println("Result of Validation: "+isValidate)
                  if(isValidate == 0) {
                    Redirect(routes.ProfileController.profile()).withSession(
                      "username" -> personData.userName)
                  }
                  else if(isValidate == 1){
                    Redirect(routes.LogInController.logIn()).flashing(
                      "error" -> "No User with this username"
                    )
                  }
                  else {
                    Redirect(routes.LogInController.logIn()).flashing(
                      "error" -> "Wrong password"
                    )
                  }
                }
              )
            }
          }
*/
  }
