import org.scalatest.{Matchers, WordSpec}

class ExtractorOnUserMatchingSpec extends WordSpec with Matchers{

  "Extractor object" should {
    "work in a match statement AND match on a user as awesome is true" in {

      val newUser = User("chris", "hill", "email@domain.com", 24, true)
      newUser match {
        case Extractor(a) => {
          println("this is a list of strings" + a)

          a shouldBe List[String]("chris", "hill", "email@domain.com", "24", "true")
        }
      }
    }

    //throws MatchError As Expected
         "work in a match statement BUT not match on a user because awesome is false" in {

        val newUser = User("chris", "hill", "email@domain.com", 24, false)
           try {
             newUser match {
               case Extractor(a) => {
                 println("this line should never be ran")
                 a shouldBe List[String]("chris", "hill", "email@domain.com", "24", "true")}
             }
           }catch{

             case e:MatchError => e.getMessage().contains("chris") shouldBe true
           }
      }
    }



  "default User unapply" should {
    "work in a match statement, matching against an option of tuple" in{
      val newUser = User("chris", "hill", "email@domain.com", 24, true)

      User.unapply(newUser) match {
        case Some((a,b,c,d,e)) => {
          a shouldBe "chris"
          e shouldBe true
        }
      }
    }
  }


}
