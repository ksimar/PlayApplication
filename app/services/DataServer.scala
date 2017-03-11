package services


import javax.inject.Inject

import models.{Credentials, Person}
import play.api.cache.CacheApi

import scala.collection.mutable.ListBuffer

trait MyServer {
  def validatePerson(credentials: Credentials): Int
  def addPerson(person: Person): Boolean
  def personData(userName: String): Option[Person]
}

class DataServer @Inject()(cache: CacheApi) extends MyServer{
  val dataList: ListBuffer[Person] = ListBuffer()
  val cacheKey = "key"
  cache.set(cacheKey,dataList)

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
    dataList += person
    //cache.set(person.credentials.userName, person)
    cache.remove(cacheKey)
    cache.set(cacheKey, dataList)
    true
  }

  override def personData(userName: String): Option[Person] = {
//    val cacheList = cache.get[ListBuffer[Person]](cacheKey).map(_.filter(person=> person.credentials.userName == userName))
//    val size = cacheList.map(_.size).fold("")(len=>s"size of list is $len")
//    cacheList.fold("not found")(person => person.toString())
//   // val a = cacheList.map(identity)
    val person = cache.get[ListBuffer[Person]](cacheKey).map(identity).getOrElse(ListBuffer())
    val reqPerson = person.filter(_.credentials.userName == userName).headOption
    reqPerson
  }

  def search(userName: String): Boolean = {
    val person = cache.get[ListBuffer[Person]](cacheKey).map(identity).getOrElse(ListBuffer())
    val reqPerson = person.filter(_.credentials.userName == userName)
    if(reqPerson.isEmpty) false
    else true
  }

}
