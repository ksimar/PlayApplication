package models

case class Person(name: Name, credentials: Credentials, mobileNumber: String, gender: String, age: Int, hobbies: Option[List[String]])
