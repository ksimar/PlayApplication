package controllers

import javax.inject.Inject

import models.{Credentials, Name, Person}
import play.api.data.Forms._
import play.api.data._
import play.api.mvc.Controller
import services.DataServer


class Mapping @Inject()(db: DataServer) extends Controller {

  val personForm: Form[Person] = Form(
    mapping(
      "Name" -> mapping(
        "fName" -> nonEmptyText,
        "lName" -> nonEmptyText,
        "mName" -> optional(text)
      )(Name.apply)(Name.unapply),
      "Credentials" -> mapping(
        "userName" -> nonEmptyText,
        "password" -> nonEmptyText
      )(Credentials.apply)(Credentials.unapply),
      "mobileNumber" -> text, //verifying pattern("""[0-9.+]+""".r, error="A valid phone number is required"),
      "gender" -> text,
      "age" -> number,
      "hobbies" -> optional(list(text))
    )(Person.apply)(Person.unapply)
  )

}
