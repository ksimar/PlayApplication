package services


import javax.inject.Inject

import models.{Credentials, Name, Person}
import play.api.cache.CacheApi

trait MyServer {
  def validatePerson(credentials: Credentials): Int
  def addPerson(person: Person): Boolean
}

class DataServer @Inject()(cache: CacheApi) extends MyServer{
  //val dataList: List[Person] = List()


//  def validatePerson(credentials: Credentials): Boolean = {
//    val list = dataList filter (data => (data.credentials.userName == credentials.userName
//      && data.credentials.password == credentials.password))
//    if (list.isEmpty) false
//    else
//    if (list.size == 1) true
//    else {
//      throw new Exception("Should not happen - duplicate userName found")
//    }
//  }
//

  def validatePerson(credentials: Credentials): Int = {
    val user = cache.get[Person](credentials.userName).fold("invalid")(person => person.credentials.password)
    if(user == credentials.password) 0
    else if(user == "invalid") 1
    else 2
  }

  def addPerson(person: Person): Boolean = {
    //val newList = dataList :+ person
    cache.set(person.credentials.userName, person)
    true
  }

}
