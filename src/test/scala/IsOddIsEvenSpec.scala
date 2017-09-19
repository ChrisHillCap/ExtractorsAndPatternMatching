import org.scalatest.{Matchers, WordSpec}

class IsOddIsEvenSpec extends WordSpec with Matchers {

  "isOdd" should {
    "using a list of Int's match on odd numbers & only and return them" in {

      val listInts: List[Int] = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: 10 :: Nil
      listInts match {
        case isOdd(a) => a shouldBe List(1, 3, 5, 7, 9)
      }
    }
  }

  "isEven" should {
    "return a match error when no even numbers are in a List[Int]" in {

      val listIntsOdd = 1 :: 3 :: 5 :: Nil
      try {
      listIntsOdd match {
        case isEven(a) => {
          println("this line will never run")
          a shouldBe "foo"
        }
      }
        }
      catch{

        case e:MatchError => e.getMessage().contains("3") shouldBe true
      }


    }
  }
}
