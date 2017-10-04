import org.scalatest.{ Matchers, WordSpec}

class UserSpec extends WordSpec with Matchers{

  "User case class." should {
    "unapply and return an Option[Tuple]" in {
      val newUser = User("chris", "hill", "email@domain.com", 24, false)

      User.unapply(newUser) shouldBe Some("chris", "hill", "email@domain.com", 24, false)
    }
  }

  "UserWithOverridedUnapply case class." should {
  "unapply and return an Option[Tuple] & awesome set to true if users email has @ symbol in it" in {
    val newUser = UserWithOverridedUnapply("chris","hill","email@domain.com",24,false)

    UserWithOverridedUnapply.unapply(newUser) shouldBe Some("chris","hill","email@domain.com",24,true)
    }
  }

  "Extractor object" should {
    "unapply the User case class into a List of Strings in an Option" in {
      val newUser = User("chris", "hill", "email@domain.com", 24, true)

      Extractor.unapply(newUser) shouldBe Some(List("chris", "hill", "email@domain.com", "24", "true"))
    }
  }
"extractor2 object" should {
  "unapply with tuple should return match when 2 users are passed into extractor object" in {
    val newUser = User("chris", "hill", "email@domain.com", 24, true)
    val newUser1 = User("chris", "hill", "email@domain.co", 24, true)
    (newUser,newUser1) match{
      case extractor2(a) => println("fooooo")
    }
  }

  "extractor objects inside extractor objects" should {
    "should return correct value" in {
      val newUser = User("chris", "hill", "email@domain.com", 24, true)
      User.unapply(newUser) match {
        case Some((a,b,c,d,extractor3Bool(e))) => println(a + b  + c + d  + e)
      }
    }
  }

}


}
