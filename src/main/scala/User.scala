/**
  * Created by chill on 19/09/2017.
  */
case class User(firstName:String,
                lastName:String,
                userEmail:String,
                age:Int,
                awesome:Boolean)



case class UserWithOverridedUnapply(firstName:String,
                                    lastName:String,
                                    userEmail:String,
                                    age:Int,
                                    awesome:Boolean)

object UserWithOverridedUnapply{

   def unapply(arg: UserWithOverridedUnapply): Option[(String, String, String, Int, Boolean)] = {
      Some((arg.firstName,
            arg.lastName,
            arg.userEmail,
            arg.age,
        if(arg.userEmail.contains("@")) true else false))
    }
  }
