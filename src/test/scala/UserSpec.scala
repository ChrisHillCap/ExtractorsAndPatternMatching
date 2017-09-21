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



}
