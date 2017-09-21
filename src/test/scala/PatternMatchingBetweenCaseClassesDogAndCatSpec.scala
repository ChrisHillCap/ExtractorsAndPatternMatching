import org.scalatest.{Matchers, WordSpec}

class PatternMatchingBetweenCaseClassesDogAndCatSpec extends WordSpec with Matchers {

  "patternMatchingBetweenDogsAndCats" should {
    "return true when dog and cat match even though they are different case classes. cat can fetch a ball" in {
      val newDog = Dog("german", true, "white")
      val newCat = Cat("german", "white", true, true)

      PatternMatchingDifferentCaseClasses.patternMatchingBetweenDogsAndCats(Some(newDog), newCat) shouldBe true
    }
    "return false when cat can't fetch a ball because it is not clever enough to be a dog unapply method returns None" in {
      val newDog = Dog("german", true, "white")
      val newCat = Cat("german", "white", true, false)

      PatternMatchingDifferentCaseClasses.patternMatchingBetweenDogsAndCats(Some(newDog), newCat) shouldBe false
    }
  }

  "patternMatchingBetweenDogsAndCatsRefactored" should {
    "return true when dog and cat match even though they are different case classes. cat can fetch a ball" in {
    val newDog = Dog("german", true, "white")
    val newCat = Cat("german", "white", true, true)

    PatternMatchingDifferentCaseClasses.patternMatchingBetweenDogsAndCatsRefactored(newDog, newCat) shouldBe true
  }
    "return false when cat can't fetch a ball because it is not clever enough to be a dog unapply method returns None" in {
      val newDog = Dog("german", true, "white")
      val newCat = Cat("german", "white", true, false)

      PatternMatchingDifferentCaseClasses.patternMatchingBetweenDogsAndCatsRefactored(newDog, newCat) shouldBe false
    }
  }
}
