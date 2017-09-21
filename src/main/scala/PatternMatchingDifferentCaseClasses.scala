import scala.concurrent.Future

object PatternMatchingDifferentCaseClasses {

  def patternMatchingBetweenDogsAndCats(doggy:Option[Dog],catty:Cat):Boolean ={
  catToDogExtractor.unapply(catty) match {
      case dog if doggy == dog => {
        println("return true because the cat turned into a dog is the same as the dog passed in (and the cat can fetch a ball)")
        true
      }
      case _ => false
    }

  }

  //refactored method of the one above to show real world application
  def patternMatchingBetweenDogsAndCatsRefactored(doggy:Dog,catty:Cat):Boolean ={
    catToDogExtractor.unapply(catty).map(a => a == doggy).getOrElse(false)
  }
}


case class Dog(breed:String,hasFur:Boolean,colour:String)

case class Cat(breed:String,colour:String,hasFur:Boolean,canFetchABall:Boolean)


object catToDogExtractor{
  def unapply(cat:Cat):Option[Dog] ={

    if(cat.canFetchABall) {
        Some(Dog(cat.breed,cat.hasFur,cat.colour))
      }
    else
      None
  }
}