
case class Animal(breed:String,hasFur:Boolean)

object animalExtractor {

  def unapply(arg: Animal): Option[(String,String)] = Some((arg.breed,arg.hasFur.toString))
}

object testExtractor{

  val an = Animal("dog",true)

  an match {
    case animalExtractor((a,b)) => println("a" + a + "b" + b)
  }
}
/*
object testExtractor extends scala.AnyRef {
    def <init>(): testExtractor.type = {
      testExtractor.super.<init>();
      ()
    };
    private[this] val an: Animal = Animal.apply("dog", true);
    <stable> <accessor> def an: Animal = testExtractor.this.an;
    {
      case <synthetic> val x1: Animal = testExtractor.this.an;
      case6(){
        <synthetic> val o8: Option[(String, String)] = animalExtractor.unapply(x1);
        if (o8.isEmpty.unary_!)
          {
            <synthetic> val p3: (String, String) = o8.get;
            if (p3.ne(null))
              {
                val a: String = p3._1;
                val b: String = p3._2;
                matchEnd5(scala.Predef.println("a".+(a).+("b").+(b)))
              }
            else
              case7()
          }
        else
          case7()
      };
      case7(){
        matchEnd5(throw new MatchError(x1))
      };
      matchEnd5(x: Unit){
        x
      }
    }
  }
}

 */