

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

