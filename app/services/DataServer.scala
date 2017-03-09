package services

import java.awt.Window
import javax.inject.Inject

import models.{Credentials, Name, Person}

/**
  * Created by dell on 3/8/2017.
  */
class DataServer {
  val myName = Name("Simar","monga",Some("kaur"))
  val myCredential = Credentials("simar", "simar")
  val person = Person(myName, myCredential, "1234567890", "female", 22, Some(List("Programming")))

  val dataList: List[Person] = List(person)

  def validatePerson(credentials: Credentials): Boolean = {
    val list = dataList filter (data => (data.credentials.userName == credentials.userName
      && data.credentials.password == credentials.password))
    if (list.isEmpty) false
    else
    if (list.size == 1) true
    else {
      throw new Exception("Should not happen - duplicate userName found")
    }
  }

  def addPerson(person: Person) = {
    dataList :+ person
  }

}