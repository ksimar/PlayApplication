package models

sealed abstract case class Gender(val genderValue: String)

object Female extends Gender(genderValue = "female")
object Male extends Gender(genderValue = "male")