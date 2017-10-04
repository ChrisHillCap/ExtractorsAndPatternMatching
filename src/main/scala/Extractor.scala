

object Extractor {

  def unapply(user:User): Option[List[String]] =
  if (user.awesome == true) {

    Some(user.firstName ::
      user.lastName ::
      user.userEmail ::
      user.age.toString ::
      user.awesome.toString :: Nil)
  }
  else None
}

object extractor2 {
  def unapply(a:Tuple2[User,User]):Option[String] ={
    if(a._1.awesome == true){
    println(a._2)
      Some("foo")
    }
    else None
  }
}

object extractor3Bool {
  def unapply(a:Boolean) :Option[String] = {
    Some("foosicle")
  }
}