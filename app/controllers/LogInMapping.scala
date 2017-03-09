package controllers

import javax.inject.Inject

import models.Credentials
import play.api.data._
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}


/**
  * Created by dell on 3/8/2017.
  */
class LogInMapping @Inject() extends Controller{

  val logInForm: Form[Credentials] = Form(
    mapping(
      "userName" -> nonEmptyText,
      "password" -> nonEmptyText
    )(Credentials.apply)(Credentials.unapply)
  )

}

