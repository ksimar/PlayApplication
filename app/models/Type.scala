package models

/**
  * Created by simar on 9/3/17.
  */
sealed abstract class Type(val t: String)

case object RegularUser extends Type(t = "regularUser")
case object Admin extends Type(t = "admin")


